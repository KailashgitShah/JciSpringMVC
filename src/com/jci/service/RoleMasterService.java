package com.jci.service;

import java.util.List;

import com.jci.model.RoleMasterModel;


public interface RoleMasterService {
	public void create(RoleMasterModel role);
	public void update(RoleMasterModel role);
	public RoleMasterModel edit(int id);
	public RoleMasterModel find(int id);
	public List <RoleMasterModel> getAll();
	public boolean submitform(RoleMasterModel role);
}
