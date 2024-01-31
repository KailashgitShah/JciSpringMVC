package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CashDocumentModel;


public interface GenrationCashDocumentDao {
	public void create(CashDocumentModel cashDocumentModel);
	 public List<CashDocumentModel> getAll();
	public String fetchBos_No();
}
