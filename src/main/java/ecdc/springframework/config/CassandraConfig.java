package ecdc.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.cassandra.core.keyspace.DropKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.mapping.SimpleUserTypeResolver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jt on 10/6/17.
 */
@Configuration
@PropertySource(value = { "classpath:ecdcapplication.properties" })
public class CassandraConfig extends AbstractCassandraConfiguration {

   // public static final String KEYSPACE = "CVM_Graphs";

	 public static final String KEYSPACE ="cassandra.keyspace";
	 public static final String CONTACTPOINTS="cassandra.contact-points";
	 public static final String PORT="cassandra.port";
	 
	 @Autowired
	    private Environment environment;
	    
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(environment.getProperty(KEYSPACE));
        System.out.println("Environemnt" + environment.getProperty(KEYSPACE));
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
		cluster.setPort(Integer.parseInt(environment.getProperty(PORT)));
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
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getKeyspaceName() {
       // return KEYSPACE;
    	return environment.getProperty(KEYSPACE);
    }
    
    @Override
    protected String getContactPoints()
    {
    	return environment.getProperty(CONTACTPOINTS);
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"ecdc.springframework.domain"};
    }
}
