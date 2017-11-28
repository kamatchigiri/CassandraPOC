package ecdc.springframework.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType
public class Grp {

	 
	    private int grp_id;
	    private Subgrp subgrp;
	    private int ean_count;
	    private String cntry_cd;
		public int getGrp_id() {
			return grp_id;
		}
		public void setGrp_id(int grp_id) {
			this.grp_id = grp_id;
		}
		public Subgrp getSubgrp() {
			return subgrp;
		}
		public void setSubgrp(Subgrp subgrp) {
			this.subgrp = subgrp;
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

	

