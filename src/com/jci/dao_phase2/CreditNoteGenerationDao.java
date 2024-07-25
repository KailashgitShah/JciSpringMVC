package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;

public interface CreditNoteGenerationDao {
	List<Object[]> getAllVerifiedWeighment();
	void create(CreditNotes creditNotes);
	List<Object[]> getAllCreditNotes();
	void chageStatusTo1(int id);
	int getGstCount(String gstCode);
 
	List<Object[]> findDetails(String table, String contractNoString);
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel);
	List<String> getParamenterDetails(String parameter);
	List<Object[]> showFilterData(String parameter, String basedOn);
	double getAvgJuteValue(String challanNo);
	List<Object[]> getShipmentDetailsByChallanNo(String challanNo);
	List<Object[]> getMillDetailsByCode(String millcode);
	List<Object[]> getDispatchDetails(String challanNo);
	List<Object> getGradeRatio(String challanNo);
	List<Object> getChallanDetails(String challan);
	List<Object[]> getDetailsofSpp_Con_Rec(String bosNo);
	List<Object[]> getStateAndPan(String millcode);
	List<Object[]> getStateAndCodeOfSupplier(String dpc);
	int getTotalCount();
	
	//settlement crn and debit
	List<String> getMillNames();
	List<String> getAllContractNos(String millCode);
	List<Object[]> getFullDetailsOfCrnAndDebit(String contract);
	public List<settlemetCnDnModel> getAll();
	public String CountRecord();
	public List<Object[]>getMillDetails(String millcode);
	List<settlemetCnDnModel> getAlldetails(String cndnIdentificationNumber);
}
