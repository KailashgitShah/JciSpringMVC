package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.RoDispatchDao;
import com.jci.model.RoDispatchModel;
import com.jci.service_phase2.RoDispatchService;

@Service
public class RoDispatchServiceImpl implements RoDispatchService{
	
	@Autowired
	RoDispatchDao roDispatchDao;

	@Override
	public List<String> loadAllDpc() {
		List<String> loadAllDpc = this.roDispatchDao.loadAllDpc();
		return loadAllDpc;
	}

	@Override
	public List<String> loadAllDiNo() {
		List<String> listOfAllDiNo = this.roDispatchDao.loadAllDiNo();
		return listOfAllDiNo;
	}

	@Override
	public List<Object> loadFullContractDetails(String diNo) {
		List<Object> list = this.roDispatchDao.loadAllContractDetails(diNo);
		return list;
	}

	@Override
	public int getCountOfAvailableEntries(String hoNo) {
		return this.roDispatchDao.getCountOfAvailableEntries(hoNo);
	}

	@Override
	public void create(RoDispatchModel roDispatchModel) {
		roDispatchDao.create(roDispatchModel);
		
	}

	@Override
	public List<RoDispatchModel> getAllRoDi() {
		List<RoDispatchModel> list = (List<RoDispatchModel>) this.roDispatchDao.getAllRoDi();
		return list;
	}
	@Override
	public List<String> getCooperative(String regionIdString) {
		// TODO Auto-generated method stub
		return roDispatchDao.getCooperative(regionIdString);
	}

	@Override
	public List<String> getDetails(String hOno) {
		// TODO Auto-generated method stub
		return roDispatchDao.getDetails(hOno);
	}

	@Override
	public List<String> getprevious(String diNo) {
		// TODO Auto-generated method stub
		return roDispatchDao.getprevious(diNo);
	}

	@Override
	public void update(String contractNoString) {
		// TODO Auto-generated method stub
		roDispatchDao.update(contractNoString);
		
	}

}
