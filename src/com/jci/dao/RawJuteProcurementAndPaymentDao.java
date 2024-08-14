package com.jci.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;

import com.jci.model.RawJuteProcurementAndPayment;

public interface RawJuteProcurementAndPaymentDao {
	public void create(RawJuteProcurementAndPayment rawJuteProcurementAndPayment);
	public void update(RawJuteProcurementAndPayment rawJuteProcurementAndPayment);
	public RawJuteProcurementAndPayment edit(int id);
	public void delete(int id);
	public RawJuteProcurementAndPayment find(int id);
	public List <RawJuteProcurementAndPayment> getAll();
	public boolean submitform(RawJuteProcurementAndPayment rawJuteProcurementAndPayment);
	public  List<String> farmerNoVarification(String farmerNo);

	public  List<String> allDpcList();

	public List<String> findJuteOnBasis(int msp_no);
	public List<String> findGradeOnJuteVariety (String variety, int msp_no);
	public List<String> findGradePriceJuteVariety (String variety, int msp_no, String cropyr,String dpcid );
	public List<String> getfarmerno(String dpc);
	public List <RawJuteProcurementAndPayment>farmerDetailsList();
	public boolean updateProcurement(String status, int verified,String tallyno, String placeofp);
	public boolean updateProcurementerror(String status, int verified,String tallyno,String error,String region, String placeofp);
	public RawJuteProcurementAndPayment findbyTally(String tallyno, int regionId,String dpcid);
 
	public List<RawJuteProcurementAndPayment> jutelistbystatus(String status,HttpServletRequest request);
 
	public boolean validateTally(String tally, String ro);
	public String getbinno(String binno);
	boolean updateStatus(String tally, String placeofp);
	
	//Search tally by animesh
		public JSONArray searchTally(String tallyno);
		public boolean updateStatusDPCW(String tally, String placeofp);
		public List<RawJuteProcurementAndPayment> delayedenteredtallylist(String status1, String status2,
				HttpServletRequest request);
}
