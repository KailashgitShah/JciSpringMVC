package com.jci.service.Impl_phase2;

import java.util.List;
import com.jci.model.TopSheetDto;
import com.jci.model.boenonlcDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.generationOfCashAgainstDispatchDocumentDao;
import com.jci.service_phase2.generationOfCashAgainstDispatchDocument;

@Service
public class GenerationOfCashAgainstDispatchDocumentServiceImpl implements generationOfCashAgainstDispatchDocument{
	@Autowired
	generationOfCashAgainstDispatchDocumentDao generationOfCashAgainstDispatchDocumentdao;
	
	@Override
	public List<TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String millname, String contractNo) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getTopSheetDatacashAgainstDispatchDocument(millname, contractNo);
	}
	
	@Override
	public List<boenonlcDTO> getBOENONLC(String contractno) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getBOENONLC(contractno);
	}

	@Override
	public List<Object[]> listdetailsofpaymemt1( String st) {
		
		return generationOfCashAgainstDispatchDocumentdao.listdetailsofpaymemt1(st);
	}


	@Override
	public List<Object[]> listdetailsbillofsupplly1(String st) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.listdetailsbillofsupplly1(st);
	}

}
