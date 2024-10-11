package com.jci.service;

import java.util.List;

import com.jci.model.AddOrganizationModel;

public interface AddOrganisationService {

	public void create(AddOrganizationModel addOrganizationModel);
	public void update(AddOrganizationModel addOrganizationModel);
	public AddOrganizationModel edit(int id);
	public void delete(int id);
	public AddOrganizationModel find(int id);
	public List <AddOrganizationModel> getAll();
	public boolean submitform(AddOrganizationModel addOrganizationModel);

}
