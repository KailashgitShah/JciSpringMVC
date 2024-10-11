package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.ZoneDao;
import com.jci.model.ZoneModel;
import com.jci.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService{

	@Autowired
	ZoneDao zoneDao;

	@Override
	public void create(ZoneModel Zone) {
		zoneDao.create(Zone);
	}

	@Override
	public void update(ZoneModel Zone) {
		zoneDao.update(Zone);
	}

	@Override
	public ZoneModel edit(int id) {
		return zoneDao.edit(id);
	}

	@Override
	public void delete(int id) {
		zoneDao.delete(id);
	}

	@Override
	public ZoneModel find(int id) {
		return zoneDao.find(id);
	}

	@Override
	public List<ZoneModel> getAll() {
		return zoneDao.getAll();
	}

	@Override
	public boolean submitform(ZoneModel Zone) {
		return zoneDao.submitform(Zone);
	}
}
