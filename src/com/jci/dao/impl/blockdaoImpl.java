package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BlockDao;
import com.jci.model.blockModel;

@Transactional
@Repository
public class blockdaoImpl implements BlockDao{
		@Autowired
		SessionFactory sessionFactory;
		protected Session currentSession(){
			return sessionFactory.getCurrentSession();
		}


		@Override
		public void create(blockModel blocklist) {
			currentSession().save(blocklist);

		}
		@Override
		public void update(blockModel blocklist) {
			currentSession().update(blocklist);

		}
		@Override
		public blockModel edit(int Block_Id) {
			return find(Block_Id);
		}
		@Override
		public blockModel find(int Block_Id) {
			return (blockModel) currentSession().get(blockModel.class, Block_Id);
		}
		@Override
		public List<blockModel> getAll() {
			//System.out.println("Hello From StateListModel");
			List<blockModel> ll;
			Criteria c = this.sessionFactory.getCurrentSession().createCriteria(blockModel.class);
			ll=c.list();
			return ll;
		}

		@Override
		public void delete(int id) {
			blockModel prod = new blockModel();
			String hql = "Delete from dbo.product where id = '"+id+"' " ;
			 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			//List<String> results = query.list();
		}

		@Override
		public boolean submitform(blockModel off) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(off);
			return false;
		}

		@Override
		//public List<String> getAllFilledlock(String F_District) {
 	public List<String> getAllFilledlock(int block) {
			System.out.println("block value from DaoImpl is "+block);
			String hql = "select Block_Name from tbl_blocks where district_id ='"+block+"'";

	//	public List<String> getAllFilledlock(String F_District) {


			//System.out.println("block value from DaoImpl is "+block);


		//	String hql = "select Block_Name from tbl_blocks where district_name ='"+F_District+"'";


	//		String hql = "select Block_Name from tbl_blocks where district_name ='"+F_District+"'";


			Query query = this.sessionFactory.getCurrentSession().createSQLQuery(hql);
			List<String> results = query.list();
			return results;
		}


}



