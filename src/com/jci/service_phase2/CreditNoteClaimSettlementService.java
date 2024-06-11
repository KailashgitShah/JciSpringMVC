package com.jci.service_phase2;

import java.util.List;

public interface CreditNoteClaimSettlementService {
	List<String> getAllSettlementId();

	List<Object[]> viewAllChallan(String settlementId);

	List<String> getDistinctChallanForSettlemtId(String settlementId);

	List<Object[]> viewFullChallanDetails(String challan);

}
