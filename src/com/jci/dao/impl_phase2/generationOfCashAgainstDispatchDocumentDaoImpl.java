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

import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.TopSheetDto;
import com.jci.model.TopsheetDetailsModel;
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
		

//		@Override
//		public List<boenonlcDTO> getBOENONLC(String contractno) {
//			String contract = contractno;
//			String sqlQuery = "SELECT "  
//				    + "jcibos_generation.Bill_of_supply_no, "
//				    + "jcibos_generation.BOS_date, "
//				    + "jcibos_generation.Invoice_value, "
//				    + "jcibos_generation.Contract_no, "
//				    + "jcibos_generation.millcode, "
//				    + "jcimilldetailchild.unit_name, "
//				    + "jcimilldetailchild.unit_address1, "
//				    + "jcicontract.Contract_date, "
//				    + "jcicontract.CropYear "
//				    + "FROM jcibos_generation "
//				    + "INNER JOIN jcimilldetailchild ON jcimilldetailchild.client_unit_code = jcibos_generation.millcode "
//				    + "INNER JOIN jcicontract ON jcicontract.Contract_no = jcibos_generation.Contract_no " // Assuming contract is a variable here
//				    + "WHERE jcibos_generation.Contract_no = '"+contract+"'"; 
//			
//			
//			  List<boenonlcDTO> list1 = new ArrayList<>();
//			    List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();
//			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//	          String formattedDate = dateFormat.format(new Date());
//	         
//			    for (Object[] eleObject : contracts) {
//			    	boenonlcDTO boenonlc = new boenonlcDTO();			  
//			    	boenonlc.setBos_no((String) eleObject[0]);
//			    	boenonlc.setBos_date((String) eleObject[1]);
//			    	boenonlc.setInvoiceValue((String) eleObject[2]);
//			    	boenonlc.setContract_no((String) eleObject[3]);
//			    	boenonlc.setMillcode((String) eleObject[4]);
//			    	boenonlc.setMillname((String) eleObject[5]);
//			    	boenonlc.setMilladdress((String) eleObject[6]);
//			    	boenonlc.setContractdate((String) eleObject[7]);
//			    	boenonlc.setCropyear((String) eleObject[8]);
//			    	boenonlc.setTodayDate(formattedDate);
//			    	
//			        list1.add(boenonlc);
//			    }
//
//			    return list1;
//					// TODO Auto-generated method stub
//					
//				}

	@Override
	public List<boenonlcDTO> getBOENONLC(String contractno) {
		String contract = contractno;
		String sqlQuery =   "SELECT " +
		        "    billOfSupplyNo, " +
		        "    bosDate, " +
		        "    invoiceValue, " +
		        "    contract_no, " +
		        "    millcode, " +
		        "    millname, " +
		        "    milladdress, " +
		        "    contract_date, " +
		        "    cropYear, " +
		        "    topSheetCreateDate " +
		        "FROM " +
		        "    jcitopsheet " +
		        "WHERE " +
		        "    topsheet_generated_id = '"+contract+"'";


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
		    	boenonlc.setTodayDate((String) eleObject[9]);
		    	
		        list1.add(boenonlc);
		    }

		    return list1;
				// TODO Auto-generated method stub
				
			}

//		@Override
//		public List<Object[]> listdetailsbillofsupplly1(String st) {
//			 String sql = "SELECT DISTINCT Bill_of_supply_no, BOS_date, Invoice_value, Challan_No " +
//	                 "FROM jcibos_generation " +
//	                 "WHERE Contract_no = '"+st+"' " ;
//
//						
//						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//						 return resultList1;
//		}
//		
//		@Override
//		public List<Object[]> listdetailsbillofsuppllycash(String st) {
//			 String sql = "SELECT DISTINCT Bill_of_supply_no, BOS_date, Invoice_value, Challan_No " +
//	                 "FROM jcibos_generation " +
//	                 "WHERE Contract_no = '"+st+"' " ;
////		    String sql = "SELECT DISTINCT Bill_of_supply_no, BOS_date, Invoice_value, Challan_No " +
////		                 "FROM jcibos_generation g " +
////		                 "WHERE Contract_no = '"+st+"'" +
////		                 "AND NOT EXISTS (" +
////		                 "    SELECT 1 " +
////		                 "    FROM jcitopsheet t " +
////		                 "    WHERE t.billOfSupplyNo = g.Bill_of_supply_no" +
////		                 ");";
//
//		    List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//			 return resultList1;
//		}
		
		@Override
		public List<Object[]> listdetailsbillofsuppllycash(String st) {
			String sql = "SELECT DISTINCT " +
	                 "    g.Bill_of_supply_no, " +
	                 "    g.BOS_date, " +
	                 "    g.Invoice_value, " +
	                 "    g.Challan_No, " +
	                 "    g.millcode, " +
	                 "    m.unit_name, " +
	                 "    m.unit_address1, " +
	                 "    c.Contract_identification_no, " +
	                 "    c.Contract_no, " +
	                 "    c.Contract_date, " +
	                 "    c.CropYear " +
	                 "FROM " +
	                 "    jcibos_generation g " +
	                 "    INNER JOIN jcicontract c ON c.Contract_no = '"+st+"'" +
	                 "    INNER JOIN jcimilldetailchild m ON m.client_unit_code = g.millcode " +
	               
	                 "WHERE " +
	                 "    g.Contract_no = '"+st+"'";

		    List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			 return resultList1;
		}
