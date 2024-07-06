package com.jci.dao_phase2;
import java.util.List;

import com.jci.model.TopSheetDto;
import com.jci.model.TopsheetDetailsModel;
import com.jci.model.boenonlcDTO;
public interface generationOfCashAgainstDispatchDocumentDao {
	
	 public List<TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String millname, String contractNo);
	 public List<boenonlcDTO> getBOENONLC(String contractno);
	 public List<Object[]> listdetailsbillofsuppllycash(String st);
	 public List<Object[]> listdetailsofpaymemt1(String st);
	 public List<Object[]>  listOfTopSheetDetails();
	 public List<Object> contractonmill1(String millname);
	 public void create(TopsheetDetailsModel topSheet );
	  public   String topSheetId();
	  public List<TopsheetDetailsModel> getAlltopsheetdata();
}
