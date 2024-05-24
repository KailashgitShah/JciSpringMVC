package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.GenerationAgaistLCsDao;

import com.jci.model.GenerationofDocumentLCsModel;


@Repository
@Transactional
public class GenerationAgaistLCsDaoImpl implements GenerationAgaistLCsDao {

	 @Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(GenerationofDocumentLCsModel generationofDocumentLCsModel) {
		
		currentSession().saveOrUpdate(generationofDocumentLCsModel);
	}
	@Override
    public List<GenerationofDocumentLCsModel> getAll() {
        Criteria criteria = currentSession().createCriteria(GenerationofDocumentLCsModel.class);
        return criteria.list();
    }

}
