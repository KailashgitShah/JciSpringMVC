package com.jci.service;

import java.util.List;

import com.jci.model.CommercialJuteVarietyModel;


public interface CommercialJuteVarietyGradesPriceService {
	public void create(CommercialJuteVarietyModel commercialJuteVarietyModel);
	public List <CommercialJuteVarietyModel> getAll();
	public void delete(int id);

}

