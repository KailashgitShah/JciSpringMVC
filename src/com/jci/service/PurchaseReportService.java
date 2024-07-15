package com.jci.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.jci.model.Contractgeneration;
import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;

@Service
public interface PurchaseReportService {

	public String finddpcbyid(String id);
	public String fname(String id);
	public List<LedgerReportDTO> LedgerReportList(String basis,String cropyr, String farmer);
    public List<String> farmerdetail(String F_NAME);

	

}
