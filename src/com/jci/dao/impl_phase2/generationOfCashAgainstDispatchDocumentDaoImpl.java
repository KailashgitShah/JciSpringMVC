package com.jci.dao.impl_phase2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.generationOfCashAgainstDispatchDocumentDao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jci.model.TopSheetDto;
import com.jci.model.boenonlcDTO;

@Repository
@Transactional
public class generationOfCashAgainstDispatchDocumentDaoImpl implements generationOfCashAgainstDispatchDocumentDao {
	 @Autowired
		SessionFactory sessionFactory;
		protected Session currentSession(){
			return sessionFactory.getCurrentSession();
		}



	@Override
		public List<TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String millname, String contractNo) {
	      
			String contract = contractNo;
			 String sqlQuery = "SELECT "
	                 + "jcibos_generation.Challan_No, "
	                 + "jciDI_ho.DI_no, "
	                 + "jciDI_ho.DI_Date, "
	                 + "jcidispatch_details.Date_of_shipment, "
	                 + "jcibos_generation.Bill_of_supply_no, "
	                 + "jcidispatch_details_child.No_of_bales * jcidispatch_details_child.Nominal_wt, "
	                 + "jcibos_generation.Invoice_value, "
	                 + "jcipayment_arrangement.Instrument_Date, "
	                 + "jcimilldetailchild.client_unit_code, "
	                 + "jcimilldetailchild.unit_name "
	                 + "FROM jcibos_generation "
	                 + "INNER JOIN jciDI_ho ON '"+contractNo+"' = jciDI_ho.Contract_No "
	                 + "INNER JOIN jcipayment_arrangement ON '"+contractNo+"' = jcipayment_arrangement.Contract_No "
	                 + "INNER JOIN jcidispatch_details ON '"+contractNo+"'= jcidispatch_details.Contract_No "
	                 + "INNER JOIN jcimilldetailchild ON jcimilldetailchild.client_unit_code = '" + millname + "' "
	                 + "INNER JOIN jcidispatch_details_child ON jcidispatch_details_child.Challan_no = jcibos_generation.Challan_No "
	                 + "WHERE jcibos_generation.Contract_no = '" + contractNo + "'";
				    List<TopSheetDto> list1 = new ArrayList<>();
				    List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();
				    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		            String formattedDate = dateFormat.format(new Date());
		           
				    for (Object[] eleObject : contracts) {
				    	
				    	Date dateShipment= (Date) eleObject[3];
				        LocalDate localDate = dateShipment.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				        
				        // Format LocalDate to String "dd-MM-yyyy"
				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				        String formattedDate1 = localDate.format(formatter);
				        
				       
		
				    	TopSheetDto topSheet = new TopSheetDto();			  
				    	topSheet.setChallan_no((String) eleObject[0]);
				    	topSheet.setDi_No((String) eleObject[1]);
				    	topSheet.setDi_Date((String) eleObject[2]);
				    	topSheet.setDateOfShipment(formattedDate1);
				    	topSheet.setBos_no((String) eleObject[4]);
				    	topSheet.setQuantity((Double) eleObject[5]);
				    	topSheet.setInvoiceValue((String) eleObject[6]);
				    	topSheet.setInstrument_Date((Date) eleObject[7]);
				    	topSheet.setMillcode((String) eleObject[8]);
				    	topSheet.setMillName((String) eleObject[9]);			    	
				    	topSheet.setTodayDate((String)formattedDate);
				    	topSheet.setContract_no((String)contract);
				        list1.add(topSheet);
				    }

				    return list1;
		}
		

		@Override
		public List<boenonlcDTO> getBOENONLC(String contractno) {
			String contract = contractno;
			String sqlQuery = "SELECT "  
				    + "jcibos_generation.Bill_of_supply_no, "
				    + "jcibos_generation.BOS_date, "
				    + "jcibos_generation.Invoice_value, "
				    + "jcibos_generation.Contract_no, "
				    + "jcibos_generation.millcode, "
				    + "jcimilldetailchild.unit_name, "
				    + "jcimilldetailchild.unit_address1, "
				    + "jcicontract.Contract_date, "
				    + "jcicontract.CropYear "
				    + "FROM jcibos_generation "
				    + "INNER JOIN jcimilldetailchild ON jcimilldetailchild.client_unit_code = jcibos_generation.millcode "
				    + "INNER JOIN jcicontract ON jcicontract.Contract_no = jcibos_generation.Contract_no " // Assuming contract is a variable here
				    + "WHERE jcibos_generation.Contract_no = '"+contract+"'"; 
			
			
			  List<boenonlcDTO> list1 = new ArrayList<>();
			    List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();
			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	          String formattedDate = dateFormat.format(new Date());
	         
			    for (Object[] eleObject : contracts) {
			    	boenonlcDTO boenonlc = new boenonlcDTO();			  
			    	boenonlc.setBos_no((String) eleObject[0]);
			    	boenonlc.setBos_date((String) eleObject[1]);
			    	boenonlc.setInvoiceValue((String) eleObject[2]);
			    	boenonlc.setContract_no((String) eleObject[3]);
			    	boenonlc.setMillcode((String) eleObject[4]);
			    	boenonlc.setMillname((String) eleObject[5]);
			    	boenonlc.setMilladdress((String) eleObject[6]);
			    	boenonlc.setContractdate((String) eleObject[7]);
			    	boenonlc.setCropyear((String) eleObject[8]);
			    	boenonlc.setTodayDate(formattedDate);
			    	
			        list1.add(boenonlc);
			    }

			    return list1;
					// TODO Auto-generated method stub
					
				}

		@Override
		public List<Object[]> listdetailsbillofsupplly1(String st) {
			 String sql = "SELECT DISTINCT Bill_of_supply_no, BOS_date, Invoice_value, Challan_No " +
	                 "FROM jcibos_generation " +
	                 "WHERE Contract_no = '"+st+"'";

						
						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
						 return resultList1;
		}

