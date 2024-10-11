package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.FarmerRegDao;
import com.jci.dao.VerifyFarmerDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;
import com.jci.service.FarmerRegService;

@Service
public class FarmerRegServiceImpl implements FarmerRegService{

	@Autowired
	FarmerRegDao farmerRegDao;

	@Autowired
	VerifyFarmerDao verifyFarmerDao;

	@Override
	public void create(FarmerRegModel farmerRegModel) {
		farmerRegDao.create(farmerRegModel);
	}

	@Override
	public void update(FarmerRegModel farmerRegModel) {
		farmerRegDao.update(farmerRegModel);
	}

	@Override
	public FarmerRegModel edit(int id) {
		return farmerRegDao.edit(id);
	}

	@Override
	public void delete(int id) {
		farmerRegDao.delete(id);
	}

	@Override
	public FarmerRegModel find(int id) {
		return farmerRegDao.find(id);
	}

	@Override
	public List<FarmerRegModel> getAll() {
		return farmerRegDao.getAll();
	}

	@Override
	public boolean submitform(FarmerRegModel farmerRegModel) {
		return farmerRegDao.submitform(farmerRegModel);
	}

	@Override
	public List<FarmerRegModelDTO> verificationStatus(String dpcid, String region, String zone) {
		return farmerRegDao.verificationStatus(dpcid, region, zone);
	}

	@Override
	public boolean updateVerificationStatus(int id) {
		return farmerRegDao.updateVerificationStatus(id);
	}

	@Override
	public boolean validateAccount(String accountNo) {
		return farmerRegDao.validateAccount(accountNo);
	}

	@Override
	public boolean validateMobile(String mobileNo) {
		return farmerRegDao.validateMobile(mobileNo);
	}

	@Override
	public boolean validateAdhar(String aadharNo) {
		return farmerRegDao.validateAdhar(aadharNo);
	}

	@Override
	public String findRegno(String dpcid, String region) {
		 
		return farmerRegDao.findRegno(dpcid, region);
	}

	@Override
	public List<FarmerRegModel> findDetails(int id) {
		// TODO Auto-generated method stub
		return farmerRegDao.findDetails(id);
	}
	
	@Override
    public String getFarmerNo(int id) {
          // TODO Auto-generated method stub
          return farmerRegDao.getFarmerNo(id);
    }

	@Override
	public List<FarmerRegModelDTO> findByDpc( String dpc) {
		// TODO Auto-generated method stub
		return farmerRegDao.findByDpc(dpc);
	}

	
	
}
