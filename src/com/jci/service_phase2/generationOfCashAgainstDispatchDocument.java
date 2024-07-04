package com.jci.service_phase2;

import java.util.List;

import com.jci.model.TopSheetDto;
import com.jci.model.boenonlcDTO;

public interface generationOfCashAgainstDispatchDocument{
	 public List <TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String millname ,String contractNo);
	 public List <boenonlcDTO> getBOENONLC(String contractno);
	 public List<Object[]> listdetailsbillofsupplly1(String st);
	 public List<Object[]> listdetailsofpaymemt1(String st);
	
}
