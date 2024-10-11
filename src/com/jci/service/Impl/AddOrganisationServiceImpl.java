package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.AddOrganizationDao;
import com.jci.model.AddOrganizationModel;
import com.jci.service.AddOrganisationService;

@Service
public class AddOrganisationServiceImpl implements AddOrganisationService {

	@Autowired
	AddOrganizationDao addOrganizationDao;

	@Override
	public void create(AddOrganizationModel addOrganizationModel) {
		addOrganizationDao.create(addOrganizationModel);

	}

	@Override
	public void update(AddOrganizationModel addOrganizationModel) {
		addOrganizationDao.update(addOrganizationModel);

	}

	@Override
	public AddOrganizationModel edit(int id) {
		return addOrganizationDao.edit(id);
	}

	@Override
	public void delete(int id) {
		addOrganizationDao.delete(id);

	}

	@Override
	public AddOrganizationModel find(int id) {
		return addOrganizationDao.find(id);
	}

	@Override
	public List<AddOrganizationModel> getAll() {
		return addOrganizationDao.getAll();
	}

	@Override
	public boolean submitform(AddOrganizationModel addOrganizationModel) {
		return addOrganizationDao.submitform(addOrganizationModel);
	}

}
