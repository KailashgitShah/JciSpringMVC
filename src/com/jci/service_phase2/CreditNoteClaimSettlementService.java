package com.jci.service_phase2;

import java.util.List;

import com.jci.model.CreditNoteSettled;

public interface CreditNoteClaimSettlementService {
	List<String> getAllSettlementId();

	List<Object[]> viewAllChallan(String settlementId);

	List<String> getDistinctChallanForSettlemtId(String settlementId);

	List<Object[]> viewFullChallanDetails(String challan);

	List<String> getDistinctChallanOfSettlementId(String settlementId);

	int getGstCount(String gstCode);

	int getTotalCount();

	void updateContractStatus(String contractNo);

	void saveCreditNoteSettled(CreditNoteSettled creditNoteSettled);

	List<Object[]> getAllCreditNoteSettlement();

}
