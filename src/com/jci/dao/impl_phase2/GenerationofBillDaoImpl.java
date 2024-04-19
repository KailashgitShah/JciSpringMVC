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
		String sql = "SELECT\r\n"
				+ "            a.unit_name,\r\n"
				+ "            a.unit_address1,\r\n"
				+ "            a.unit_state,\r\n"
				+ "            a.unit_location,\r\n"
				+ "            b.client_gstin,\r\n"
				+ "            b.client_pan,\r\n"
				+ "            b.client_state,\r\n"
				+ "            b.client_address1,\r\n"
				+ "            b.client_name,\r\n"
				+ "            a.client_unit_code\r\n"
				+ "        FROM\r\n"
				+ "            jcimilldetailchild AS a\r\n"
				+ "        LEFT JOIN\r\n"
				+ "            jcimilldetailmaster AS b ON a.client_code = b.client_code where a.client_unit_code='"+ st+"'";
   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql) .list();
   System.out.println(resultList1);
   return resultList1;
     }
	
	
	@Override
	public  List<Object[]> Dispatchentry(String st) {
		String sql="select  Crop_year,Bale_mark,Jute_variety,No_of_bales,Nominal_wt,Rate,Nominal_qty  from  jcidispatch_details_child where  Challan_no='" + st + "' ";
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
	public List<Object> millnamefromTCS() {
		String sql="select Mill from  jcitds_entry ";
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public List<Object[]> ShipmentDetails(String st) {
		String sql="SELECT  Crop_year,Bale_mark,Jute_variety,No_of_bales,Nominal_wt,Rate FROM jcidispatch_details_child where Challan_no ='" + st + "' ";
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}



}

	

