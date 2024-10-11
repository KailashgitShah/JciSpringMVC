package com.jci.service;
import java.util.List;

import com.jci.model.VerifyFarmerModel;

public interface VerifyFarmerService {
	public void create(VerifyFarmerModel verifyFarmer);
	public void update(VerifyFarmerModel verifyFarmer);
	public VerifyFarmerModel edit(int id);
	public void delete(int id);
	public VerifyFarmerModel find(int id);
	public List<VerifyFarmerModel> getAll();
	public boolean submitform(VerifyFarmerModel off);
	public boolean duplicateVerificationEntryNumberCheck(String regNo);
	public VerifyFarmerModel findbyReg(String regNo);

}

