package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FarmerRegModelDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="F_ID")
	private int F_ID;

	@Column(name="F_NAME")
	private String F_NAME;

	@Column(name="F_ADDRESS")
	private String F_ADDRESS;

	public FarmerRegModelDTO(int f_ID, String f_NAME, String f_ADDRESS, String f_MOBILE, String f_ID_PROF,
			String f_ID_PROF_NO, String f_REG_BY, String f_I_CARE_REGISTERED, String f_LAND_C_LY, String f_LAND_C_TY,
			String f_BANK_NAME, String f_BANK_BRANCH, String f_BANK_IFSC, String f_AC_NO, String f_DOC_PATH,
			String f_BANK_DOC, int iS_VERIFIED, String f_UPDATED_BY, Date f_VERFIED_DATE, Date f_CREATED_DATE,
			String f_REG_NO, String yield_received_last_year, String bank_ac_type, String gender, String caste,
			String f_DOC_Mandate, int verficationid, String regno, String ifsccode, String accountno, String farmername,
			String address, int status, Date verificationdate, int retrycount) {
		super();
		F_ID = f_ID;
		F_NAME = f_NAME;
		F_ADDRESS = f_ADDRESS;
		F_MOBILE = f_MOBILE;
		F_ID_PROF = f_ID_PROF;
		F_ID_PROF_NO = f_ID_PROF_NO;
		F_REG_BY = f_REG_BY;
		F_I_CARE_REGISTERED = f_I_CARE_REGISTERED;
		F_LAND_C_LY = f_LAND_C_LY;
		F_LAND_C_TY = f_LAND_C_TY;
		F_BANK_NAME = f_BANK_NAME;
		F_BANK_BRANCH = f_BANK_BRANCH;
		F_BANK_IFSC = f_BANK_IFSC;
		F_AC_NO = f_AC_NO;
		F_DOC_PATH = f_DOC_PATH;
		F_BANK_DOC = f_BANK_DOC;
		IS_VERIFIED = iS_VERIFIED;
		F_UPDATED_BY = f_UPDATED_BY;
		F_VERFIED_DATE = f_VERFIED_DATE;
		F_CREATED_DATE = f_CREATED_DATE;
		F_REG_NO = f_REG_NO;
		this.yield_received_last_year = yield_received_last_year;
		this.bank_ac_type = bank_ac_type;
		this.gender = gender;
		this.caste = caste;
		F_DOC_Mandate = f_DOC_Mandate;
		this.verficationid = verficationid;
		this.regno = regno;
		this.ifsccode = ifsccode;
		this.accountno = accountno;
		this.farmername = farmername;
		this.address = address;
		this.status = status;
		this.verificationdate = verificationdate;
		this.retrycount = retrycount;
	}

	public String getF_DOC_Mandate() {
		return F_DOC_Mandate;
	}

	public void setF_DOC_Mandate(String f_DOC_Mandate) {
		F_DOC_Mandate = f_DOC_Mandate;
	}

	@Column(name="F_MOBILE")
	private String F_MOBILE;

	@Column(name="F_ID_PROF")
	private String F_ID_PROF;

	@Column(name="F_ID_PROF_NO")
	private String F_ID_PROF_NO;

	@Column(name="F_REG_BY")
	private String F_REG_BY;

	@Column(name="F_I_CARE_REGISTERED")
	private String F_I_CARE_REGISTERED;

	@Column(name="F_LAND_C_LY")
	private String F_LAND_C_LY;

    @Column(name="F_LAND_C_TY")
	private String F_LAND_C_TY;

	@Column(name="F_BANK_NAME")
	private String F_BANK_NAME;

	@Column(name="F_BANK_BRANCH")
	private String F_BANK_BRANCH;

	@Column(name="F_BANK_IFSC")
	private String F_BANK_IFSC;

	@Column(name="F_AC_NO")
	private String F_AC_NO;

	@Column(name="F_DOC_PATH")
	private String F_DOC_PATH;

	@Column(name="F_BANK_DOC")
	private String  F_BANK_DOC;

	@Column(name="IS_VERIFIED")
	private int IS_VERIFIED;

	@Column(name="F_UPDATED_BY")
	private String F_UPDATED_BY;

	@Column(name="F_VERFIED_DATE")
	private Date F_VERFIED_DATE;

	@Column(name="F_CREATED_DATE")
	private Date F_CREATED_DATE;

	@Column(name="F_REG_NO")
	private String F_REG_NO;

	@Column(name="yield_received_last_year")
	private String yield_received_last_year;

	@Column(name="bank_ac_type")
	private String bank_ac_type;

	@Column(name="gender")
	private String gender;

	@Column(name="caste")
	private String caste;

	@Column(name="F_DOC_Mandate")
	private String F_DOC_Mandate;

	private int verficationid;

	private String regno;

	private String ifsccode;

	private String accountno;

	private String farmername;

	private String address;

	private int status;

	private Date verificationdate;

	private int retrycount;

	private String state;

	private String district;

	private String block;
	
	private int Mandate_flag;

	public FarmerRegModelDTO() {

	}

	

	public int getVerficationid() {
		return verficationid;
	}

	public FarmerRegModelDTO(int f_ID, String f_NAME, String f_ADDRESS, String f_MOBILE, String f_ID_PROF,
			String f_ID_PROF_NO, String f_REG_BY, String f_I_CARE_REGISTERED, String f_LAND_C_LY, String f_LAND_C_TY,
			String f_BANK_NAME, String f_BANK_BRANCH, String f_BANK_IFSC, String f_AC_NO, String f_DOC_PATH,
			String f_BANK_DOC, int iS_VERIFIED, String f_UPDATED_BY, Date f_VERFIED_DATE, Date f_CREATED_DATE,
			String f_REG_NO, String yield_received_last_year, String bank_ac_type, String gender, String caste,
			String f_DOC_Mandate, int verficationid, String regno, String ifsccode, String accountno, String farmername,
			String address, int status, Date verificationdate, int retrycount, String state, String district,
			String block, int mandate_flag) {
		super();
		F_ID = f_ID;
		F_NAME = f_NAME;
		F_ADDRESS = f_ADDRESS;
		F_MOBILE = f_MOBILE;
		F_ID_PROF = f_ID_PROF;
		F_ID_PROF_NO = f_ID_PROF_NO;
		F_REG_BY = f_REG_BY;
		F_I_CARE_REGISTERED = f_I_CARE_REGISTERED;
		F_LAND_C_LY = f_LAND_C_LY;
		F_LAND_C_TY = f_LAND_C_TY;
		F_BANK_NAME = f_BANK_NAME;
		F_BANK_BRANCH = f_BANK_BRANCH;
		F_BANK_IFSC = f_BANK_IFSC;
		F_AC_NO = f_AC_NO;
		F_DOC_PATH = f_DOC_PATH;
		F_BANK_DOC = f_BANK_DOC;
		IS_VERIFIED = iS_VERIFIED;
		F_UPDATED_BY = f_UPDATED_BY;
		F_VERFIED_DATE = f_VERFIED_DATE;
		F_CREATED_DATE = f_CREATED_DATE;
		F_REG_NO = f_REG_NO;
		this.yield_received_last_year = yield_received_last_year;
		this.bank_ac_type = bank_ac_type;
		this.gender = gender;
		this.caste = caste;
		F_DOC_Mandate = f_DOC_Mandate;
		this.verficationid = verficationid;
		this.regno = regno;
		this.ifsccode = ifsccode;
		this.accountno = accountno;
		this.farmername = farmername;
		this.address = address;
		this.status = status;
		this.verificationdate = verificationdate;
		this.retrycount = retrycount;
		this.state = state;
		this.district = district;
		this.block = block;
		Mandate_flag = mandate_flag;
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

	public int getRetrycount() {
		return retrycount;
	}

	public void setRetrycount(int retrycount) {
		this.retrycount = retrycount;
	}

	public int getF_ID() {
		return F_ID;
	}

	public void setF_ID(int f_ID) {
		F_ID = f_ID;
	}


	public String getF_NAME() {
		return F_NAME;
	}

	public void setF_NAME(String f_NAME) {
		F_NAME = f_NAME;
	}

	public String getF_ADDRESS() {
		return F_ADDRESS;
	}


	public void setF_ADDRESS(String f_ADDRESS) {
		F_ADDRESS = f_ADDRESS;
	}


	public String getF_MOBILE() {
		return F_MOBILE;
	}


	public void setF_MOBILE(String f_MOBILE) {
		F_MOBILE = f_MOBILE;
	}


	public String getF_ID_PROF() {
		return F_ID_PROF;
	}


	public void setF_ID_PROF(String f_ID_PROF) {
		F_ID_PROF = f_ID_PROF;
	}


	public String getF_ID_PROF_NO() {
		return F_ID_PROF_NO;
	}


	public void setF_ID_PROF_NO(String f_ID_PROF_NO) {
		F_ID_PROF_NO = f_ID_PROF_NO;
	}


	public String getF_REG_BY() {
		return F_REG_BY;
	}


	public void setF_REG_BY(String f_REG_BY) {
		F_REG_BY = f_REG_BY;
	}


	public String getF_I_CARE_REGISTERED() {
		return F_I_CARE_REGISTERED;
	}


	public void setF_I_CARE_REGISTERED(String f_I_CARE_REGISTERED) {
		F_I_CARE_REGISTERED = f_I_CARE_REGISTERED;
	}


	public String getF_LAND_C_LY() {
		return F_LAND_C_LY;
	}


	public void setF_LAND_C_LY(String f_LAND_C_LY) {
		F_LAND_C_LY = f_LAND_C_LY;
	}


	public String getF_LAND_C_TY() {
		return F_LAND_C_TY;
	}


	public void setF_LAND_C_TY(String f_LAND_C_TY) {
		F_LAND_C_TY = f_LAND_C_TY;
	}


	public String getF_BANK_NAME() {
		return F_BANK_NAME;
	}


	public void setF_BANK_NAME(String f_BANK_NAME) {
		F_BANK_NAME = f_BANK_NAME;
	}


	public String getF_BANK_BRANCH() {
		return F_BANK_BRANCH;
	}


	public void setF_BANK_BRANCH(String f_BANK_BRANCH) {
		F_BANK_BRANCH = f_BANK_BRANCH;
	}


	public String getF_BANK_IFSC() {
		return F_BANK_IFSC;
	}


	public void setF_BANK_IFSC(String f_BANK_IFSC) {
		F_BANK_IFSC = f_BANK_IFSC;
	}


	public String getF_AC_NO() {
		return F_AC_NO;
	}


	public void setF_AC_NO(String f_AC_NO) {
		F_AC_NO = f_AC_NO;
	}


	public String getF_DOC_PATH() {
		return F_DOC_PATH;
	}


	public void setF_DOC_PATH(String f_DOC_PATH) {
		F_DOC_PATH = f_DOC_PATH;
	}


	public String getF_BANK_DOC() {
		return F_BANK_DOC;
	}


	public void setF_BANK_DOC(String f_BANK_DOC) {
		F_BANK_DOC = f_BANK_DOC;
	}


	public int getIS_VERIFIED() {
		return IS_VERIFIED;
	}


	public void setIS_VERIFIED(int iS_VERIFIED) {
		IS_VERIFIED = iS_VERIFIED;
	}


	public String getF_UPDATED_BY() {
		return F_UPDATED_BY;
	}


	public void setF_UPDATED_BY(String f_UPDATED_BY) {
		F_UPDATED_BY = f_UPDATED_BY;
	}


	public Date getF_VERFIED_DATE() {
		return F_VERFIED_DATE;
	}


	public void setF_VERFIED_DATE(Date f_VERFIED_DATE) {
		F_VERFIED_DATE = f_VERFIED_DATE;
	}


	public Date getF_CREATED_DATE() {
		return F_CREATED_DATE;
	}


	public void setF_CREATED_DATE(Date f_CREATED_DATE) {
		F_CREATED_DATE = f_CREATED_DATE;
	}


	public String getF_REG_NO() {
		return F_REG_NO;
	}


	public void setF_REG_NO(String f_REG_NO) {
		F_REG_NO = f_REG_NO;
	}


	public String getYield_received_last_year() {
		return yield_received_last_year;
	}


	public void setYield_received_last_year(String yield_received_last_year) {
		this.yield_received_last_year = yield_received_last_year;
	}


	public String getBank_ac_type() {
		return bank_ac_type;
	}


	public void setBank_ac_type(String bank_ac_type) {
		this.bank_ac_type = bank_ac_type;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "FarmerRegModelDTO [F_ID=" + F_ID + ", F_NAME=" + F_NAME + ", F_ADDRESS=" + F_ADDRESS + ", F_MOBILE="
				+ F_MOBILE + ", F_ID_PROF=" + F_ID_PROF + ", F_ID_PROF_NO=" + F_ID_PROF_NO + ", F_REG_BY=" + F_REG_BY
				+ ", F_I_CARE_REGISTERED=" + F_I_CARE_REGISTERED + ", F_LAND_C_LY=" + F_LAND_C_LY + ", F_LAND_C_TY="
				+ F_LAND_C_TY + ", F_BANK_NAME=" + F_BANK_NAME + ", F_BANK_BRANCH=" + F_BANK_BRANCH + ", F_BANK_IFSC="
				+ F_BANK_IFSC + ", F_AC_NO=" + F_AC_NO + ", F_DOC_PATH=" + F_DOC_PATH + ", F_BANK_DOC=" + F_BANK_DOC
				+ ", IS_VERIFIED=" + IS_VERIFIED + ", F_UPDATED_BY=" + F_UPDATED_BY + ", F_VERFIED_DATE="
				+ F_VERFIED_DATE + ", F_CREATED_DATE=" + F_CREATED_DATE + ", F_REG_NO=" + F_REG_NO
				+ ", yield_received_last_year=" + yield_received_last_year + ", bank_ac_type=" + bank_ac_type
				+ ", gender=" + gender + ", caste=" + caste + ", F_DOC_Mandate=" + F_DOC_Mandate + ", verficationid="
				+ verficationid + ", regno=" + regno + ", ifsccode=" + ifsccode + ", accountno=" + accountno
				+ ", farmername=" + farmername + ", address=" + address + ", status=" + status + ", verificationdate="
				+ verificationdate + ", retrycount=" + retrycount + ", state=" + state + ", district=" + district
				+ ", block=" + block + ", Mandate_flag=" + Mandate_flag + "]";
	}

	public int getMandate_flag() {
		return Mandate_flag;
	}

	public void setMandate_flag(int mandate_flag) {
		Mandate_flag = mandate_flag;
	}

	

}
