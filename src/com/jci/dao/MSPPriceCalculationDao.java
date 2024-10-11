package com.jci.dao;

import java.util.List;

import com.jci.model.MSPPriceCalculationModel;

public interface MSPPriceCalculationDao{

	public List<String> findGradeOfMSP (String variety, int basis_no);
	public int create(MSPPriceCalculationModel mspPrices);
	public List<MSPPriceCalculationModel> getAll();
	public boolean validatejutevariety(String jutevariety, String cropyr);
	public void delete(int id);
    public MSPPriceCalculationModel find(int id);
    public void update(MSPPriceCalculationModel mspPriceCalculationModel);
}
