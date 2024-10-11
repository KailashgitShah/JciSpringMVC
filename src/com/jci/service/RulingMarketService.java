package com.jci.service;

import java.util.List;

import com.jci.model.MarkerArrivalModelDTO;
import com.jci.model.RulingMarket;

public interface RulingMarketService {
	public void create(RulingMarket rulingMarket);
	public void update(RulingMarket rulingMarket);
	public RulingMarket edit(int id);
	public void delete(int id);
	public RulingMarket find(int id);
	public List<RulingMarket> getAll();
	public boolean submitform(RulingMarket rulingMarket);
	public List<MarkerArrivalModelDTO> MarketArrivalList(String arrivaldate, String region_id, String cropyear);
	public String getdatArrival(String arrivaldate);
	public List<MarkerArrivalModelDTO> MarketArrivalListRegion(String arrivaldate, String cropYear);
}
