package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.ProgOfAssortmentDao;
import com.jci.model.ProgOfAssortmentModel;
import com.jci.service.ProgOfAssortmentService;

@Service
public class ProgOfAssortmentServiceImpl implements ProgOfAssortmentService{

	@Autowired
	ProgOfAssortmentDao progOfAssortmentDao;

	@Override
	public void create(ProgOfAssortmentModel progOfAssortment) {
		progOfAssortmentDao.create(progOfAssortment);
	}

	@Override
	public void update(ProgOfAssortmentModel progOfAssortment) {
		progOfAssortmentDao.update(progOfAssortment);
	}

	@Override
	public ProgOfAssortmentModel edit(int id) {
		return progOfAssortmentDao.edit(id);
	}

	@Override
	public void delete(int id) {
		progOfAssortmentDao.delete(id);
	}

	@Override
	public ProgOfAssortmentModel find(int id) {
		return progOfAssortmentDao.find(id);
	}

	@Override
	public List<ProgOfAssortmentModel> getAll() {
		return progOfAssortmentDao.getAll();
	}

	@Override
	public boolean submitform(ProgOfAssortmentModel progOfAssortment) {
		return progOfAssortmentDao.submitform(progOfAssortment);
	}
}
