package com.jci.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PurchaseCenterDao;
import com.jci.model.PurchaseCenterModel;
import com.jci.model.RoDetailsModel;
import com.jci.service.PurchaseCenterService;

@Service
public class PurchaseCenterServiceImpl implements PurchaseCenterService {

	@Autowired
	PurchaseCenterDao purchaseCenterDao;

	@Override
	public void create(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoDetailsModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submitform(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> purchaseCenter(String regionCode,String role) {
		return purchaseCenterDao.purchaseCenter(regionCode,role);
	}



	@Override
	public List<String> dpcbyId(String dpc) {
		return purchaseCenterDao.dpcbyid(dpc);
	}

	@Override
	public List<String> getAllDpc() {
		return purchaseCenterDao.getAllDpc();
	}

	@Override
	public String findDpcname(String dpccode) {
		// TODO Auto-generated method stub
		return purchaseCenterDao.findDpcname(dpccode);
	}

	@Override
	public Map<String, String> getdpcbyregionid(String regionid) {
		// TODO Auto-generated method stub
		return purchaseCenterDao.getdpcbyregionid(regionid);
	}

	@Override
	public float findNominalWt(String dpc) {
		// TODO Auto-generated method stub
		return purchaseCenterDao.findNominalWt(dpc);
	}
	
	@Override
	public String findDpIdbyName(String dpc) {
		// TODO Auto-generated method stub
		return purchaseCenterDao.findDpIdbyName(dpc);
	}

//	@Override
//	public List<PurchaseCenterModel> getCenterCodeByCode(int rocode) {
//		purchaseCenterDao.
//		return null;
//	}

}
