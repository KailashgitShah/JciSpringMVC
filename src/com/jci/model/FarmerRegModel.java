package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="jcirmt", schema="dbo")
public class FarmerRegModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="F_ID")
	private int F_ID;

	@Column(name="F_NAME")
	private String F_NAME;

	@Column(name="caste")
	private String caste;

	@Column(name="gender")
	private String gender;

	@Column(name="F_ADDRESS")
	private String F_ADDRESS;

	@Column(name="identity_type")
	private String F_ID_PROF_TYPE;


	@Column(name="F_Block")
	private String F_Block;

	@Column(name="F_ID_PROF")
	private String F_ID_PROF;

	@Column(name="F_ID_PROF_NO")
	private String F_ID_PROF_NO;

	@Column(name="F_REG_BY")
	private String F_REG_BY;

	@Column(name="F_STATE")
	private String F_STATE;
	
	@Transient
	private String State_name;

	@Column(name="F_District")
	private String F_District;
	
	@Transient
	private String district_name;

	@Column(name="F_UPDATE_DATE")
	private Date F_UPDATE_DATE;

	@Column(name="F_I_CARE_REGISTERED")
	private String F_I_CARE_REGISTERED;

	@Column(name="F_LAND_C_LY")
	private String land_holding;

	@Column(name="F_MOBILE")
	private String F_MOBILE;

	@Column(name="F_AC_NO")
	private String F_AC_NO;

	@Column(name="bank_ac_type")
	private String bank_ac_type;

	@Column(name="F_BANK_NAME")
	private String F_BANK_NAME;

	@Column(name="F_BANK_BRANCH")
	private String F_BANK_BRANCH;

	@Column(name="F_BANK_IFSC")
	private String F_BANK_IFSC;

	@Column(name="F_BANK_DOC")
	private String F_BANK_DOC;

	@Column(name="F_REG_FORM")
	private String F_REG_FORM;

	@Column(name="F_DOC_PATH")
	private String F_DOC_PATH;

	@Column(name="F_REG_NO")
	private String F_REG_NO;

	@Column(name="F_DOC_Mandate")
	private String F_DOC_Mandate;

	@Column(name="F_VERFIED_DATE")
	private Date F_VERFIED_DATE;

	@Column(name="F_Address2")
	private String F_Address2;

	@Column(name="F_Pincode")
	private String F_Pincode;

	@Column(name="IS_VERIFIED")
	private int IS_VERIFIED;


	@Column(name = "dpc_id")
	private String dpc_id ; 
	
	@Column(name="police_station")
	private String police_station;

	public int getIS_VERIFIED() {
		return IS_VERIFIED;
	}

	public void setIS_VERIFIED(int iS_VERIFIED) {
		IS_VERIFIED = iS_VERIFIED;
	}

	public Date getF_UPDATE_DATE() {
		return F_UPDATE_DATE;
	}

	public void setF_UPDATE_DATE(Date date) {
		F_UPDATE_DATE = date;
	}



	public FarmerRegModel(String police_station) {
		super();
		this.police_station = police_station;
	}

	public String getPolice_station() {
		return police_station;
	}

	public void setPolice_station(String police_station) {
		this.police_station = police_station;
	}

	public String getF_Block() {
		return F_Block;
	}

	public void setF_Block(String f_Block) {
		F_Block = f_Block;
	}

	public String getF_Address2() {
		return F_Address2;
	}


	public String getF_STATE() {
		return F_STATE;
	}

	public void setF_STATE(String f_STATE) {
		F_STATE = f_STATE;
	}




	public String getF_District() {
		return F_District;
	}

	public void setF_District(String f_District) {
		F_District = f_District;
	}

	public String getDpc_id() {
		return dpc_id;
	}

	public void setDpc_id(String dpc_id) {
		this.dpc_id = dpc_id;
	}

	public void setF_Address2(String f_Address2) {
		F_Address2 = f_Address2;
	}

	public String getF_Pincode() {
		return F_Pincode;
	}

	public void setF_Pincode(String f_Pincode) {
		F_Pincode = f_Pincode;
	}


	public Date getF_VERFIED_DATE() {
		return F_VERFIED_DATE;
	}

	public void setF_VERFIED_DATE(Date f_VERFIED_DATE) {
		F_VERFIED_DATE = f_VERFIED_DATE;
	}

	public String getF_REG_FORM() {
		return F_REG_FORM;
	}

	public void setF_REG_FORM(String f_REG_FORM) {
		F_REG_FORM = f_REG_FORM;
	}

	public String getF_DOC_Mandate() {
		return F_DOC_Mandate;
	}

	public void setF_DOC_Mandate(String f_DOC_Mandate) {
		F_DOC_Mandate = f_DOC_Mandate;
	}

	public FarmerRegModel() {

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


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getF_ADDRESS() {
		return F_ADDRESS;
	}


	public void setF_ADDRESS(String f_ADDRESS) {
		F_ADDRESS = f_ADDRESS;
	}


	public String getF_ID_PROF_TYPE() {
		return F_ID_PROF_TYPE;
	}


	public void setF_ID_PROF_TYPE(String f_ID_PROF_TYPE) {
		F_ID_PROF_TYPE = f_ID_PROF_TYPE;
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


	public String getLand_holding() {
		return land_holding;
	}


	public void setLand_holding(String land_holding) {
		this.land_holding = land_holding;
	}


	public String getF_MOBILE() {
		return F_MOBILE;
	}


	public void setF_MOBILE(String f_MOBILE) {
		F_MOBILE = f_MOBILE;
	}


	public String getF_AC_NO() {
		return F_AC_NO;
	}


	public void setF_AC_NO(String f_AC_NO) {
		F_AC_NO = f_AC_NO;
	}


	public String getBank_ac_type() {
		return bank_ac_type;
	}


	public void setBank_ac_type(String bank_ac_type) {
		this.bank_ac_type = bank_ac_type;
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



	public String getReg_form() {
		return F_REG_FORM;
	}


	public void setReg_form(String reg_form) {
		this.F_REG_FORM = F_REG_FORM;
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


	public String getF_REG_NO() {
		return F_REG_NO;
	}


	public void setF_REG_NO(String f_REG_NO) {
		F_REG_NO = f_REG_NO;
	}

	public String getState_name() {
		return State_name;
	}

	public void setState_name(String state_name) {
		State_name = state_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	
	
	public FarmerRegModel(int f_ID, String f_NAME, String caste, String gender, String f_ADDRESS, String f_ID_PROF_TYPE,
			String f_Block, String f_ID_PROF, String f_ID_PROF_NO, String f_REG_BY, String f_STATE, String state_name,
			String f_District, String district_name, Date f_UPDATE_DATE, String f_I_CARE_REGISTERED,
			String land_holding, String f_MOBILE, String f_AC_NO, String bank_ac_type, String f_BANK_NAME,
			String f_BANK_BRANCH, String f_BANK_IFSC, String f_BANK_DOC, String f_REG_FORM, String f_DOC_PATH,
			String f_REG_NO, String f_DOC_Mandate, Date f_VERFIED_DATE, String f_Address2, String f_Pincode,
			int iS_VERIFIED, String dpc_id, String police_station) {
		super();
		F_ID = f_ID;
		F_NAME = f_NAME;
		this.caste = caste;
		this.gender = gender;
		F_ADDRESS = f_ADDRESS;
		F_ID_PROF_TYPE = f_ID_PROF_TYPE;
		F_Block = f_Block;
		F_ID_PROF = f_ID_PROF;
		F_ID_PROF_NO = f_ID_PROF_NO;
		F_REG_BY = f_REG_BY;
		F_STATE = f_STATE;
		State_name = state_name;
		F_District = f_District;
		this.district_name = district_name;
		F_UPDATE_DATE = f_UPDATE_DATE;
		F_I_CARE_REGISTERED = f_I_CARE_REGISTERED;
		this.land_holding = land_holding;
		F_MOBILE = f_MOBILE;
		F_AC_NO = f_AC_NO;
		this.bank_ac_type = bank_ac_type;
		F_BANK_NAME = f_BANK_NAME;
		F_BANK_BRANCH = f_BANK_BRANCH;
		F_BANK_IFSC = f_BANK_IFSC;
		F_BANK_DOC = f_BANK_DOC;
		F_REG_FORM = f_REG_FORM;
		F_DOC_PATH = f_DOC_PATH;
		F_REG_NO = f_REG_NO;
		F_DOC_Mandate = f_DOC_Mandate;
		F_VERFIED_DATE = f_VERFIED_DATE;
		F_Address2 = f_Address2;
		F_Pincode = f_Pincode;
		IS_VERIFIED = iS_VERIFIED;
		this.dpc_id = dpc_id;
		this.police_station = police_station;
	}

	@Override
	public String toString() {
		return "FarmerRegModel [F_ID=" + F_ID + ", F_NAME=" + F_NAME + ", caste=" + caste + ", gender=" + gender
				+ ", F_ADDRESS=" + F_ADDRESS + ", F_ID_PROF_TYPE=" + F_ID_PROF_TYPE + ", F_Block=" + F_Block
				+ ", F_ID_PROF=" + F_ID_PROF + ", F_ID_PROF_NO=" + F_ID_PROF_NO + ", F_REG_BY=" + F_REG_BY
				+ ", F_STATE=" + F_STATE + ", State_name=" + State_name + ", F_District=" + F_District
				+ ", district_name=" + district_name + ", F_UPDATE_DATE=" + F_UPDATE_DATE + ", F_I_CARE_REGISTERED="
				+ F_I_CARE_REGISTERED + ", land_holding=" + land_holding + ", F_MOBILE=" + F_MOBILE + ", F_AC_NO="
				+ F_AC_NO + ", bank_ac_type=" + bank_ac_type + ", F_BANK_NAME=" + F_BANK_NAME + ", F_BANK_BRANCH="
				+ F_BANK_BRANCH + ", F_BANK_IFSC=" + F_BANK_IFSC + ", F_BANK_DOC=" + F_BANK_DOC + ", F_REG_FORM="
				+ F_REG_FORM + ", F_DOC_PATH=" + F_DOC_PATH + ", F_REG_NO=" + F_REG_NO + ", F_DOC_Mandate="
				+ F_DOC_Mandate + ", F_VERFIED_DATE=" + F_VERFIED_DATE + ", F_Address2=" + F_Address2 + ", F_Pincode="
				+ F_Pincode + ", IS_VERIFIED=" + IS_VERIFIED + ", dpc_id=" + dpc_id + ", police_station="
				+ police_station + "]";
	}

	

	

	


}

