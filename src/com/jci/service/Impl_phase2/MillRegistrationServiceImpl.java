package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.EntryofTdsDao;
import com.jci.dao_phase2.MillRegistrationDao;
import com.jci.model.MillRegistrationModel;
import com.jci.service_phase2.MillRegistrationService;
@Service
public class MillRegistrationServiceImpl implements MillRegistrationService{
	@Autowired
	MillRegistrationDao millRegistrationDao;
	@Override
	public List<String> MillName() {
		// TODO Auto-generated method stub
		return millRegistrationDao.MillName();
	}
	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		// TODO Auto-generated method stub
		return  millRegistrationDao.FetchMillReceiptData(millid);
	}
	@Override
	public void create(com.jci.model.MillRegistrationModel millsave) {
		// TODO Auto-generated method stub
		 millRegistrationDao.create(millsave);
		
	}
	@Override
	public List<MillRegistrationModel> getAll() {
		// TODO Auto-generated method stub
		return millRegistrationDao.getAll();
	}
	
	
}
