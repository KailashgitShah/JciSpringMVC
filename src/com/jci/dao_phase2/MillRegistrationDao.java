package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.MillRegistrationModel;

public interface MillRegistrationDao {
	public List<String> MillName();
	public List<Object> FetchMillReceiptData(String millid);
	public void create(MillRegistrationModel millsave);
	public List <MillRegistrationModel> getAll();

}
