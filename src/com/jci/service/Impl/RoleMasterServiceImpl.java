package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RoleMasterDao;
import com.jci.model.RoleMasterModel;
import com.jci.service.RoleMasterService;

@Service
public class RoleMasterServiceImpl implements RoleMasterService {

	@Autowired
	RoleMasterDao roleDao;

	@Override
	public void create(RoleMasterModel role) {
		roleDao.create(role);

	}

	@Override
	public void update(RoleMasterModel role) {
		roleDao.update(role);
	}

	@Override
	public RoleMasterModel edit(int id) {
		return roleDao.edit(id);
	}

	@Override
	public RoleMasterModel find(int id) {
		return roleDao.find(id);
	}

	@Override
	public List<RoleMasterModel> getAll() {
		return roleDao.getAll();
	}

	@Override
	public boolean submitform(RoleMasterModel role) {
		return roleDao.submitform(role);
	}

}
