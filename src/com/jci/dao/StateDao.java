package com.jci.dao;

import java.util.List;

import com.jci.model.StateList;

public interface StateDao {
	public void create(StateList statelist);
	public void update(StateList statelist);
	public StateList edit(int id);
	public void delete(int id);
	public StateList find(int id);
	public List <StateList> getAll();
	public boolean submitform(StateList off);
	public String statebyid(String state_name);

}
