package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType

public class Subgrp {

	 
	    private int subgrp_id;
	    private Flty facility;
	    private int ean_count;
	    private String cntry_cd;
		public int getSubgrp_id() {
			return subgrp_id;
		}
		public void setSubgrp_id(int subgrp_id) {
			this.subgrp_id = subgrp_id;
		}
		public Flty getFlty() {
			return facility;
		}
		public void setFlty(Flty facility) {
			this.facility = facility;
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

	

