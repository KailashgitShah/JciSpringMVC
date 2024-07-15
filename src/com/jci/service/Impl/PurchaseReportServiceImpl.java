package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PurchaseReportDao;
import com.jci.model.Contractgeneration;
import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;
import com.jci.service.PurchaseReportService;

@Service
public class PurchaseReportServiceImpl implements PurchaseReportService {

	@Autowired
	PurchaseReportDao purchasereportDao;


	@Override
	public String finddpcbyid(String id) {
		// TODO Auto-generated method stub
		return purchasereportDao.finddpcbyid(id);
	}

	@Override
	public List<LedgerReportDTO> LedgerReportList(String basis, String cropyr, String farmer) {
		// TODO Auto-generated method stub
		return purchasereportDao.LedgerReportList(basis,cropyr,farmer);
	}

	@Override
	public String fname(String id) {
		// TODO Auto-generated method stub
		return purchasereportDao.fname(id);
	}


	@Override
	public List<String> farmerdetail(String F_NAME) {
		// TODO Auto-generated method stub
		return purchasereportDao.farmerdetail( F_NAME);
	}
	

	
}
