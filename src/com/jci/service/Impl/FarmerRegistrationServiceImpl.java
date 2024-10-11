package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.FarmerRegistrationDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.service.FarmerRegistrationService;

@Service
public class FarmerRegistrationServiceImpl implements FarmerRegistrationService {

	@Autowired
	FarmerRegistrationDao farmerRegistrationDao;

	@Override
	public void create(FarmerRegistrationModel farmerRegistrationModel) {
		farmerRegistrationDao.create(farmerRegistrationModel);
	}

	@Override
	public void update(FarmerRegistrationModel farmerRegistrationModel) {
		farmerRegistrationDao.update(farmerRegistrationModel);
	}

	@Override
	public FarmerRegistrationModel edit(int id) {
		return farmerRegistrationDao.edit(id);
	}

	@Override
	public void delete(int id) {
		farmerRegistrationDao.delete(id);
	}

	@Override
	public FarmerRegistrationModel find(int id) {
		return farmerRegistrationDao.find(id);
	}

	@Override
	public List<FarmerRegistrationModel> getAll() {
		return farmerRegistrationDao.getAll();
	}

	@Override
	public boolean submitform(FarmerRegistrationModel off) {
		return farmerRegistrationDao.submitform(off);
	}

}
