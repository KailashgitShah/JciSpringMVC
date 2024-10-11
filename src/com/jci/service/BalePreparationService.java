package com.jci.service;

import java.util.List;

import com.jci.model.BalePreparation;

public interface BalePreparationService {

	public void create(BalePreparation baleprep);
	public void update(BalePreparation baleprep);
	public BalePreparation edit(int id);

	public void delete(int id);
	public BalePreparation find(int id);
	public List<BalePreparation> getAll();
	public boolean submitform(BalePreparation off);
}
