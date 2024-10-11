package com.jci.dao;
import java.util.List;

import com.jci.model.ZoneModel;
public interface ZoneDao {
	public void create(ZoneModel zone);
	public void update(ZoneModel zone);
	public ZoneModel edit(int id);
	public void delete(int id);
	public ZoneModel find(int id);
	public List <ZoneModel> getAll();
	public boolean submitform(ZoneModel zone);
}
