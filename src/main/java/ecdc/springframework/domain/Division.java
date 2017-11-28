package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType
public class Division {

	 
	    private int div_id;
	    private Cntry cntry;
	    private Address address;
	    private int ean_count;
		public int getDiv_id() {
			return div_id;
		}
		public void setDiv_id(int div_id) {
			this.div_id = div_id;
		}
		public Cntry getCntry() {
			return cntry;
		}
		public void setCntry(Cntry cntry) {
			this.cntry = cntry;
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

	

