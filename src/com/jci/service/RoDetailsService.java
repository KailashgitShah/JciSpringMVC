package com.jci.service;

import java.util.List;

import com.jci.model.RoDetailsModel;

public interface RoDetailsService {
	public void create(RoDetailsModel roDetails);
	public void update(RoDetailsModel roDetails);
	public RoDetailsModel edit(int id);
	public void delete(int id);
	public String findregionbyid(String region);
	public RoDetailsModel find(int id);
	public List <RoDetailsModel> getAll();
	public boolean submitform(RoDetailsModel roDetails);
	public List<String> zonecode(String zoneCode);
	public String dpcCheck(String dpc);
	
}
