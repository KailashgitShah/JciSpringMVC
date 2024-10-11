package com.jci.service;

import java.util.List;

import com.jci.model.FarmerRegistrationModel;

public interface FarmerRegistrationService {
	public void create(FarmerRegistrationModel farmerRegistrationModel);
	public void update(FarmerRegistrationModel farmerRegistrationModel);
	public FarmerRegistrationModel edit(int id);
	public void delete(int id);
	public FarmerRegistrationModel find(int id);
	public List <FarmerRegistrationModel> getAll();
	public boolean submitform(FarmerRegistrationModel off);
}
