package com.jci.dao;

import java.util.List;

import com.jci.model.CommercialJuteVarietyModel;



public interface CommercialJuteVarietyGradesPriceDao {

	void create(CommercialJuteVarietyModel commercialJuteVarietyModel);

	 public List<CommercialJuteVarietyModel> getAll();

	void delete(int id);


}
