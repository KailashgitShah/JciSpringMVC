package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.GenerationofDocumentLCsModel;

public interface  GenerationAgaistLCsDao {
	public void create(GenerationofDocumentLCsModel generationofDocumentLCsModel);
	 public List<GenerationofDocumentLCsModel>getAll();
}
