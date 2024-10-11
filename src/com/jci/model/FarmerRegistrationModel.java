package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "jciinfo", schema = "dbo")
public class FarmerRegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "infoid")
	private int infoid;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "useremail")
	private String useremail ;

	@Column(name = "roleid")
	private int roleid ;

	@Column(name = "orgid")
	private int orgid ;

	@Column(name = "createddate")
	private Date createddate ;

	@Column(name = "mobileno")
	private String mobileno ;

	@Column(name = "status")
	private int status ;

	@Column(name = "enabled")
	private int enabled ;

	@Column(name = "infoupdate")
	private Date infoupdate;

	@Column(name = "city")
	private String city ;

	@Column(name = "state")
	private String state ;

	@Column(name = "majorwork")
	private String majorwork ;

	@Column(name = "ipaddress")
	private String ipaddress ;

	@Column(name = "dpc_id")
	private String dpc_id ;
	
	public FarmerRegistrationModel() {

	}

	

	public FarmerRegistrationModel(int infoid, String firstname, String lastname, String useremail, int roleid,
			int orgid, Date createddate, String mobileno, int status, int enabled, Date infoupdate, String city,
			String state, String majorwork, String ipaddress, String dpc_id) {
		super();
		this.infoid = infoid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.roleid = roleid;
		this.orgid = orgid;
		this.createddate = createddate;
		this.mobileno = mobileno;
		this.status = status;
		this.enabled = enabled;
		this.infoupdate = infoupdate;
		this.city = city;
		this.state = state;
		this.majorwork = majorwork;
		this.ipaddress = ipaddress;
		this.dpc_id = dpc_id;
	}



	public String getDpc_id() {
		return dpc_id;
	}



	public void setDpc_id(String dpc_id) {
		this.dpc_id = dpc_id;
	}



	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getRoleid() {
		return roleid;
	}

	public Date getInfoupdate() {
		return infoupdate;
	}

	public void setInfoupdate(Date infoupdate) {
		this.infoupdate = infoupdate;
	}



	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
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

	public String getMajorwork() {
		return majorwork;
	}

	public void setMajorwork(String majorwork) {
		this.majorwork = majorwork;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}



	@Override
	public String toString() {
		return "FarmerRegistrationModel [infoid=" + infoid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", useremail=" + useremail + ", roleid=" + roleid + ", orgid=" + orgid + ", createddate="
				+ createddate + ", mobileno=" + mobileno + ", status=" + status + ", enabled=" + enabled
				+ ", infoupdate=" + infoupdate + ", city=" + city + ", state=" + state + ", majorwork=" + majorwork
				+ ", ipaddress=" + ipaddress + ", dpc_id=" + dpc_id + "]";
	}

	
}
