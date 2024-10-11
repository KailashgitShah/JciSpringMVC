package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RulingMarketDao;
import com.jci.model.MarkerArrivalModelDTO;
import com.jci.model.RulingMarket;
import com.jci.service.RulingMarketService;

@Service
public class RulingMarketServiceImpl implements RulingMarketService {

	@Autowired
	RulingMarketDao rulingDao;

	@Override
	public void create(RulingMarket rulingMarket) {
		rulingDao.create(rulingMarket);
	}

	@Override
	public void update(RulingMarket rulingMarket) {
		rulingDao.update(rulingMarket);
	}

	@Override
	public RulingMarket edit(int id) {
		return rulingDao.edit(id);
	}

	@Override
	public void delete(int id) {
		rulingDao.delete(id);
	}

	@Override
	public RulingMarket find(int id) {
		return rulingDao.find(id);
	}

	@Override
	public List<RulingMarket> getAll() {
		return rulingDao.getAll();
	}

	@Override
	public boolean submitform(RulingMarket rulingMarket) {
		return rulingDao.submitform(rulingMarket);
	}

	@Override
	public List<MarkerArrivalModelDTO> MarketArrivalList(String arrivaldate, String region_id, String cropyear) {
		// TODO Auto-generated method stub
		return rulingDao.MarketArrivalList(arrivaldate, region_id,cropyear);
	}

	@Override
	public String getdatArrival(String arrivaldate) {
		// TODO Auto-generated method stub
		return rulingDao.getdatArrival(arrivaldate);
	}

	@Override
	public List<MarkerArrivalModelDTO> MarketArrivalListRegion(String arrivaldate, String cropYear) {
		// TODO Auto-generated method stub
		return rulingDao.MarketArrivalListRegion(arrivaldate,cropYear);
	}

}
