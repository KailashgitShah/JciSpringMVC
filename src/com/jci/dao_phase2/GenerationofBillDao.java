package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.GenerationOfBillSupplyModel;


public interface GenerationofBillDao {
	  public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel);
	  public List<GenerationOfBillSupplyModel> getAll();
	  public List<Object[]>ChallanNo();
	  public  List<Object[]> contarctno(String st);
	  public  List<Object[]>contarctnoformaster(String st);
	  public  List<Object[]> Dispatchentry(String st);
	  public String  billofsupplyno(String st);
	  public String billUpdation(String st);
	  public void remark(String cont_no,String  con_No);
	
	
}
