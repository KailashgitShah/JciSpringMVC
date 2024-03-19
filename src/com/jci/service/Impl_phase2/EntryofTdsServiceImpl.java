package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.EntryofTdsDao;
import com.jci.model.JciEntryTdsModel;
import com.jci.service_phase2.EntryofTdsService;

@Service
public class EntryofTdsServiceImpl implements EntryofTdsService {

	@Autowired
	EntryofTdsDao entryofTdsDao;

	@Override
	public void create(JciEntryTdsModel j) {
		// TODO Auto-generated method stub
		entryofTdsDao.create(j);

	}

	@Override
	public List<JciEntryTdsModel> getAll() {
		// TODO Auto-generated method stub
		return entryofTdsDao.getAll();
	}

	@Override
	public List<String> MillName() {
		// TODO Auto-generated method stub
		return entryofTdsDao.MillName();
	}

	@Override
	public String contractIdentification(String Mill) {
	return entryofTdsDao.contractIdentification(Mill);	
	}

	/*
	 * @Override public List<Object> contractIdentification1(String Mill) { // TODO
	 * Auto-generated method stub return (List<Object>)
	 * entryofTdsDao.contractIdentification(Mill); }
	 */

//	@Override
//	public List<String> getFinancialYearByMill(String mill) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
