package com.jci.dao;

import java.util.List;

import com.jci.model.RoleMasterModel;

public interface RoleMasterDao {
	public void create(RoleMasterModel roleMaster);
	public void update(RoleMasterModel roleMaster);
	public RoleMasterModel edit(int id);

	public RoleMasterModel find(int id);
	public List <RoleMasterModel> getAll();
	public boolean submitform(RoleMasterModel roleMaster);
}
