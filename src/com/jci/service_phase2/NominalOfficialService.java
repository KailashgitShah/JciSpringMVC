package com.jci.service_phase2;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.FarmerRegModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;

public interface NominalOfficialService {

	public void create(Jciclaim_NominationModel nominal );
	public void claimStatusUpdate(String ContractNoForClaimStatusUpdate);
	public void millrecieptstatus(String mr );

	public void update(Jciclaim_NominationModel nominal);

	public Jciclaim_NominationModel edit(int id);

	public void delete(int id);

	public List<Jciclaim_NominationModel> getAll();
	public List<Jciclaim_NominationModel>getAlldetails(String settlement_id);

	public boolean submitform(Jciclaim_NominationModel off);

	List<String> millid_MillReceipt();
	List<String> gethodi();
	public List<Object> FetchMillReceiptData(String millid);
	

	public List<String> contractno_ContractTable();

	public List<String> UsernameOM_jciumt(String role);

	public List<String> UsernameFA_jciumt(String role);

	public List<UserRegistrationModel> getom_official();

	public List<UserRegistrationModel> getfa_official();

	public int CountRecord();

	public List<Object> gradecomposition(String contractno);
	public List<Object[]> dateofInspection(String dateOfInspection);
	
	public List<Object[]> getchallan(String hodi);
	public String getcontractidentification(String ContractNo);
	public String getmillcode(String millname);
	
	// Email service
	public String getEmailForFA(String FAofficial);

	public String getEmailForOmo(String omofficial);

	public String getEmaiformills(String Mill);
	
	public Jciclaim_NominationModel find(String id);
	public void updatefa(String id , String FAomofficial);
	public List<Jciclaim_NominationModel>findnominationdetails(String id);


}
