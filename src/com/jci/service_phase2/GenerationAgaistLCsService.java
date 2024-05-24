package com.jci.service_phase2;

import java.util.List;


import com.jci.model.GenerationofDocumentLCsModel;

public interface GenerationAgaistLCsService {
	public void create(GenerationofDocumentLCsModel generationofDocumentLCsModel);
	 public List<GenerationofDocumentLCsModel>getAll();
	
}
