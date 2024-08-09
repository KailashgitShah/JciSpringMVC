package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jci.dao_phase2.entryAndTransportationDao;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.OperationCostModel;
import com.jci.model.OperationFreeSales;
import com.jci.service_phase2.entryAndTransportationService;
@Service
public class entryAndTransportaionServiceImpl implements entryAndTransportationService{

	@Autowired
	entryAndTransportationDao   entryAndtransportationDao ;
	
	
	@Override
	public String findunitByFactoHead(String factorHead) {
		// TODO Auto-generated method stub
		return entryAndtransportationDao.findunitByFactoHead(factorHead);
	}

	@Override
	public void delete(int id) {
		entryAndtransportationDao.delete( id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double nominalWeight(String rocode) {
		// TODO Auto-generated method stub
		return entryAndtransportationDao.nominalWeight( rocode);
	}

	@Override
	public void saveDataInFreeOperationModelsaveDataInFreeOperationModel(OperationFreeSales operationcostmodel) {
		entryAndtransportationDao.saveDataInFreeOperationModelsaveDataInFreeOperationModel(operationcostmodel);
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<OperationCostModel> getAll() {
		// TODO Auto-generated method stub
		return entryAndtransportationDao.getAll();
	}

	@Override
	public List<Object[]> getDetails() {
		// TODO Auto-generated method stub
		return entryAndtransportationDao.getDetails();
	}

	@Override
	public List<FactorssInvolvedCommercial> getAllFactorHead() {
		// TODO Auto-generated method stub
		return entryAndtransportationDao.getAllFactorHead();
	}
	
	
}
