package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.GenrationCashDocumentDao;

import com.jci.model.CashDocumentModel;

import com.jci.service_phase2.GenrationCashDocumentService;

@Service
public class GenrationCashDocumentServiceImpl implements GenrationCashDocumentService {
	
	@Autowired
	GenrationCashDocumentDao genrationCashDocumentDao;


	@Override
	public void create(CashDocumentModel cashDocumentModel) {
		genrationCashDocumentDao.create(cashDocumentModel);
		
	}

	@Override
	public List<CashDocumentModel> getAll() {
		
		 return genrationCashDocumentDao.getAll();
	}

	@Override
	public String fetchBos_No() {
		// TODO Auto-generated method stub
		return genrationCashDocumentDao.fetchBos_No();
	}

	

}
