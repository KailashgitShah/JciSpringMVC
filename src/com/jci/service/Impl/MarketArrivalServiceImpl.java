package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.MarketArrivalDao;
import com.jci.model.MarketArrivalModel;
import com.jci.service.MarketArrivalService;

@Service
public class MarketArrivalServiceImpl implements MarketArrivalService{

	@Autowired
	MarketArrivalDao marketArrivalDao;

	@Override
	public void create(MarketArrivalModel marketArrival) {
		marketArrivalDao.create(marketArrival);
	}

	@Override
	public void update(MarketArrivalModel marketArrival) {
		marketArrivalDao.update(marketArrival);
	}

	@Override
	public MarketArrivalModel edit(int id) {
		return marketArrivalDao.edit(id);
	}

	@Override
	public void delete(int id) {
		marketArrivalDao.delete(id);
	}

	@Override
	public MarketArrivalModel find(int id) {
		return marketArrivalDao.find(id);
	}

	@Override
	public List<MarketArrivalModel> getAlldata(String dpc_code, String regionId, String zoneId) {
		return marketArrivalDao.getAlldata(dpc_code,regionId, zoneId);
	}
	
	@Override
	public MarketArrivalModel getAlldetails(int id) {
		return marketArrivalDao.getAlldetails(id);
	}

	@Override
	public boolean submitform(MarketArrivalModel marketArrival) {
		return marketArrivalDao.submitform(marketArrival);
	}

}
