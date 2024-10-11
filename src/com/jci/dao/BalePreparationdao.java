package com.jci.dao;

import java.util.List;

import com.jci.model.BalePreparation;

public interface BalePreparationdao {

	//public void create(BalePreparationModel baleprep);
	public BalePreparation edit(int id);
	public void delete(int id);
	public BalePreparation find(int id);
	public List<BalePreparation> getAll();
	public boolean submitform(BalePreparation balemod);
	public void create(BalePreparation baleprep);
	public void update(BalePreparation baleprep);

}
