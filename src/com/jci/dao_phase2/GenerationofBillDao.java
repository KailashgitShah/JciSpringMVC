package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.GenerationOfBillSupplyModel;


public interface GenerationofBillDao {
	  public String create(GenerationOfBillSupplyModel generationOfBillSupplyModel,String DPC1);
	  public List<GenerationOfBillSupplyModel> getAll();
	  public List<Object[]>ChallanNo( String st);
	  public List<Object[]>ShipmentDetails( String st);
	  public List<Object[]>dispatchChildlist( String st);
	  public  List<Object[]> contarctno(String st);
	  public  boolean millnamefromTCS(String millname);
	  public  boolean challanduplicate(String challanno);
	  public  List<Object[]> contrcatnotomill(String st);
	  public  List<Object[]> GenrationAginstLCs(String st);
	  public  List<Object[]>contarctnoformaster(String st);
	  public  List<Object[]> Dispatchentry(String st);
	  public  List<Object[]> ForDate(String st);
	  public  List<Object[]> Dpcname(String st,String st1);
	  public  List<Object[]> RegionAndCenterName(String st);
	  public  List<Object[]> PANSTATE(String st);
	  public  List<Object[]> DocumentLcsEntry(String st);
	  public  List<Object[]> Supplieradd(String st);
	  public String  billofsupplyno();
	  public String  statecode(String st);
	  public String  statecount(String st);
	  public Double  sumofInvoicevalue(String st);
	  public String billUpdation(String st);
	  public void remark(String cont_no,String  con_No);
	  public GenerationOfBillSupplyModel find(int id);
	public List<Object[]> getDetails(String bOSno);
	public void updateBosFileName(String fileName, String bill_of_Supply);
	
	
	
}
