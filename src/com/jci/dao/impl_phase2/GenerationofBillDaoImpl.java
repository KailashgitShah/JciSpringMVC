package com.jci.dao.impl_phase2;


import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.persistence.criteria.Order;
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

import org.hibernate.SQLQuery;

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
		 String sqlQuery = "SELECT * FROM jcibos_generation ORDER BY Bos_id DESC";
		    SQLQuery query = currentSession().createSQLQuery(sqlQuery).addEntity(GenerationOfBillSupplyModel.class);
		    return query.list();
    }
	
	
	

	@Override
	public  List<Object[]> contarctno(String st) {
		String sql="select  Contract_No ,Creation_date,Mill_code from  jcidispatch_details where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}
	
	@Override
	public  List<Object[]>contarctnoformaster(String st) {
		String sql = "SELECT  a.unit_name, a.unit_address1,  a.unit_state,   a.unit_location, b.client_gstin, b.client_pan, b.client_state, b.client_address1,  b.client_name, a.client_unit_code "
				+ " FROM  jcimilldetailchild AS a LEFT JOIN jcimilldetailmaster AS b ON a.client_code = b.client_code where a.client_unit_code='"+ st+"'";
   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql) .list();
   System.out.println(resultList1);
   return resultList1;
     }
	
	
	@Override
	public  List<Object[]> Dispatchentry(String st) {
		String sql="select  Crop_year,Bale_mark,Jute_variety,Jute_grade,No_of_bales,Nominal_wt,Rate,Nominal_qty  from  jcidispatch_details_child where  Challan_no='" + st + "' ";
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
	public List<Object[]>ChallanNo(String st) {
		String sql="SELECT  CONVERT(varchar, Date_of_shipment, 105) AS Date_of_shipment, Mode_of_shipment,Vehicle_no,\r\n"
				+ "  Driver_name,License_no,Driver_contact FROM jcidispatch_details where Challan_no ='" + st + "' ";
		//String sql="select  CONVERT(VARCHAR(10), Date_of_shipment, 105) AS Formatted_Date_of_shipment, ,Mode_of_shipment,Vehicle_no,Driver_name,License_no,Driver_contact from  jcidispatch_details where Challan_no ='" + st + "' ";
		 
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

	@Override
	public GenerationOfBillSupplyModel find(int id) {
		
		return find(id);
	}

	@Override
	public List<Object[]> contrcatnotomill(String st) {
		String sql="select  Mill_code,CropYear from  jcicontract where  Contract_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public boolean millnamefromTCS(String millname) {
		String sql="select Mill from  jcitds_entry ";
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 for (Object mill : resultList1) {
		        if (millname.equals(mill.toString())) {
		            return true; // Mill name found
		        }
		    }
		    
		    return false; // Mill name not found
	}

	@Override
	public List<Object[]> ShipmentDetails(String st) {
		String sql="SELECT  Crop_year,Bale_mark,Jute_variety,No_of_bales,Nominal_wt,Rate,Nominal_qty FROM jcidispatch_details_child where Challan_no ='" + st + "' ";
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public List<Object[]> dispatchChildlist(String st) {
        String sql="SELECT Challan_no,Bale_mark,Crop_year,Jute_grade,Jute_value,Jute_variety,No_of_bales,Nominal_wt, Nominal_qty,Rate FROM jcidispatch_details_child where Challan_no ='" + st + "' ";
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public List<Object[]> GenrationAginstLCs(String st) {
		 String sql="SELECT Instrument_No,Payment_type FROM jcipayment_arrangement where Contract_No ='" + st + "' ";
			
			List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			 if (resultList1.isEmpty()) {
		            return null; // Return an integer 0 if no results found
		        } else {
		            return resultList1; // Return the resultList if results are found
		        }
	}

	@Override
	public List<Object[]> DocumentLcsEntry(String st) {
		
		String sql="  select  distinct a.Mill_code,CONVERT(VARCHAR, a.Date_of_shipment,105 ) AS Date_of_shipment,b.DI_Date,b.DI_no from  jcidispatch_details as a LEFT JOIN jciDI_ho\r\n"
				+ "			 as b on a.Contract_No=b.Contract_No  where a.Contract_No ='" + st + "'";
			
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}



}

	

