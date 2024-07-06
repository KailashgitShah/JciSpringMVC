package com.jci.dao.impl_phase2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.GenrationCashDocumentDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.TopsheetDetailsModel;


@Repository
@Transactional
public class GenrationCashDocumentDaoImpl implements GenrationCashDocumentDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(CashDocumentModel cashDocumentModel) {
		
		currentSession().saveOrUpdate(cashDocumentModel);
	}
	@Override
    public List<CashDocumentModel> getAll() {
        Criteria criteria = currentSession().createCriteria(CashDocumentModel.class);
        return criteria.list();
    }

	@Override
	public String fetchBos_No() {
	
       String sql="select  Bill_of_suply_no from  jcibos_generation";
		
		  //String resultList12= this.sessionFactory.getCurrentSession().createSQLQuery(sql);
	    return null;
	}

	@Override
	public List<Object> Non_lc( String st) {
		String sql="select Payment_type  from jcipayment_arrangement where Contract_No='" + st + "' ";
	    List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;

	}

	@Override
	public List<Object[]> fetchMill_Name() {
		String sql ="   SELECT DISTINCT s.client_name, s.client_unit_code\r\n"
				+ "FROM (\r\n"
				+ "    SELECT d.client_name, c.client_unit_code\r\n"
				+ "    FROM jcimilldetailchild AS c\r\n"
				+ "    INNER JOIN jcimilldetailmaster AS d ON c.client_code = d.client_code\r\n"
				+ ") AS s\r\n"
				+ "INNER join  jcibos_generation as b on b.millcode=s.client_unit_code ";
			
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
	}
	@Override
	public List<Object> contractonmill1(String millname) {
	    String sql = "SELECT DISTINCT b.Contract_no, s.client_unit_code " +
	                 "FROM ( " +
	                 "    SELECT d.client_name, c.client_unit_code " +
	                 "    FROM jcimilldetailchild AS c " +
	                 "    INNER JOIN jcimilldetailmaster AS d ON c.client_code = d.client_code " +
	                 ") AS s " +
	                 "INNER JOIN jcibos_generation AS b ON b.millcode = s.client_unit_code " +
	                 "INNER JOIN jcipayment_arrangement AS d ON d.millcode = b.millcode " +
	                 "WHERE b.millcode = '"+millname+"' and d.Payment_type <> 'Letter_of_Credit' ";

	    List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	   
	}

	@Override
	public void create(TopsheetDetailsModel topSheet) {
		currentSession().save(topSheet);
		
	}

	@Override
	public String topSheetId() {
		String sql = "SELECT  count(*) FROM jcitopsheet ";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		total++;
		
		return String.valueOf(total);
	}

	
}