//		

//		@Override
//		public List<Object[]> listdetailsbillofsupplly1(String st) {
			
					 
//			@Override
//			public List<Object[]> listdetailsbillofsupplly1(String st) {
//			    String sql = "SELECT DISTINCT " +
//		                 "g.Bill_of_supply_no, " +
//		                 "g.BOS_date, " +
//		                 "g.Invoice_value, " +
//		                 "g.Challan_No, " +
//		                 "g.millcode, " +
//		                 "mc.unit_name, " +
//		                 "mc.unit_address1, " +
//		                 "c.Contract_identification_no, " +
//		                 "c.Contract_no, " +
//		                 "c.Contract_date, " +
//		                 "c.CropYear, " +
//		                 "di.DI_no, " +
//		                 "di.DI_Date, " +
//						/*
//						 * "FORMAT(d.Date_of_shipment, 'dd-MM-yyyy') AS Formatted_Date_of_shipment, " +
//						 */
//	                    "dc.No_of_bales * dc.Nominal_wt AS Total_Weight " +
//		                 "FROM jcibos_generation g " +
//		                 "INNER JOIN jcicontract c ON c.Contract_no = '"+st+"' " +
//		                 "INNER JOIN jcimilldetailchild mc ON mc.client_unit_code = g.millcode " +
//		                 "INNER JOIN jciDI_ho di ON di.Contract_No = '"+st+"' " +
//		                 "INNER JOIN jcidispatch_details d ON d.Contract_No = '"+st+"' " +
//		                 "INNER JOIN jcidispatch_details_child dc ON dc.Challan_no = g.Challan_No " +
//		                 "WHERE g.Contract_no = '"+st+"' " +
//		                 "AND NOT EXISTS (" +
//		                 "    SELECT 1 " +
//		                 "    FROM jcitopsheet t " +
//		                 "    WHERE t.billOfSupplyNo = g.Bill_of_supply_no" +
//		                 ")";
////			    		"SELECT DISTINCT " +
////			                 "g.Bill_of_supply_no, " +
////			                 "g.BOS_date, " +
////			                 "g.Invoice_value, " +
////			                 "g.Challan_No, " +
////			                 "g.millcode, " +
////			                 "mc.unit_name, " +
////			                 "mc.unit_address1, " +
////			                 "c.Contract_identification_no, " +
////			                 "c.Contract_no, " +
////			                 "c.Contract_date, " +
////			                 "c.CropYear, " +
////			                 "di.DI_no, " +
////			                 "di.DI_Date, " +
////			                "FORMAT(d.Date_of_shipment, 'dd-MM-yyyy') AS Formatted_Date_of_shipment, " +
////		                    "dc.No_of_bales * dc.Nominal_wt AS Total_Weight " +
////			                 "FROM jcibos_generation g " +
////			                 "INNER JOIN jcicontract c ON c.Contract_no = '"+st+"' " +
////			                 "INNER JOIN jcimilldetailchild mc ON mc.client_unit_code = g.millcode " +
////			                 "INNER JOIN jciDI_ho di ON di.Contract_No = '"+st+"' " +
////			                 "INNER JOIN jcidispatch_details d ON d.Contract_No = '"+st+"' " +
////			                 "INNER JOIN jcidispatch_details_child dc ON dc.Challan_no = g.Challan_No " +
////			                 "WHERE g.Contract_no = '"+st+"' " +
////			                 "AND NOT EXISTS (" +
////			                 "    SELECT 1 " +
////			                 "    FROM jcitopsheet t " +
////			                 "    WHERE t.billOfSupplyNo = g.Bill_of_supply_no" +
////			                 ")";
//
//			    List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//			    return resultList1;
////			}
////
//					     
//
//
//						 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//						 return resultList1;
//		}

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



		@Override
		public List<Object[]> listOfTopSheetDetails() {
			 String sql = "SELECT DISTINCT topsheet_generated_id, topSheetCreateDate, billOfSupplyNo, bosDate " +
	                 "FROM jcitopsheet ";


						
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



		@Override
		public List<TopsheetDetailsModel> getAlltopsheetdata() {
			  String sqlQuery = "SELECT DISTINCT topsheet_generated_id, billOfSupplyNo, topSheetCreateDate, amount from jcitopsheet ORDER BY topSheetCreateDate DESC";
				List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

				List<TopsheetDetailsModel> list = new ArrayList<>();

				for (Object[] eleObject : contracts) {
					TopsheetDetailsModel topSheet = new TopsheetDetailsModel();

					topSheet.setTopsheet_generated_id((String) eleObject[0]);
					topSheet.setBillOfSupplyNo((String) eleObject[1]);
					topSheet.setTopSheetCreateDate((String) eleObject[2]);
					topSheet.setAmount((String) eleObject[3]);
					list.add(topSheet);

				}

				return list;

		}


		
}
