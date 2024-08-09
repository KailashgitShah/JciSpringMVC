package com.jci.service_phase2;

import java.util.List;

import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.OperationCostModel;
import com.jci.model.OperationFreeSales;

public interface entryAndTransportationService {
	
	
	void saveDataInFreeOperationModelsaveDataInFreeOperationModel(OperationFreeSales operationcostmodel);
	public String findunitByFactoHead(String factorHead);
	public void delete(int id) ;
	public Double nominalWeight(String rocode);
	List<Object[]> getDetails();
	List<FactorssInvolvedCommercial> getAllFactorHead();
	List<OperationCostModel> getAll();
	

}
