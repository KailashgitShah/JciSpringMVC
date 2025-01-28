package com.jci.dao.impl_phase2;


import java.util.List;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
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
	@Autowired
    HttpSession session1;

	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel) {
		
		currentSession().save(generationOfBillSupplyModel);
	}
	@Override
    public List<GenerationOfBillSupplyModel> getAll(){
             String roIdString = (String) session1.getAttribute("regionId");
            System.err.println(roIdString);
            System.err.println(roIdString);
            System.err.println(roIdString);
            Integer roleId = (Integer)session1.getAttribute("roleId");
            String dcpId =(String) session1.getAttribute("dpcId");
            String sqlQString="";
            if(roleId ==6||roleId == 7 || roleId ==8 ) {
               sqlQString = "  SELECT * FROM jcibos_generation where Ro_id='"+roIdString+"' ORDER BY Bos_id DESC";
               }
            else if(roleId ==52 || roleId ==53) {
               
               sqlQString = " SELECT * FROM jcibos_generation where DPCID='"+dcpId+"'  ORDER BY Bos_id DESC";
            }
            else if(roleId == 51 || roleId ==1103||roleId==3|| roleId ==4 ||roleId == 1104) {
               sqlQString = "  SELECT * FROM jcibos_generation ORDER BY Bos_id DESC";
                    
            }
            else {
               return null;
            }
            
                 SQLQuery query = currentSession().createSQLQuery(sqlQString).addEntity(GenerationOfBillSupplyModel.class);
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
		String sql = "SELECT  a.unit_name, a.unit_address1,a.unit_address2,a.unit_location,a.unit_pin,  a.unit_state,  b.client_gstin, b.client_pan, b.client_state, b.client_address1,b.client_address2,b.client_location,\r\n"
				+ "b.client_pin,  b.client_name, a.client_unit_code FROM  jcimilldetailchild AS a LEFT JOIN jcimilldetailmaster AS b ON a.client_code = b.client_code where a.client_unit_code='"+ st+"'";
   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql) .list();
   System.out.println(resultList1);
   return resultList1;
     }
	
	
	@Override
	public  List<Object[]> Dispatchentry(String st) {
		String sql="select  Crop_year,Bale_mark,Jute_variety,Jute_grade,No_of_bales,Nominal_wt,Rate,Nominal_qty,Jute_value  from  jcidispatch_details_child where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
    }

	@Override
	public String billofsupplyno() {
		String sql = "SELECT \r\n"
				+ "    CASE \r\n"
				+ "        WHEN LEN(CAST(COALESCE(MAX(CAST(SUBSTRING(bill_of_supply_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR)) > 6 \r\n"
				+ "        THEN CAST(COALESCE(MAX(CAST(SUBSTRING(bill_of_supply_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR)\r\n"
				+ "        ELSE RIGHT('000000' + CAST(COALESCE(MAX(CAST(SUBSTRING(bill_of_supply_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR), 6)\r\n"
				+ "    END AS next_bill_of_supply_no\r\n"
				+ "FROM jcibos_generation\r\n"
				+ "WHERE ISNUMERIC(SUBSTRING(bill_of_supply_no, 4, 6)) = 1;";
		 String nextBillOfSupplyNo = (String) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();

		 return nextBillOfSupplyNo;
			

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
		
	    String hql = "UPDATE jcidispatch_details set Di_status = 1 where Challan_no = '" + st + "' ";
	    
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
		String sql="select  Mill_code,CropYear, CONVERT(varchar, Contract_date, 105) AS Contract_date from  jcicontract where  Contract_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public boolean millnamefromTCS(String millname) {
		String sql="select  Distinct Mill from  jcitds_entry  ";
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
		String sql="SELECT  Crop_year,Bale_mark,Jute_grade,No_of_bales,Nominal_wt,Nominal_qty,Rate FROM jcidispatch_details_child where Challan_no ='" + st + "' ";
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public List<Object[]> dispatchChildlist(String st) {
        String sql="SELECT Challan_no,Bale_mark,Crop_year,Jute_grade,Jute_value,No_of_bales,Nominal_wt, Nominal_qty,Rate FROM jcidispatch_details_child where Challan_no ='" + st + "' ";
		
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

	@Override
	public List<Object[]> Supplieradd(String st) {
		String sql="  select top 1 a.state_name , a.gov_state_code , e.State_GSTIN,c.centername,c.address1,c.address2,c.address3,c.address4 from tbl_states_new a\r\n"
				+ "		INNER join tbl_districts_new b on b.state_code = a.state_code\r\n"
				+ "		INNER JOIN jcipurchasecenter c on c.district = b.dist_code \r\n"
				+ "			INNER JOIN jcidispatch_details d ON c.CENTER_CODE = d.Place_of_Shipment\r\n"
				+ "		INNER JOIN jcigstin e on e.State_GST_Code = a.gov_state_code \r\n"
				+ "			WHERE c.CENTER_CODE ='" + st + "'";
			
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		System.err.println("DaoIMPL"+resultList1.toString());
		    return resultList1;
	}

	@Override
	public List<Object[]> PANSTATE(String st) {
		String sql=" select a.client_pan , a.client_state , b.unit_state , c.state_name , c.gov_state_code , c.state_code from jcimilldetailmaster a \r\n"
				+ "	inner join \r\n"
				+ "	jcimilldetailchild b on a.client_code = b.client_code and b.client_unit_code = '" + st + "'"
				+ "	INNER JOIN\r\n"
				+ "	 tbl_states_new c on c.state_code = a.client_state or  c.gov_state_code = b.unit_state\r\n";
			
			
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public String statecode(String st) {
	    String sql = "SELECT c.gov_state_code FROM jcipurchasecenter AS a INNER JOIN "
	            + "tbl_districts_new AS b ON a.district = b.dist_code INNER JOIN tbl_states_new AS c ON c.state_code = b.state_code "
	            + "WHERE a.CENTER_CODE='" + st + "'";
	    Integer result = (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
	    return result != null ? result.toString() : null; // Convert Integer to String, handling null case
	}

	@Override
	public String statecount(String st) {
		String sql = "SELECT  count(*) FROM jcibos_generation  where Statecode_forBOs='" + st + "'";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		total++;
		
		return String.valueOf(total);
			
	}

	@Override
	public List<Object[]> ForDate(String st) {
		String sql="    SELECT \r\n"
				+ "    CONVERT(VARCHAR, a.Contract_date, 103) AS Contract_date,\r\n"
				+ "    a.DI_No,\r\n"
				+ "    CONVERT(VARCHAR, a.DI_Date, 103) AS DI_Date,\r\n"
				+ "    CONVERT(VARCHAR, a.Date_of_shipment, 103) AS Date_of_shipment,\r\n"
				+ "    a.Contract_No,\r\n"
				+ "    CASE \r\n"
				+ "        WHEN b.Payment_type = 'Letter_of_Credit' THEN b.Instrument_No \r\n"
				+ "        ELSE 'N/A' \r\n"
				+ "    END AS Instrument_No,\r\n"
				+ "    CASE \r\n"
				+ "        WHEN b.Payment_type = 'Letter_of_Credit' THEN CONVERT(VARCHAR, b.Instrument_Date, 103) \r\n"
				+ "        ELSE '' \r\n"
				+ "    END AS Instrument_Date,ifsc,\r\n"
				+ "    b.Payment_type,a.Consignment_note_text,a.License_no \r\n"
				+ "FROM \r\n"
				+ "    jcidispatch_details AS a \r\n"
				+ "INNER JOIN \r\n"
				+ "    jcipayment_arrangement AS b \r\n"
				+ "ON  \r\n"
				+ "    b.Contract_No = a.Contract_No \r\n"
				+ "where  Challan_no='" + st + "'  ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public List<Object[]> Dpcname(String st,String  st1) {
		String sql="select employeename from jciumt WHERE dpcId='" + st1 + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public List<Object[]> RegionAndCenterName(String st) {
		String sql="  select a.centername,a.CENTER_CODE,b.roname,b.rocode  from  jcipurchasecenter as a LEFT join \r\n"
				+ "  jcirodetails as b  on a.rocode=b.rocode   where a.centertypecode='D' and a.CENTER_CODE='" + st + "'";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public Double sumofInvoicevalue(String st) {
		
	    String sql = "SELECT SUM(TRY_CAST(Invoice_value AS DECIMAL(18, 3))) AS TotalInvoiceValue\r\n"
	    		+ "FROM jcibos_generation\r\n"
	    		+ "WHERE millcode = '"+st+"'\r\n"
	    		+ "AND CONVERT(DATE, BOS_date, 103) BETWEEN DATEFROMPARTS(YEAR(GETDATE()) - CASE WHEN MONTH(GETDATE()) < 4 THEN 1 ELSE 0 END, 4, 1) AND GETDATE();\r\n"
	    		+ "";
	    
	
	    BigDecimal resultData = (BigDecimal) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
	    
	    
	    if (resultData != null) {
	        return resultData.doubleValue();
	    }
	    return 0.0; 
	}




}

	

