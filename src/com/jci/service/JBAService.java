package com.jci.service;

import java.util.List;

import com.jci.model.JbaModel;

public interface JBAService {

	public void update(JbaModel jbapri);
	public JbaModel edit(int id);
	public void delete(int id);
	public JbaModel find(int id);
	public List <JbaModel> getAll(String dpcid, String regionId, String zoneId);
	public boolean submitform(JbaModel off);
	public void create(JbaModel jbapri);

	public List <String> GetDayCountofJBA(String jbaId);
	public List<String> findGradeOnJute(String jvariety);
	public List<JbaModel> getAll();

}
