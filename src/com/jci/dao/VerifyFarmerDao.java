package com.jci.dao;

import java.util.List;

import com.jci.model.FarmerRegModel;
import com.jci.model.VerifyFarmerModel;

public interface VerifyFarmerDao {
	public void create(VerifyFarmerModel VerifyFarmer);
	public void update(VerifyFarmerModel VerifyFarmer);
	public VerifyFarmerModel edit(int id);
	public void delete(int id);
	public VerifyFarmerModel find(int id);
	public List <VerifyFarmerModel> getAll();
	public boolean submitform(VerifyFarmerModel off);
	public int verifyFarmer(String farmer_reg_no, String ifsc_code, String ac_no, String farmer_name, String address, int id);
	public FarmerRegModel verificationStatus(int regNo);
	public boolean duplicateVerificationEntryNumberCheck(String regNo);
	VerifyFarmerModel findbyReg(String regNo);

}
