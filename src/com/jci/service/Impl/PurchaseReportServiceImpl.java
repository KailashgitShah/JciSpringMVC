package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PurchaseReportDao;
import com.jci.model.Contractgeneration;
import com.jci.model.DailyReportDTO;
import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;
import com.jci.model.PurchaseReportDTO;
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
	@Override
	public List<DailyReportDTO> RegionReportList(String Basis, String Jute_Variety, String Crop_Year, String From_date,
			String To_date) {
		// TODO Auto-generated method stub
		return purchasereportDao.RegionReportList( Basis, Jute_Variety, Crop_Year, From_date,To_date);
	}
	
	@Override
	public List<DailyReportDTO> DailyReportList( String Basis,String Jute_Variety, String Crop_Year,String From_date,String To_date,String region){
		// TODO Auto-generated method stub
		return purchasereportDao.DailyReportList( Basis, Jute_Variety, Crop_Year, From_date,To_date,region);
	}
	
	@Override
	public List<PurchaseReportDTO> PurchaseReportList( String DPC, String Basis,String Jute_Variety, String Crop_Year, String From_date,String To_date) {
		// TODO Auto-generated method stub
		return purchasereportDao.PurchaseReportList(DPC, Basis, Jute_Variety, Crop_Year, From_date, To_date);
	}


	
}
