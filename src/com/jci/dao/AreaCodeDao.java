package com.jci.dao;

import java.util.List;

import com.jci.model.AreaDetailCode;

public interface AreaCodeDao {
	public void create(AreaDetailCode area);
	public void update(AreaDetailCode area);
	public AreaDetailCode edit(int id);
	public void delete(int id);
	public AreaDetailCode find(int id);
	public List <AreaDetailCode> getAll();
	public boolean submitform(AreaDetailCode off);

}
