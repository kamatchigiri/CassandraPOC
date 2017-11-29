package ecdc.springframework.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.cassandra.core.keyspace.DropKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.mapping.SimpleUserTypeResolver;

/**
 * Created by jt on 10/6/17.
 */
@Configuration
@ConfigurationProperties
public class CassandraConfig extends AbstractCassandraConfiguration {

   
	 @Value("${cassandra.keyspace}")
	 private String keyspace; 
	 
	 @Value("${cassandra.contact-points}")
	 private String contactPoints;
	 
	 @Value("${cassandra.port}")
	 private String port;
	 
		    
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    	System.out.println("Environment" + keyspace);
    	CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspace);        
        return Arrays.asList(specification);
    }
  

	/**
	 * @return
	 */
	@Bean
	public CassandraClusterFactoryBean cluster() {
		//LOGGER.info("CassandraUtil  -- cluster start");
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(getContactPoints());
		cluster.setPort(Integer.parseInt(port));
		//LOGGER.info("CassandraUtil  -- cluster end");
		return cluster;
	}
	
	@Bean
	public CassandraMappingContext mappingContext() {
		BasicCassandraMappingContext mappingContext = new BasicCassandraMappingContext();
		mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(),getKeyspaceName()));
		return mappingContext;
	}

	
	@Bean
	public CassandraConverter converter() {
		return new MappingCassandraConverter(mappingContext());
	}

	/**
	 * @return
	 */
	@Bean
	public CassandraSessionFactoryBean session() {
		CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
		cassandraSessionFactoryBean.setCluster(cluster().getObject());
		cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
		cassandraSessionFactoryBean.setConverter(converter());
		
		cassandraSessionFactoryBean.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
		return cassandraSessionFactoryBean;
	}

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(keyspace));
    }

    @Override
    protected String getKeyspaceName() {
       // return KEYSPACE;
    	return keyspace;
    }
    
    @Override
    protected String getContactPoints()
    {
    	return contactPoints;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"ecdc.springframework.domain"};
    }
}
