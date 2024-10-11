package com.jci.dao;

import java.util.List;

import com.jci.model.SalesModel;

public interface SalesDao {
	public void create(SalesModel salesModel);
	public void update(SalesModel salesModel);
	public SalesModel edit(int id);
	public void delete(int id);
	public SalesModel find(int id);
	public List <SalesModel> getAll();
	public boolean submitform(SalesModel salesModel);
}
