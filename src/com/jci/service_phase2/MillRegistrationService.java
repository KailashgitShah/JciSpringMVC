package com.jci.service_phase2;

import java.util.List;

import com.jci.model.JciEntryTdsModel;
import com.jci.model.MillRegistrationModel;
import com.jci.model.UserRegistrationModel;

public interface MillRegistrationService {
	public List<String> MillName();
	public List<Object> FetchMillReceiptData(String millid);
	public void create(MillRegistrationModel millsave);
	public List <MillRegistrationModel> getAll();
	public MillRegistrationModel getmillRegistrationProfile(int MillRegistrationId );
	public void ResetPassword(int MillRegistrationId);
	
	/////////////// This is for login
	public String checkLogin(String usrname, String password);
	public String  checkmillcode(String email);
	public String checkmillemail (String email);
	public boolean validatemillEmail(String Email);
	
	
}
