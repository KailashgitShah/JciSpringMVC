package com.jci.service_phase2;

import java.util.List;

import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;

public interface CreditNoteGenerationService {
	
	public List<Object[]> getAllVerifiedWeighment();

	public void create(CreditNotes creditNotes);

	public List<Object[]> getAllCreditNotes();

	public void chageStatusTo1(int id);

	public int getCountOfRo(String roId);

	public List<Object[]> getAllMillsOfContracts();

	public List<Object[]> findDetails(String string, String contractNoString);

	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel);

	public List<String> getParamenterDetails(String parameter);

	public List<Object[]> showFilterData(String parameter, String basedOn);

	public double getAvgJuteValue(String challanNo);

	public List<Object[]> getShipmentDetailsByChallanNo(String challanNo);

	public List<Object[]> getMillDetailsByCode(String millcode);

	public List<Object[]> getDispatchDetails(String challanNo);

	public List<Object> getGradeRatio(String challanNo);

	public List<Object> getChallanDetails(String challan);
}
