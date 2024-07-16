package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.GenrationCashDocumentDao;

import com.jci.model.CashDocumentModel;
import com.jci.model.TopsheetDetailsModel;
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

	@Override
	public List<Object> Non_lc(String St) {
		
		return genrationCashDocumentDao.Non_lc(St);
	}

	@Override
	public List<Object[]> fetchMill_Name() {
		// TODO Auto-generated method stub
		return genrationCashDocumentDao.fetchMill_Name();
	}

	@Override
	public List<Object> contractonmill1(String millname) {
		
		return genrationCashDocumentDao.contractonmill1(millname);
	}

	@Override
	public void create(TopsheetDetailsModel topSheet ) {
		genrationCashDocumentDao.create(topSheet  );
		
	}

	@Override
	public String topSheetId() {
		// TODO Auto-generated method stub
		return genrationCashDocumentDao.topSheetId();
	}

	@Override
	public List<TopsheetDetailsModel> getAlltopsheetdata() {
		// TODO Auto-generated method stub
		return genrationCashDocumentDao.getAlltopsheetdata();
	}

	
	

}
