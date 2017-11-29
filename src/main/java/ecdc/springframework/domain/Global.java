package ecdc.springframework.domain;

import com.datastax.driver.core.DataType;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import java.io.Serializable;

/**
 * Created by jt on 1/10/17.
 */
@Table("globals")
public class Global implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
    @CassandraType(type = DataType.Name.TEXT)
    private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;
    private Address address;
    private Division division;
    private int ean_count;

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


 
    public Global() {
       // id = UUID.randomUUID();
    }

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public int getEan_count() {
		return ean_count;
	}

	public void setEan_count(int ean_count) {
		this.ean_count = ean_count;
	}


	
}
