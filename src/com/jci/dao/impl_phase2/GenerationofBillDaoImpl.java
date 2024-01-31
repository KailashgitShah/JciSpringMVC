package com.jci.dao.impl_phase2;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.GenerationofBillDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.GenerationOfBillSupplyModel;


@Repository
@Transactional
public class GenerationofBillDaoImpl implements GenerationofBillDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel) {
		
		currentSession().save(generationOfBillSupplyModel);
	}
	@Override
    public List<GenerationOfBillSupplyModel> getAll(){
        Criteria criteria = currentSession().createCriteria(GenerationOfBillSupplyModel.class);
        return criteria.list();
    }
	
	
	

	@Override
	public  List<Object[]> contarctno(String st) {
		String sql="select  Contract_No ,Creation_date,Mill_code from  jcidispatch_details where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}
	
	@Override
	public  List<Object[]>contarctnoformaster(String st) {
		String sql="SELECT c.Regional_Office, s.unit_name, s.unit_address1, s.unit_state, s.unit_location, s.client_gstin, s.client_pan, s.client_state, s.client_address1, s.client_name\r\n"
				+ "				FROM (SELECT a.unit_name, a.unit_address1, a.unit_state, a.unit_location,  b.client_gstin, b.client_pan, b.client_state, b.client_address1, b.client_name, a.client_unit_code\r\n"
				+ "			 FROM jcimilldetailchild AS a LEFT JOIN jcimilldetailmaster AS b ON a.client_code = b.client_code)\r\n"
				+ "				 AS s LEFT JOIN jcidispatch_details AS c ON s.client_unit_code = c.Mill_code\r\n"
				+ "                 WHERE c.Mill_code=860 ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
     }
	
	
	@Override
	public  List<Object[]> Dispatchentry(String st) {
		String sql="select  Crop_year,Bale_mark,Jute_variety,No_of_bales,Nominal_wt,Rate,Nominal_qty  from  jcidispatch_details where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}

	@Override
	public String billofsupplyno(String st) {
		String sql = "SELECT  count(*) FROM jcibos_generation WHERE Bill_of_supply_no = '" + st + "' ";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		
		
		if(total>0)
			return "1";
		else 
			return "0";

	}

	@Override
	public List<Object[]>ChallanNo() {
		String sql="select  Challan_no,Mill_code  from  jcidispatch_details";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public String billUpdation(String st) {
		
	    String hql = "UPDATE jcidispatch_details set Di_status = 1 where Contract_No = '" + st + "' ";
	    
	    String hql1 = "UPDATE jcicontract set contract_status='Bill of Supply Generated' where Contract_no = '" + st + "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
        this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		return hql1;
		
	}
	
	@Override
	public void remark(String remark ,String  con_No) {
		 String hql = "UPDATE  jcibos_generation set Remarks =  '" + remark + "'  where Contract_no = '" + con_No + "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}



}

	

