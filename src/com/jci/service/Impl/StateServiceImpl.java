package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.StateDao;
import com.jci.model.StateList;
import com.jci.service.StateService;
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateDao stateListDao;


	@Override
	public void create(StateList statelist) {
		stateListDao.create(statelist);

	}

	@Override
	public void update(StateList statelist) {
		stateListDao.update(statelist);

	}

	@Override
	public StateList edit(int id) {
		return stateListDao.edit(id);
	}

	@Override
	public void delete(int id) {
		stateListDao.delete(id);

	}

	@Override
	public StateList find(int id) {
		return stateListDao.find(id);
	}

	@Override
	public List<StateList> getAll() {
		return stateListDao.getAll();
	}

	@Override
	public boolean submitform(StateList off) {
		return stateListDao.submitform(off);
	}

	@Override
	public String statebyid(String state_name) {
		// TODO Auto-generated method stub
		return stateListDao.statebyid(state_name);
	}

}
