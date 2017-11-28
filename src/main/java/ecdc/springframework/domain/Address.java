package ecdc.springframework.domain;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.UserDefinedType;

import com.datastax.driver.core.DataType;

@UserDefinedType
public class Address {

	 
	    private String address;
	    private String city;
	    private String state;
	    private String postal;
	    private String telephone;
	    private String country;
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPostal() {
			return postal;
		}
		public void setPostal(String postal) {
			this.postal = postal;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	    
	   
	}

	

