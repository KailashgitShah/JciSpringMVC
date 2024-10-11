package com.jci.dao;
import java.util.List;

import com.jci.model.MarketArrivalModel;
public interface MarketArrivalDao {

	public void create(MarketArrivalModel marketArrival);
	public void update(MarketArrivalModel marketArrival);
	public MarketArrivalModel edit(int id);
	public void delete(int id);
	public MarketArrivalModel find(int id);
	public List <MarketArrivalModel> getAlldata(String dpc_code, String regionId, String zoneId);
	public MarketArrivalModel getAlldetails(int id);
	public boolean submitform(MarketArrivalModel marketArrival);

}
