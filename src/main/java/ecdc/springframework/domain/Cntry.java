package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType
public class Cntry {

	 
	    private int cntry_id;
	    private Grp grp;
	    private Address address; 
	    private int ean_count;
	    private String cntry_cd;
		public int getCntry_id() {
			return cntry_id;
		}
		public void setCntry_id(int cntry_id) {
			this.cntry_id = cntry_id;
		}
		public Grp getGrp() {
			return grp;
		}
		public void setGrp(Grp grp) {
			this.grp = grp;
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
		public String getCntry_cd() {
			return cntry_cd;
		}
		public void setCntry_cd(String cntry_cd) {
			this.cntry_cd = cntry_cd;
		}
		
		
	}

	

