package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UserPriviligeDao;
import com.jci.model.UserPriviligeModel;
@Transactional
@Repository
public class UserPriviligeDaoImpl implements UserPriviligeDao {

	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(UserPriviligeModel userprivilige) {
		
		String roleid = userprivilige.getRole_Id();
		String actionpermissionString = userprivilige.getAction_permissions();
		String dbroleid = "";
		try {
	    	   String querystr = "select role_Id from jciuserprivilege where role_Id = '"+roleid+"'";
	    	   Session session = sessionFactory.getCurrentSession();
	    	   Transaction tx = session.beginTransaction();
	    	   SQLQuery query = session.createSQLQuery(querystr);
	    	   dbroleid = query.list().get(0).toString();
			
			if(roleid.equals(dbroleid))
			{
				String hql = "update jciuserprivilege set action_permissions = '"+actionpermissionString+"' where role_Id = '"+roleid+"'";
				this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
				
			}
			else 
			{
				currentSession().saveOrUpdate(userprivilige);
			}
		  }
			catch(Exception e) {
	    		System.out.println(e.getStackTrace());
	    	}
		
		
	}

	public String getUserPrivilegeListing(int role_Id) {
	       	   String querystr = "select top 1 action_permissions from jciuserprivilege where role_Id='"+role_Id+"' order by created_date desc";
	       	   Session session = sessionFactory.getCurrentSession();
	       	   Transaction tx = session.beginTransaction();
	       	   SQLQuery query = session.createSQLQuery(querystr);
	       	   List<String> data = query.list();
	       
	       	if(!data.isEmpty()) {
				return data.toString();
				
			}
			else {
				return null;
			}
		
	}

	
	public List<String> getuserpriviligeajaxallData() {
		List<String> actions=new ArrayList();
		List<Object[]> data= new ArrayList();
		  try {
		
    	   String querystr = "select action_id,action_name from jciuseraction";
    	   Session session = sessionFactory.getCurrentSession();
    	   Transaction tx = session.beginTransaction();
    	   SQLQuery query = session.createSQLQuery(querystr);
    	   data = query.list();
    	 for(Object[] o :data) {
    		 int id=(int)o[0];
    		 String a=(String)o[1];
					//System.out.println("action_name===>>>>> "+id+","+a);
					actions.add(id+":"+a);
    	 }
		}
		
		catch(Exception e) {
    		System.out.println(e.getStackTrace());
    	}
		   return actions;
}
	
	
	
	@Override
	public String getactionPer(Integer userRole) {
		 String actionpermission = ""; 
		try {
    	   String querystr = "select action_permissions from jciuserprivilege where role_Id = '"+userRole+"'";
    	   Session session = sessionFactory.getCurrentSession();
    	   Transaction tx = session.beginTransaction();
    	   SQLQuery query = session.createSQLQuery(querystr);
    	   actionpermission = query.list().get(0).toString();
    	  // System.err.println("actionpermission=="+actionpermission);
		}
		
		catch(Exception e) {
    		System.out.println(e.getStackTrace());
    	}
		   return actionpermission;
	}
}
