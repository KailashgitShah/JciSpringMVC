package com.jci.dao;

import java.util.List;

import com.jci.model.blockModel;;

public interface BlockDao
{
	public void create(blockModel blocklist);
	public void update(blockModel blocklist);
	public blockModel  edit(int Block_Id);
	public void delete(int Block_Id);
	public blockModel find(int Block_Id);
	public List <blockModel> getAll();
	public List<String> getAllFilledlock(int id);
	public boolean submitform(blockModel off);

}
