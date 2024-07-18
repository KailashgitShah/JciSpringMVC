package com.jci.service;

import java.util.List;

import com.jci.model.RoDetailsModel;

public interface RoDetailsService {
	public void create(RoDetailsModel roDetails);
	public void update(RoDetailsModel roDetails);
	public RoDetailsModel edit(int id);
	public void delete(int id);
	public RoDetailsModel find(int id);
	public List <RoDetailsModel> getAll();
	public boolean submitform(RoDetailsModel roDetails);
	public List<String> zonecode(String zoneCode);
	public String getRoname(String region_id);
	public String findregionbyname(String region);
	public String getregionIdbyName(String region);


}
