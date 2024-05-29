package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao.impl_phase2.ConfirmationClaimSettlementDaoImpl;
import com.jci.dao_phase2.ConfirmationClaimSettlementDao;
//import com.jci.dao_phase2.GenrationCashDocumentDao;
//import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.service_phase2.ConfirmationofClaimSettlementService;


@Service
public class ConfirmationClaimSettlementServiceImpl implements ConfirmationofClaimSettlementService {
	
	@Autowired
	ConfirmationClaimSettlementDao confirmationClaimSettlementDao;


	@Override
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel) {
		System.out.println(confirmationClaimSettlementModel);
		confirmationClaimSettlementDao.create(confirmationClaimSettlementModel);
		
	}

	@Override
	public List<ConfirmationClaimSettlementModel> getAll() {
		
		 return confirmationClaimSettlementDao.getAll();
	}

	@Override
	public  List<Object[]> SettlementId() {
		return confirmationClaimSettlementDao.SettlementId();
	}
	
	@Override
	public  List<Object[]> gradecfetchingdata1omposition( String st) {
		return confirmationClaimSettlementDao.gradecfetchingdata1omposition(st);
	}
	

	@Override
	public  List<Object[]> fetchdataofclaim( String st) {
		return confirmationClaimSettlementDao.fetchdataofclaim(st);
	}
	@Override
	public  List<Object[]> fetchdatasttlement( String st) {
		return confirmationClaimSettlementDao.fetchdatasttlement(st);
	}

	@Override
	public List<String> fetchContract(String settlementId) {
		// TODO Auto-generated method stub
		return confirmationClaimSettlementDao.fetchContract(settlementId);
	}

	@Override
	public List<Object[]> fetchChallan(String id) {
		
		return confirmationClaimSettlementDao.fetchChallan(id);
	}

	@Override
	public String fetchPrice(String var, String gr, String dpcId, String cropyear,String Contract) {
		// TODO Auto-generated method stub
		return confirmationClaimSettlementDao.fetchPrice(var,gr,dpcId,cropyear,Contract);
	}

	@Override
	public List<Object[]> getSettlementData(String username) {
		// TODO Auto-generated method stub
		return confirmationClaimSettlementDao.getSettlementData(username);
	}

	@Override
	public void acceptClaim(String challan,String username,String filename) {
		// TODO Auto-generated method stub
		confirmationClaimSettlementDao.acceptClaim(challan,username,filename);
		return;
	}

	@Override
	public void rejectClaim(String challan, String username) {
		// TODO Auto-generated method stub
		confirmationClaimSettlementDao.rejectClaim(challan,username);
		return;
	}
	

}
