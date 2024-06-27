package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CreditNoteSettled;

public interface CreditNoteClaimSettlementDao {
	List<String> getAllSettlementId();

	List<Object[]> viewAllChallan(String settlementId);

	List<String> getDistinctChallanForSettlemtId(String settlementId);

	List<Object[]> viewFullChallanDetails(String challan);

	List<String> getDistinctChallanOfSettlementId(String settlementId);

	int getGstCount(String gstGstCode);
	int getTotalCount();

	void updateContractStatus(String contractNo);

	void saveCreditNoteSettled(CreditNoteSettled creditNoteSettled);

	List<Object[]> getAllCreditNoteSettlement();

}
