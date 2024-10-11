package com.jci.service;

import java.util.List;

import com.jci.model.AreaDetailCode;

public interface AreaService {
	public void create(AreaDetailCode AreaCode);
	public void update(AreaDetailCode AreaCode);
	public AreaDetailCode edit(int id);
	public void delete(int id);
	public AreaDetailCode find(int id);
	public List <AreaDetailCode> getAll();
	public boolean submitform(AreaDetailCode off);
}
