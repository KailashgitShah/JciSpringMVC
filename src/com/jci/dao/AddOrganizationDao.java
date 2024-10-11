package com.jci.dao;
import java.util.List;

import com.jci.model.AddOrganizationModel;

public interface AddOrganizationDao {

	public void create(AddOrganizationModel addOrganizationModel);
	public void update(AddOrganizationModel addOrganizationModel);
	public AddOrganizationModel edit(int id);
	public void delete(int id);
	public AddOrganizationModel find(int id);
	public List <AddOrganizationModel> getAll();
	public boolean submitform(AddOrganizationModel addOrganizationModel);
}
