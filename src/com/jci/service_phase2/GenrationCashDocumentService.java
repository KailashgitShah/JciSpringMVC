package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.CashDocumentModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.TopsheetDetailsModel;

@Service
public interface GenrationCashDocumentService {
	public void create(CashDocumentModel cashDocumentModel);
	 public List<CashDocumentModel>getAll();
	public String fetchBos_No();
	public List<Object> Non_lc(String St);
	 public List<Object[]> fetchMill_Name();
	 public List<Object> contractonmill1(String millname);
	 public void create(TopsheetDetailsModel topSheet );
	  public   String topSheetId();
	  public List<TopsheetDetailsModel> getAlltopsheetdata();
	
}
