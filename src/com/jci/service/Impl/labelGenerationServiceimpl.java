package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.labelGenerationDao;
import com.jci.model.labelGenerationModel;
import com.jci.service.labelGenerationService;



@Service
public class labelGenerationServiceimpl implements labelGenerationService {

	@Autowired
	labelGenerationDao labelgenerationDao;
	
	@Override
	public void create(labelGenerationModel label) {
		// TODO Auto-generated method stub
		labelgenerationDao.create(label);
	}

	@Override
	public void update(labelGenerationModel label) {
		// TODO Auto-generated method stub
		labelgenerationDao.update(label);
	}

	@Override
	public labelGenerationModel edit(int id) {
		// TODO Auto-generated method stub
		return labelgenerationDao.edit(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		labelgenerationDao.delete(id);
	}

	@Override
	public labelGenerationModel find(int id) {
		// TODO Auto-generated method stub
		return labelgenerationDao.find(id);
	}

	@Override
	public List<labelGenerationModel> getAll() {
		// TODO Auto-generated method stub
		return labelgenerationDao.getAll();
	}

}
