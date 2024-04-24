package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.FinalizationoflotsizerspModel;

public interface FinalizationoflotsizeDao {

	void create(FinalizationoflotsizerspModel FinalizationoflotrspModel);
	
	void update(FinalizationoflotsizerspModel FinalizationoflotrspModel);

	List<FinalizationoflotsizerspModel> getAlllist();
	
	

}
