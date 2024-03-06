package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RoDetailsDao;
import com.jci.model.RoDetailsModel;
import com.jci.service.RoDetailsService;
@Service
public class RoDetailsServiceImpl implements RoDetailsService{

	@Autowired
	RoDetailsDao roDao;

	@Override
	public void create(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoDetailsModel> getAll() {
		// TODO Auto-generated method stub
		return roDao.getAll();
	}

	@Override
	public boolean submitform(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> zonecode(String zoneCode) {
		return roDao.zonecode(zoneCode);
	}
}
