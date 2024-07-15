package com.jci.dao;

import java.util.List;

import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;

public interface PurchaseReportDao {

	public String finddpcbyid(String id);
	public String fname(String id);
	public List<LedgerReportDTO> LedgerReportList(String basis,String cropyr, String farmer);
    public List<String> farmerdetail(String F_NAME);



}
