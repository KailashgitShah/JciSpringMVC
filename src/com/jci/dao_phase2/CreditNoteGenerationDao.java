package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;

public interface CreditNoteGenerationDao {
	List<Object[]> getAllVerifiedWeighment();
	void create(CreditNotes creditNotes);
	List<CreditNotes> getAllCreditNotes();
	void chageStatusTo1(int id);
	int getCountRO(String ro);
	List<Object[]> getAllMillsOfContracts();
	List<Object[]> findDetails(String table, String contractNoString);
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel);
	List<String> getParamenterDetails(String parameter);
	List<Object[]> showFilterData(String parameter, String basedOn);
	double getAvgJuteValue(String challanNo);
	List<Object[]> getShipmentDetailsByChallanNo(String challanNo);
	List<Object[]> getMillDetailsByCode(String millcode);
	List<Object[]> getDispatchDetails(String challanNo);
}
