package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType
public class Flty {

	 
	    private int flty_nbr;
	    private Address address;
	    private Ean ean; 
	    private int ean_count;
	    private String cntry_cd;
		public int getFlty_nbr() {
			return flty_nbr;
		}
		public void setFlty_nbr(int flty_nbr) {
			this.flty_nbr = flty_nbr;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public Ean getEan() {
			return ean;
		}
		public void setEan(Ean ean) {
			this.ean = ean;
		}
		public int getEan_count() {
			return ean_count;
		}
		public void setEan_count(int ean_count) {
			this.ean_count = ean_count;
		}
		public String getCntry_cd() {
			return cntry_cd;
		}
		public void setCntry_cd(String cntry_cd) {
			this.cntry_cd = cntry_cd;
		}
	    
		
	}

	

