package com.jci.service.Impl_phase2;

import java.util.List;
import com.jci.model.TopSheetDto;
import com.jci.model.TopsheetDetailsModel;
import com.jci.model.boenonlcDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.generationOfCashAgainstDispatchDocumentDao;
import com.jci.service_phase2.generationOfCashAgainstDispatchDocument;

@Service
public class GenerationOfCashAgainstDispatchDocumentServiceImpl implements generationOfCashAgainstDispatchDocument{
	@Autowired
	generationOfCashAgainstDispatchDocumentDao generationOfCashAgainstDispatchDocumentdao;
	
//	@Override
//	public List<TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String millname, String contractNo) {
//		// TODO Auto-generated method stub
//		return generationOfCashAgainstDispatchDocumentdao.getTopSheetDatacashAgainstDispatchDocument(millname, contractNo);
//	}
//	
	@Override
	public List<TopSheetDto> getTopSheetDatacashAgainstDispatchDocument(String contractNo) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getTopSheetDatacashAgainstDispatchDocument( contractNo);
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
	public List<Object[]> listOfTopSheetDetails() {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.listOfTopSheetDetails();
	}
	
	@Override
	public List<Object> contractonmill1(String millname) {
		
		return generationOfCashAgainstDispatchDocumentdao.contractonmill1(millname);
	}

	@Override
	public void create(TopsheetDetailsModel topSheet ) {
		generationOfCashAgainstDispatchDocumentdao.create(topSheet  );
		
	}

	@Override
	public String topSheetId() {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.topSheetId();
	}

	@Override
	public List<TopsheetDetailsModel> getAlltopsheetdata() {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getAlltopsheetdata();
	}

	@Override
	public List<Object[]> listdetailsbillofsuppllycash(String st) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.listdetailsbillofsuppllycash(st);
	}

	@Override
	public String getNominalWt(String bos) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getNominalWt(bos);
	}

	@Override
	public String listbalanceAmount(String contractno) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.listbalanceAmount(contractno);
	}

	@Override
	public List<TopsheetDetailsModel> getAlldetails(String topSheetIdGenerated) {
		// TODO Auto-generated method stub
		return generationOfCashAgainstDispatchDocumentdao.getAlldetails(topSheetIdGenerated);
	}


}