//		@Override
//		public List<Object[]> listdetailsofpaymemt1(String st) {
//			  String sql = "SELECT " +
//	                  "    bank, " +
//	                  "    branch, " +
//	                  "    ifsc, " +
//	                  "    CONVERT(varchar, Instrument_Date, 103) AS Instrument_Date, " +
//	                  "    Instrument_No, " +
//	                  "    Instrument_value, " +
//	                  "    Supporting_document, " +
//	                  "    Auto_revolving_amount, " +
//	                  "    CONVERT(varchar, Expiry_date, 103) AS Expiry_date, " +
//	                  "    CONVERT(varchar, Last_shipment_date, 103) AS Last_shipment_date, " +
//	                  "    Payment_type, " +
//	                  "    CONVERT(varchar, PaymentDue_date, 103) AS PaymentDue_date " +
//	                  "FROM " +
//	                  "    jcipayment_arrangement " +
//	                  "WHERE " +
//	                  "    Contract_No = '"+st+"'" +
//	                  "    AND Payment_type <> 'Letter_of_Credit'";
//						
//						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//						 return resultList1;
//		}
		@Override
		public List<Object[]> listdetailsofpaymemt1(String st) {
			 String sql = "SELECT " +
	                 "    bank, " +
	                 "    branch, " +
	                 "    ifsc, " +
	                 "    CONVERT(varchar, Instrument_Date, 103) AS Instrument_Date, " +
	                 "    Instrument_No, " +
	                 "    Instrument_value, " +
	                 "    Supporting_document, " +
	                 "    Auto_revolving_amount, " +
	                 "    CONVERT(varchar, Expiry_date, 103) AS Expiry_date, " +
	                 "    CONVERT(varchar, Last_shipment_date, 103) AS Last_shipment_date, " +
	                 "    Payment_type, " +
	                 "    CONVERT(varchar, PaymentDue_date, 103) AS PaymentDue_date, " +
	                 "    jcicontract.Contract_acceptance_doc " +
	                 "FROM " +
	                 "    jcipayment_arrangement " +
	                 "    INNER JOIN jcicontract ON jcicontract.Contract_no = '"+st+"' " +
	                 "WHERE " +
	                 "    jcipayment_arrangement.Contract_No = '"+st+"'" +
	                 "    AND Payment_type <> 'Letter_of_Credit'";
						
						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
						 return resultList1;
		}
}
