package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.AreaCodeDao;
import com.jci.model.AreaDetailCode;
import com.jci.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaCodeDao areaDao;


	@Override
	public void create(AreaDetailCode areat) {
		areaDao.create(areat);

	}

	@Override
	public void update(AreaDetailCode areat) {
		areaDao.update(areat);

	}

	@Override
	public AreaDetailCode edit(int id) {
		return areaDao.edit(id);
	}

	@Override
	public void delete(int id) {
		areaDao.delete(id);

	}

	@Override
	public AreaDetailCode find(int id) {
		return areaDao.find(id);
	}

	@Override
	public List<AreaDetailCode> getAll() {
		return areaDao.getAll();
	}

	@Override
	public boolean submitform(AreaDetailCode off) {
		return areaDao.submitform(off);
	}

}
