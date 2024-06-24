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

	@Override
	public List<Object[]> fetchMill_NameforLC() {
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
	public List<Object> contractonmill(String millname) {
	  	String sql=  "  SELECT DISTINCT b.Contract_no, s.client_unit_code\r\n"
	  			+ "FROM (\r\n"
	  			+ "    SELECT d.client_name, c.client_unit_code\r\n"
	  			+ "    FROM jcimilldetailchild AS c\r\n"
	  			+ "    INNER JOIN jcimilldetailmaster AS d ON c.client_code = d.client_code\r\n"
	  			+ ") AS s\r\n"
	  			+ "INNER join  jcibos_generation as b on b.millcode=s.client_unit_code  WHERE b.millcode='" + millname + "' "
	  			+ "";
	  	 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public List<Object[]> listdetailsofpaymemt(String st) {
		  String sql ="SELECT \r\n"
		  		+ "    bank,\r\n"
		  		+ "    branch,\r\n"
		  		+ "    ifsc,\r\n"
		  		+ "    CONVERT(varchar, Instrument_Date, 103) AS Instrument_Date,\r\n"
		  		+ "    Instrument_No,\r\n"
		  		+ "    Instrument_value,\r\n"
		  		+ "    Supporting_document,\r\n"
		  		+ "    Auto_revolving_amount,\r\n"
		  		+ "    CONVERT(varchar, Expiry_date, 103) AS Expiry_date,\r\n"
		  		+ "    CONVERT(varchar, Last_shipment_date, 103) AS Last_shipment_date,\r\n"
		  		+ "    Payment_type,\r\n"
		  		+ "    CONVERT(varchar, PaymentDue_date, 103) AS PaymentDue_date\r\n"
		  		+ "FROM jcipayment_arrangement\r\n"
		  		+ " WHERE Contract_No= '" +st+"'"; 
		    
				 		
				
				 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
				 return resultList1;
	}

	@Override
	public List<Object[]> listdetailsbillofsupplly(String st) {
		 String sql ="\r\n"
		 		+ "SELECT a.BOS_No,a.BOS_Date,a.Ivoice_value,a.challanono,b.Contract_no,b.millcode from jciboe as a "
		 		+ " LEFT join jcibos_generation as b on b.Bill_of_supply_no=a.BOS_No \r\n"
		 		+ " WHERE b.Contract_no= '" +st+"'"; 
			    
					 		
					
					 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
					 return resultList1;
	}

}
