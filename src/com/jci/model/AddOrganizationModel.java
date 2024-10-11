package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciorg", schema = "dbo")
public class AddOrganizationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orgid")
	private int orgid;

	@Column(name = "organizationtypedisplayname")
	private String organizationtypedisplayname;

	@Column(name = "organizationtypename")
	private String organizationtypename;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "is_Active")
	private int is_Active;

	@Column(name = "ipaddress")
	private String ipaddress;

	public AddOrganizationModel() {

	}

	public AddOrganizationModel(int orgid, String organizationtypedisplayname, String organizationtypename,
			Date createddate, int is_Active, String ipaddress) {

		this.orgid = orgid;
		this.organizationtypedisplayname = organizationtypedisplayname;
		this.organizationtypename = organizationtypename;
		this.createddate = createddate;
		this.is_Active = is_Active;
		this.ipaddress = ipaddress;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getOrganizationtypedisplayname() {
		return organizationtypedisplayname;
	}

	public void setOrganizationtypedisplayname(String organizationtypedisplayname) {
		this.organizationtypedisplayname = organizationtypedisplayname;
	}

	public String getOrganizationtypename() {
		return organizationtypename;
	}

	public void setOrganizationtypename(String organizationtypename) {
		this.organizationtypename = organizationtypename;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public int getIs_Active() {
		return is_Active;
	}

	public void setIs_Active(int is_Active) {
		this.is_Active = is_Active;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "AddOrganizationModel [orgid=" + orgid + ", organizationtypedisplayname=" + organizationtypedisplayname
				+ ", organizationtypename=" + organizationtypename + ", createddate=" + createddate + ", is_Active="
				+ is_Active + ", ipaddress=" + ipaddress + "]";
	}


}
