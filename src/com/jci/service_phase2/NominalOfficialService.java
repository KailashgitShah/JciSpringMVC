package com.jci.service_phase2;

import java.util.ArrayList;

import java.util.List;

import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;

public interface NominalOfficialService {

	public void create(Jciclaim_NominationModel nominal);

	public void update(Jciclaim_NominationModel nominal);

	public Jciclaim_NominationModel edit(int id);

	public void delete(int id);

	public List<Jciclaim_NominationModel> getAll();

	public boolean submitform(Jciclaim_NominationModel off);

	List<String> millid_MillReceipt();
	// List<Object[]> millid_MillReceipt();

	public List<Object> FetchMillReceiptData(String millid);

	public List<String> contractno_ContractTable();

	public List<String> UsernameOM_jciumt(String role);

	public List<String> UsernameFA_jciumt(String role);

	public List<UserRegistrationModel> getom_official();

	public List<UserRegistrationModel> getfa_official();

	public int CountRecord();

	public List<Object> gradecomposition(String contractno);

	// Email service
	public String getEmailForFA(String FAofficial);

	public String getEmailForOmo(String omofficial);

	public String getEmaiformills(String Mill);

}
