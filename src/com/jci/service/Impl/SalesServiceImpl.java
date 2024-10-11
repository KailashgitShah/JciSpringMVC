package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.SalesDao;
import com.jci.model.SalesModel;
import com.jci.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService{

	@Autowired
	SalesDao salesDao;

	@Override
	public void create(SalesModel salesModel) {
		salesDao.create(salesModel);

	}

	@Override
	public void update(SalesModel salesModel) {
		salesDao.update(salesModel);

	}

	@Override
	public SalesModel edit(int id) {
		return salesDao.edit(id);
	}

	@Override
	public void delete(int id) {
		salesDao.delete(id);

	}

	@Override
	public SalesModel find(int id) {
		return salesDao.find(id);
	}

	@Override
	public List<SalesModel> getAll() {
		return salesDao.getAll();
	}

	@Override
	public boolean submitform(SalesModel salesModel) {
		return salesDao.submitform(salesModel);
	}

}
