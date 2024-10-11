package com.jci.service;

import java.util.List;

import com.jci.model.blockModel;;

public interface blockService
{
	public void create(blockModel block);
	public void update(blockModel block);
	public blockModel edit(int id);
	public void delete(int id);
	public blockModel find(int id);
	public List <blockModel> getAll();
	public boolean submitform(blockModel off);
	public List <String> getAllFilledlock(int id);
}

