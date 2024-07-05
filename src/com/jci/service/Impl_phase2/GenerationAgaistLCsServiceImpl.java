package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.GenerationAgaistLCsDao;
import com.jci.dao_phase2.GenrationCashDocumentDao;
import com.jci.model.GenerationofDocumentLCsModel;
import com.jci.service_phase2.GenerationAgaistLCsService;

@Service
public class GenerationAgaistLCsServiceImpl implements GenerationAgaistLCsService {

	
	@Autowired
	GenerationAgaistLCsDao generationAgaistLCsDao;

	

	@Override
	public List<GenerationofDocumentLCsModel> getAll() {
		
		return generationAgaistLCsDao.getAll();
	}



	@Override
	public void create(GenerationofDocumentLCsModel generationofDocumentLCsModel) {
		generationAgaistLCsDao.create(generationofDocumentLCsModel);
		
	}



	@Override
	public List<Object[]> fetchMill_NameforLC() {
	
		return generationAgaistLCsDao.fetchMill_NameforLC();
	}



	@Override
	public List<Object> contractonmill(String millname) {
		
		return generationAgaistLCsDao.contractonmill(millname);
	}



	@Override
	public List<Object[]> listdetailsofpaymemt( String st) {
		
		return generationAgaistLCsDao.listdetailsofpaymemt(st);
	}



	@Override
	public List<Object[]> listdetailsbillofsupplly(String st) {
	
		return generationAgaistLCsDao.listdetailsbillofsupplly(st);
	}







	@Override
	public List<Object[]> forIFSC(String st) {
		return generationAgaistLCsDao.forIFSC(st);
	}



	@Override
	public List<Object[]> forQtyintopsheet(String st) {
	
		return generationAgaistLCsDao.forQtyintopsheet(st);
	}



	@Override
	public String lcno() {
		return generationAgaistLCsDao.lcno();
	}




}
