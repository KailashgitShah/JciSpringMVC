package com.jci.service_phase2;

import java.util.List;

import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.GenerationOfBillSupplyModel;



public interface GenerationofBillService {
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel);
	 public List<GenerationOfBillSupplyModel>getAll();
	  public List<Object[]>ChallanNo(String st);
	  public List<Object[]>ShipmentDetails(String st);
	  public  List<Object[]>contarctno(String  st);
	  public  List<Object[]>dispatchChildlist(String  st);
	  public  List<Object[]>contrcatnotomill(String  st);
	  public  boolean millnamefromTCS(String millname);
	  public  List<Object[]>contarctnoformaster(String  st);
	  public  List<Object[]>GenrationAginstLCs(String  st);
	  public  List<Object[]>Dispatchentry(String  st);
	  public  List<Object[]>ForDate(String  st);
	  public  List<Object[]>Dpcname(String  st,String st1);
	  public  List<Object[]>RegionAndCenterName(String  st);
	  public  List<Object[]>PANSTATE(String  st);
	  public  List<Object[]>DocumentLcsEntry(String  st);
	  public  List<Object[]>Supplieradd(String  st);
	  public   String billofsupplyno();
	  public   String statecode(String St);
	  public   String statecount(String St);
	  public String billUpdation(String st);
	  public Double sumofInvoicevalue(String st);
	  public void remark(String cont_no,String  con_No);
	  public GenerationOfBillSupplyModel find(int id);
}
