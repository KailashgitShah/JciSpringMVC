package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.VerifyFarmerDao;
import com.jci.model.VerifyFarmerModel;
import com.jci.service.VerifyFarmerService;

@Service
public class VerifyFarmerServiveImpl implements VerifyFarmerService {

	@Autowired
	VerifyFarmerDao verifyFarmerDao;

	@Override
	public void create(VerifyFarmerModel verifyFarmer) {
		verifyFarmerDao.create(verifyFarmer);

	}

	@Override
	public void update(VerifyFarmerModel verifyFarmer) {
		verifyFarmerDao.update(verifyFarmer);

	}

	@Override
	public VerifyFarmerModel edit(int id) {
		return verifyFarmerDao.edit(id);
	}

	@Override
	public void delete(int id) {
		verifyFarmerDao.delete(id);
	}

	@Override
	public VerifyFarmerModel find(int id) {
		return verifyFarmerDao.find(id);
	}

	@Override
	public List<VerifyFarmerModel> getAll() {
		return verifyFarmerDao.getAll();
	}

	@Override
	public boolean submitform(VerifyFarmerModel off) {
		return verifyFarmerDao.submitform(off);
	}

	@Override
	public boolean duplicateVerificationEntryNumberCheck(String verificationNumber) {
		return verifyFarmerDao.duplicateVerificationEntryNumberCheck(verificationNumber);
	}

	@Override
	public VerifyFarmerModel findbyReg(String regNo) {
		return verifyFarmerDao.findbyReg(regNo);
	}


}
