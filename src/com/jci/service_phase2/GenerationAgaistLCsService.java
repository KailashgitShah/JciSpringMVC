package com.jci.service_phase2;

import java.util.List;


import com.jci.model.GenerationofDocumentLCsModel;

public interface GenerationAgaistLCsService {
	public void create(GenerationofDocumentLCsModel generationofDocumentLCsModel);
	 public List<GenerationofDocumentLCsModel>getAll();
	 public List<Object[]> fetchMill_NameforLC();
	 public List<Object[]> forIFSC(String st);
	 public List<Object[]> forQtyintopsheet(String st);
	 public List<Object[]> listdetailsofpaymemt(String st);
	 public List<Object[]> listdetailsbillofsupplly(String st);
	 public List<Object> contractonmill(String millname);
	  public   String lcno();
}
