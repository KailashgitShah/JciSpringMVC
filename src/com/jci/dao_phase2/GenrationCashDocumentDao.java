package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CashDocumentModel;
import com.jci.model.TopsheetDetailsModel;


public interface GenrationCashDocumentDao {
	public void create(CashDocumentModel cashDocumentModel);
	 public List<CashDocumentModel> getAll();
	public String fetchBos_No();
	public List<Object> Non_lc(String St);
	public List<Object[]> fetchMill_Name();
	 public List<Object> contractonmill1(String millname);
	 public void create(TopsheetDetailsModel topSheet );
	 public   String topSheetId();
	 
	 public List<TopsheetDetailsModel> getAlltopsheetdata();
	 
	
}
