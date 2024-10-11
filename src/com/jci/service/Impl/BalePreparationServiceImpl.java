package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BalePreparationdao;
import com.jci.model.BalePreparation;
import com.jci.service.BalePreparationService;

@Service
public class BalePreparationServiceImpl implements BalePreparationService {

	@Autowired
	BalePreparationdao baledao;

	@Override
	public void create(BalePreparation baleprep) {
		baledao.create(baleprep);
	}

	@Override
	public void update(BalePreparation baleprep) {
		baledao.update(baleprep);

	}

	@Override
	public BalePreparation edit(int id) {
		return baledao.edit(id);
	}

	@Override
	public void delete(int id) {
		baledao.delete(id);
	}

	@Override
	public BalePreparation find(int id) {
		return baledao.find(id);
	}

	@Override
	public List<BalePreparation> getAll() {
		return baledao.getAll();
	}

	@Override
	public boolean submitform(BalePreparation off) {
		// TODO Auto-generated method stub
		return false;
	}





}
