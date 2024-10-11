package com.jci.service;

import java.util.List;

import com.jci.model.RopeMakingModel;

public interface RopeMakingService {

	public void create(RopeMakingModel ropeMakingModel);
	public void update(RopeMakingModel ropeMakingModel);
	public RopeMakingModel edit(int id);
	public void delete(int id);
	public RopeMakingModel find(int id);
	
	public boolean submitform(RopeMakingModel off);
	public List <RopeMakingModel> ropeMakingList(int regionId);
	public List <String> findBinno(String cropyr, String dpcid);
	public List<RopeMakingModel> getAll(String placeofactivity, String regionId, String zoneId);
}
