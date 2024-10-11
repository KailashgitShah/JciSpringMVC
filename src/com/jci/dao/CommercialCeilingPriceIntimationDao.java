package com.jci.dao;

import java.util.List;

import com.jci.model.CommercialCeilingPriceIntimationModel;


public interface CommercialCeilingPriceIntimationDao {

	public void create(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel);
	public void update(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel);
	public CommercialCeilingPriceIntimationModel edit(int id);
	public void delete(int id);
	public CommercialCeilingPriceIntimationModel find(int id);
	public List <CommercialCeilingPriceIntimationModel> getAll();
	public boolean submitform(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel);

}
