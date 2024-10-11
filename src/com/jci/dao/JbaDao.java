package com.jci.dao;

import java.util.List;

import com.jci.model.JbaModel;

public interface JbaDao {

	public JbaModel edit(int id);
	public void delete(int id);
	public JbaModel find(int id);
	public List <JbaModel> getAll(String dpcid, String regionId, String zoneId);
	public boolean submitform(JbaModel jbam);
	public void create(JbaModel jbam);
	public void update(JbaModel jbam);

	public List <String>  GetDayCountofJBA(String jbaId);
	public List<String> findGradeOnJuteVariety(String jvariety);
	public List<JbaModel> getAll();



}
