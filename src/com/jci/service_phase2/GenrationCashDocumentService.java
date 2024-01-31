package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.CashDocumentModel;


@Service
public interface GenrationCashDocumentService {
	public void create(CashDocumentModel cashDocumentModel);
	 public List<CashDocumentModel>getAll();
	public String fetchBos_No();
}
