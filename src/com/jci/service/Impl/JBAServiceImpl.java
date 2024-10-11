package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.JbaDao;
import com.jci.model.JbaModel;
import com.jci.service.JBAService;

@Service
public class JBAServiceImpl implements JBAService {

	@Autowired
	JbaDao jbadao;



	@Override
	public void update(JbaModel jbaModel) {
		jbadao.update(jbaModel);
	}

	@Override
	public JbaModel edit(int id) {
		return jbadao.edit(id);
	}

	@Override
	public void delete(int id) {
		jbadao.delete(id);
	}

	@Override
	public JbaModel find(int id) {
		return jbadao.find(id);
	}

	@Override
	public List<JbaModel> getAll(String dpcid, String regionId, String zoneId) {
		return jbadao.getAll(dpcid, regionId, zoneId);
	}

	@Override
	public boolean submitform(JbaModel off) {
		return jbadao.submitform(off);
	}

	@Override
	public void create(JbaModel jbaModel) {
		jbadao.create(jbaModel);

	}

	@Override
	public List <String> GetDayCountofJBA(String jbaId) {
		// TODO Auto-generated method stub
		return jbadao.GetDayCountofJBA(jbaId);
	}

	@Override
	public List<String> findGradeOnJute(String jvariety) {
		return  jbadao.findGradeOnJuteVariety(jvariety);
	}

	@Override
	public List<JbaModel> getAll() {
		// TODO Auto-generated method stub
		return  jbadao.getAll();
	}




}
