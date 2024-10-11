package com.jci.dao;

import java.util.List;

import com.jci.model.ProgOfAssortmentModel;


public interface ProgOfAssortmentDao {

	public void create(ProgOfAssortmentModel progOfAssortment);
	public void update(ProgOfAssortmentModel progOfAssortment);
	public ProgOfAssortmentModel edit(int id);
	public void delete(int id);
	public ProgOfAssortmentModel find(int id);
	public List <ProgOfAssortmentModel> getAll();
	public boolean submitform(ProgOfAssortmentModel progOfAssortment);
}
