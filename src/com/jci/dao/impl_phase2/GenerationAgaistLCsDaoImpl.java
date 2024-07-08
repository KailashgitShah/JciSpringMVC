package com.jci.dao.impl_phase2;

import java.util.List;
import java.math.BigInteger;

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
		String sql =" SELECT DISTINCT s.client_name, s.client_unit_code\r\n"
				+ "FROM (\r\n"
				+ "    SELECT d.client_name, c.client_unit_code\r\n"
				+ "    FROM jcimilldetailchild AS c\r\n"
				+ "    INNER JOIN jcimilldetailmaster AS d ON c.client_code = d.client_code\r\n"
				+ ") AS s\r\n"
				+ "INNER JOIN jcibos_generation AS b ON b.millcode = s.client_unit_code\r\n"
				+ "INNER join jcipayment_arrangement as d on d.millcode=b.millcode\r\n"
				+ "WHERE  d.Payment_type='Letter_of_Credit'  ";
			
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
	}

	@Override
	public List<Object> contractonmill(String millname) {
		
		String sql=  "SELECT DISTINCT b.Contract_no, s.client_unit_code\r\n"
				+ "FROM (\r\n"
				+ "    SELECT d.client_name, c.client_unit_code\r\n"
				+ "    FROM jcimilldetailchild AS c\r\n"
				+ "    INNER JOIN jcimilldetailmaster AS d ON c.client_code = d.client_code\r\n"
				+ ") AS s\r\n"
				+ "INNER JOIN jcibos_generation AS b ON b.millcode = s.client_unit_code\r\n"
				+ "INNER join jcipayment_arrangement as d on d.millcode=b.millcode\r\n"
				+ "WHERE b.millcode = '" + millname + "' and d.Payment_type='Letter_of_Credit' ";
		
		
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
//		 String sql ="\r\n"
//		 		+ "SELECT a.BOS_No,a.BOS_Date,a.Ivoice_value,a.challanono,b.Contract_no,b.millcode from jciboe as a "
//		 		+ " LEFT join jcibos_generation as b on b.Bill_of_supply_no=a.BOS_No \r\n"
//		 		+ " WHERE b.Contract_no= '" +st+"'"; 
		
		 String sql ="    SELECT b.Bill_of_supply_no, b.BOS_Date, b.Invoice_value, b.Challan_No, b.Contract_no, b.millcode \r\n"
		 		+ "FROM jcibos_generation AS b\r\n"
		 		+ " WHERE b.Contract_no= '" +st+"'"
		 		+ "AND b.Bill_of_supply_no NOT IN (SELECT BOS_No FROM jciboe)";
			 		
			    
					 		
					
					 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
					 return resultList1;
	}

	@Override
	public List<Object[]> forIFSC(String st) {
		  String sql ="SELECT \r\n"
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
		  		+ "    END AS Instrument_Date,\r\n"
		  		+ "    b.ifsc,\r\n"
		  		+ "    b.Payment_type \r\n"
		  		+ "FROM \r\n"
		  		+ "    jcidispatch_details AS a \r\n"
		  		+ "INNER JOIN \r\n"
		  		+ "    jcipayment_arrangement AS b \r\n"
		  		+ "ON \r\n"
		  		+ "    b.Contract_No = a.Contract_No"
			  		+ " WHERE  a.Contract_No = '" +st+"'"; 
			    
					 		
					
					 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
					 return resultList1;
	}

	@Override
	public List<Object[]> forQtyintopsheet(String st) {
		  String sql ="   select   a.Crop_year,a.Bale_mark,a.Jute_variety,a.Jute_grade,a.No_of_bales,a.Nominal_wt,a.Rate,a.Nominal_qty,a.Jute_value  from  jcidispatch_details_child  as a \r\n"
		  		+ "   left JOIN jcidispatch_details on jcidispatch_details.Challan_no=a.Challan_no where jcidispatch_details.Contract_No= '" +st+"'"; 
				    
						 		
						
						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
						 return resultList1;
	}

	@Override
	public String lcno() {
	
		String sql = "SELECT  count(*) FROM jciboe ";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		total++;
		
		return String.valueOf(total);
//		
//		 String sql = "SELECT MAX(serialno) FROM jciboe";
//		 		
//		  Object result = this.sessionFactory.getCurrentSession()
//                  .createSQLQuery(sql)
//                  .uniqueResult();
//
//
//		    if (result == null) {
//		        // Handle the case where no serial numbers are present in the table
//		        return "0000000001"; // Example default serial number if none exists
//		    }
//
//		    String maxSerialNoStr = (String) result; // Cast the result to String
//
//		    BigInteger maxSerialNo;
//		    try {
//		        maxSerialNo = new BigInteger(maxSerialNoStr); // Convert String to BigInteger
//		    } catch (NumberFormatException e) {
//		        // Handle the case where maxSerialNoStr is not a valid number format
//		        return "0000000001"; // Example default serial number if format is unexpected
//		    }
//
//		    // Increment the maximum serial number by 1
//		    BigInteger nextSerialNo = maxSerialNo.add(BigInteger.ONE);
//
//		    // Format the serial number to maintain consistent length (assuming 10 digits)
////		    String formattedSerialNo = String.format("%010d", nextSerialNo);
//		    return String.valueOf(nextSerialNo);
		  
		
	}

	@Override
	public List<Object[]> balanceammount(String st) {
//        String sql ="SELECT COALESCE(\r\n"
//        		+ "    (SELECT TOP 1 balanceammount\r\n"
//        		+ "     FROM jciboe \r\n"
//        		+ "     WHERE contractno = '" +st+"\r\n"
//        		+ "     ORDER BY BOS_No\r\n"
//        		+ "    ), 0) AS balanceamount; ";
		  
		  String sql ="   SELECT COALESCE((SELECT balanceammount FROM jciboe WHERE contractno='" +st+"'), 0) AS balanceamount\r\n"
		  		+ "";
		   List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
							 return resultList1;
		}
	

}
