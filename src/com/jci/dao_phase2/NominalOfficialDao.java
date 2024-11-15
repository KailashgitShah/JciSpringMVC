package com.jci.dao_phase2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.jci.model.ClaimSettlementReport;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;

public interface NominalOfficialDao {


	public void create(Jciclaim_NominationModel nominal );
	public void claimStatusUpdate(String ContractNoForClaimStatusUpdate);
	public void update(Jciclaim_NominationModel nominal);
	
	public Jciclaim_NominationModel edit(int id);
	public void delete(int id);

	public List <Jciclaim_NominationModel> getAll();
	public boolean submitform(Jciclaim_NominationModel off);

// Auto Fetching Data From Different Table.
	public List<String> millid_MillReceipt();

	public List<Object> FetchMillReceiptData(String millid);
	public List<String> contractno_ContractTable();
	
	// Counting total Number of Rows In Mill 
	public String CountRecord();
	
	// Auto Fetching Role From jciuserrole.
	
	public List<String> UsernameOM_jciumt(String role);	
	public List<String> UsernameFA_jciumt(String role);
	public List<UserRegistrationModel> getom_official();
	public List<UserRegistrationModel> getfa_official();
	public List<String> gethodi();
	public List<Object[]> getchallan(String hodi);
	public List<Object[]> dateofInspection(String dateOfInspection);
	 // for fetching data from grdae_composition
		public List<Object>  gradecomposition(String contractno);
		//email process
		 public String getEmailForOmo(String omofficial);
		 public String getEmailForFA(String FAofficial);
		 public String getEmaiformills(String  Mill);
	     public String getcontractidentification(String ContractNo);
	     public String getmillcode(String millname);
	     
	     public Jciclaim_NominationModel find(String id);
	     public void millrecieptstatus(String mr);
	     public void updatefa(String id, String FAomofficial);
	     public List<Jciclaim_NominationModel>getAlldetails(String settlement_id);
	     public List<Jciclaim_NominationModel>findnominationdetails(String id) ;
	     public List<ClaimSettlementReport> getNominationReportData(String settlement_id);
		public List<Object[]> getAllHoDiByContract(String contract);
}
