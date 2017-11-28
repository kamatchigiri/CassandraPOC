package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType
public class Ean {

	 
	    private int ean_nbr;
	    private int ean_count;
	    private Address address;
	    
		public int getEan_nbr() {
			return ean_nbr;
		}
		public void setEan_nbr(int ean_nbr) {
			this.ean_nbr = ean_nbr;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public int getEan_count() {
			return ean_count;
		}
		public void setEan_count(int ean_count) {
			this.ean_count = ean_count;
		}
	    
	   
	}

	

