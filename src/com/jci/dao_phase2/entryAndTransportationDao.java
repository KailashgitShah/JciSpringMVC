package com.jci.dao_phase2;
import java.util.List;

import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.OperationCostModel;
import com.jci.model.OperationFreeSales;
public interface entryAndTransportationDao {
	void saveDataInFreeOperationModelsaveDataInFreeOperationModel(OperationFreeSales operationcostmodel);
	public String findunitByFactoHead(String factorHead);
	public void delete(int id) ;
	public Double nominalWeight(String rocode);
	List<OperationCostModel> getAll();
	List<Object[]> getDetailsFreeSale();
	List<Object[]> getDetailsCommercial();
	
	List<FactorssInvolvedCommercial> getAllFactorHead();
}
