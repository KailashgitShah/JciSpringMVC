package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RopeMakingDao;
import com.jci.model.RopeMakingModel;
import com.jci.service.RopeMakingService;

@Service
public class RopeMakingSeviceImpl implements RopeMakingService {

	@Autowired
	RopeMakingDao ropeMakingDao;

	@Override
	public void create(RopeMakingModel ropeMakingModel) {
		ropeMakingDao.create(ropeMakingModel);
	}

	@Override
	public void update(RopeMakingModel ropeMakingModel) {
		ropeMakingDao.update(ropeMakingModel);
	}

	@Override
	public RopeMakingModel edit(int id) {
		return ropeMakingDao.edit(id);
	}

	@Override
	public void delete(int id) {
		ropeMakingDao.delete(id);
	}

	@Override
	public RopeMakingModel find(int id) {
		return ropeMakingDao.find(id);
	}



	@Override
	public boolean submitform(RopeMakingModel off) {
		return ropeMakingDao.submitform(off);
	}

	@Override
	public List<RopeMakingModel> ropeMakingList(int regionId) {
		return ropeMakingDao.ropeMakingList(regionId);
	}

	@Override
	public List<String> findBinno(String cropyr, String dpcid) {
	
		return ropeMakingDao.findBinno(cropyr,dpcid);
	}
	@Override
	public List<RopeMakingModel> getAll(String placeofactivity, String regionId, String zoneId) {
		return ropeMakingDao.getAll(placeofactivity, regionId, zoneId);
	}





}
