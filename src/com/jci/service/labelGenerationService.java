package com.jci.service;

import java.util.List;

import com.jci.model.labelGenerationModel;

public interface labelGenerationService {

	public void create(labelGenerationModel label);
	public void update(labelGenerationModel label);
	public labelGenerationModel edit(int id);
	public void delete(int id);
	public labelGenerationModel find(int id);
	public List <labelGenerationModel> getAll();
	
}
