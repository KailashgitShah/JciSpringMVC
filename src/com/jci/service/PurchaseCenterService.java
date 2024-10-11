package com.jci.service;

import java.util.List;
import java.util.Map;

import com.jci.model.PurchaseCenterModel;
import com.jci.model.RoDetailsModel;

public interface PurchaseCenterService {
	public void create(RoDetailsModel roDetails);
	public void update(RoDetailsModel roDetails);
	public RoDetailsModel edit(int id);
	public void delete(int id);
	public RoDetailsModel find(int id);
	public List <RoDetailsModel> getAll();
	public boolean submitform(RoDetailsModel roDetails);
	public List<String> purchaseCenter(String regionCode,String role);
	public List<String> dpcbyId(String dpc);
	public List<String> getAllDpc();
	public String findDpcname(String dpccode);
//	public List<PurchaseCenterModel>getCenterCodeByCode(int rocode);
	public Map<String, String> getdpcbyregionid(String regionid);
	public float findNominalWt(String dpc);
	public String findDpIdbyName(String dpc);

}
