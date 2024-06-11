package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.CreditNoteClaimSettlementDao;
import com.jci.service_phase2.CreditNoteClaimSettlementService;

@Service
public class CreditNoteClaimSettlementServiceImpl implements CreditNoteClaimSettlementService{

	@Autowired
	CreditNoteClaimSettlementDao creditNoteClaimSettlementDao;
	
	@Override
	public List<String> getAllSettlementId() {
		return (List<String>)creditNoteClaimSettlementDao.getAllSettlementId();
	}

	@Override
	public List<Object[]> viewAllChallan(String settlementId) {
		return (List<Object[]>)creditNoteClaimSettlementDao.viewAllChallan(settlementId);
	}

	@Override
	public List<String> getDistinctChallanForSettlemtId(String settlementId) {
		return (List<String>)creditNoteClaimSettlementDao.getDistinctChallanForSettlemtId(settlementId);
	}

	@Override
	public List<Object[]> viewFullChallanDetails(String challan) {
		return (List<Object[]>)creditNoteClaimSettlementDao.viewFullChallanDetails(challan);
	}

}
