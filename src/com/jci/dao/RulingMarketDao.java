package com.jci.dao;

import java.util.List;

import com.jci.model.MarkerArrivalModelDTO;
import com.jci.model.RulingMarket;
public interface RulingMarketDao {
	public void create(RulingMarket RulingMarket);
	public void update(RulingMarket RulingMarket);
	public RulingMarket edit(int id);
	public void delete(int id);
	public RulingMarket find(int id);
	public List <RulingMarket> getAll();
	public boolean submitform(RulingMarket RulingMarket);

	public List<MarkerArrivalModelDTO> MarketArrivalList(String arrivaldate, String region_id, String cropyear);
	public String getdatArrival(String arrivaldate);
	public List<MarkerArrivalModelDTO> MarketArrivalListRegion(String arrivaldate, String cropYear);
}
