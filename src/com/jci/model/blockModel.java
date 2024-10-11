package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[tbl_Blocks]", schema = "dbo")

public class blockModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "block_name")
	private String Block_Name ;

	@Column(name = "district_id")
	private int district_id;



	public String getBlock_Name() {
		return Block_Name;
	}

	public void setBlock_Name(String Block_Name) {
		this.Block_Name = Block_Name;
	}

	public int getdistrict_id() {
		return district_id;
	}

	public void setdistrict_id(int district_id) {
		this.district_id = district_id;
	}


}
