package com.jci.dao;
import java.util.List;

import com.jci.model.FarmerRegistrationModel;

public interface FarmerRegistrationDao {
	public void create(FarmerRegistrationModel farmerRegistrationModel);
	public void update(FarmerRegistrationModel farmerRegistrationModel);
	public FarmerRegistrationModel edit(int id);
	public void delete(int id);
	public FarmerRegistrationModel find(int id);
	public List <FarmerRegistrationModel> getAll();
	public boolean submitform(FarmerRegistrationModel off);
}
