package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.MillRegistrationModel;

public interface MillRegistrationDao {
	public List<String> MillName();
	public List<Object> FetchMillReceiptData(String millid);
	public void create(MillRegistrationModel millsave);
	public List <MillRegistrationModel> getAll();
	public MillRegistrationModel getmillRegistrationProfile(int MillRegistrationId );
	public void ResetPassword(int MillRegistrationId);
/////////////// This is for login
	public String loginCheck(String userName, String password);
	public String  checkmillcode(String email);
	public String  checkmillemail(String email);
	public boolean validatemillEmail(String Email);
	public boolean validatemill(String millName);
	

}
