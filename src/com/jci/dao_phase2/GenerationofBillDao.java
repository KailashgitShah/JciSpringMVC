package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.GenerationOfBillSupplyModel;


public interface GenerationofBillDao {
	  public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel);
	  public List<GenerationOfBillSupplyModel> getAll();
	  public List<Object[]>ChallanNo( String st);
	  public List<Object[]>ShipmentDetails( String st);
	  public List<Object[]>dispatchChildlist( String st);
	  public  List<Object[]> contarctno(String st);
	  public  boolean millnamefromTCS(String millname);
	  public  List<Object[]> contrcatnotomill(String st);
	  public  List<Object[]> GenrationAginstLCs(String st);
	  public  List<Object[]>contarctnoformaster(String st);
	  public  List<Object[]> Dispatchentry(String st);
	  public  List<Object[]> DocumentLcsEntry(String st);
	  public String  billofsupplyno(String st);
	  public String billUpdation(String st);
	  public void remark(String cont_no,String  con_No);
	  public GenerationOfBillSupplyModel find(int id);
	
	
	
}
