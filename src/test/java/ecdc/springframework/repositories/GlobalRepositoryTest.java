package ecdc.springframework.repositories;

import ecdc.springframework.domain.Address;
import ecdc.springframework.domain.Cntry;
import ecdc.springframework.domain.Division;
import ecdc.springframework.domain.Ean;
import ecdc.springframework.domain.Flty;
import ecdc.springframework.domain.Global;
import ecdc.springframework.domain.Grp;
import ecdc.springframework.domain.Subgrp;
import ecdc.springframework.repositories.GlobalRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GlobalRepositoryTest {

    @Autowired
    private GlobalRepository globalRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
		// given
    	int count =1;
		Global global = new Global();
		Address add = new Address();
		add.setPostal("12345");
		add.setState("BOSTON");
		add.setTelephone("123478685");
		add.setAddress("Nex Square");
		add.setCity("TEXAS");
		add.setCountry("US");

		Ean ean = new Ean();
		ean.setEan_nbr(1000);
		ean.setAddress(add);
		ean.setEan_count(count);

		Flty flty = new Flty();
		flty.setAddress(add);
		flty.setEan(ean);
		flty.setFlty_nbr(1);
		flty.setEan_count(count);
		flty.setCntry_cd("98765");

		Subgrp sgrp = new Subgrp();
		sgrp.setSubgrp_id(1);
		sgrp.setFlty(flty);
		sgrp.setEan_count(count);
		sgrp.setCntry_cd("98765");

		Grp grp = new Grp();
		grp.setGrp_id(1);
		grp.setSubgrp(sgrp);
		grp.setEan_count(count);
		grp.setCntry_cd("98765");

		Cntry country = new Cntry();
		country.setAddress(add);
		country.setCntry_id(1);
		country.setGrp(grp);
		country.setEan_count(count);
		country.setCntry_cd("98765");

		Division div = new Division();
		div.setAddress(add);
		div.setCntry(country);
		div.setDiv_id(1);
		div.setEan_count(count);

		// global.setId(100);
		global.setAddress(add);
		global.setName("Narm");
		global.setId("1003");
		global.setDivision(div);
		global.setEan_count(count);

		// when
		globalRepository.save(global);

		Global g1 = globalRepository.getById("1002");
		//System.out.println("G1:::::::::::::::::::" + g1.getId() + g1.getName()+ g1.getAddress());

		// then
		Assert.assertNotNull(globalRepository.getById("1002"));
    }
}