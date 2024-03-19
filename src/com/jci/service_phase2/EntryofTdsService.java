
package com.jci.service_phase2;

import java.util.List;

import com.jci.model.JciEntryTdsModel;

public interface EntryofTdsService {
	
	public void create(JciEntryTdsModel j);
	public List <JciEntryTdsModel> getAll();
	public List<String> MillName();
	public String contractIdentification(String Mill);

	
}
