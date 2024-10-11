package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcifarmerverification", schema = "dbo")
public class VerifyFarmerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verficationid")
	private int verficationid;

	@Column(name = "regno")
	private String regno;

	@Column(name="ifsccode")
	private String ifsccode;

	@Column(name="accountno")
	private String accountno;

	@Column(name="farmername")
	private String farmername;

	@Column(name="address")
	private String address;

	@Column(name="status")
	private int status;

	@Column(name="verificationdate")
	private Date verificationdate;

	@Column(name="identity_proof_type")
	private String identityProofType;

	@Column(name="identity_proof_number")
	private String identityProofNumber;

	public VerifyFarmerModel() {

	}

	public VerifyFarmerModel(int verficationid, String regno, String ifsccode, String accountno, String farmername,
			String address, int status, Date verificationdate) {
		this.verficationid = verficationid;
		this.regno = regno;
		this.ifsccode = ifsccode;
		this.accountno = accountno;
		this.farmername = farmername;
		this.address = address;
		this.status = status;
		this.verificationdate = verificationdate;
	}

	public int getVerficationid() {
		return verficationid;
	}

	public void setVerficationid(int verficationid) {
		this.verficationid = verficationid;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public VerifyFarmerModel(int verficationid, String regno, String ifsccode, String accountno, String farmername,
			String address, int status, Date verificationdate, String identityProofType, String identityProofNumber) {
		super();
		this.verficationid = verficationid;
		this.regno = regno;
		this.ifsccode = ifsccode;
		this.accountno = accountno;
		this.farmername = farmername;
		this.address = address;
		this.status = status;
		this.verificationdate = verificationdate;
		this.identityProofType = identityProofType;
		this.identityProofNumber = identityProofNumber;
	}

	public String getIdentityProofType() {
		return identityProofType;
	}

	public void setIdentityProofType(String identityProofType) {
		this.identityProofType = identityProofType;
	}

	public String getIdentityProofNumber() {
		return identityProofNumber;
	}

	public void setIdentityProofNumber(String identityProofNumber) {
		this.identityProofNumber = identityProofNumber;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getFarmername() {
		return farmername;
	}

	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getVerificationdate() {
		return verificationdate;
	}

	public void setVerificationdate(Date verificationdate) {
		this.verificationdate = verificationdate;
	}

	@Override
	public String toString() {
		return "VerifyFarmerModel [verficationid=" + verficationid + ", regno=" + regno + ", ifsccode=" + ifsccode
				+ ", accountno=" + accountno + ", farmername=" + farmername + ", address=" + address + ", status="
				+ status + ", verificationdate=" + verificationdate + ", identityProofType=" + identityProofType
				+ ", identityProofNumber=" + identityProofNumber + "]";
	}
}

