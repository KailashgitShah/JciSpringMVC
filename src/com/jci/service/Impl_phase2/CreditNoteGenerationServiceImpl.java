package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.CreditNoteGenerationDao;
import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;
import com.jci.service_phase2.CreditNoteGenerationService;


@Service
public class CreditNoteGenerationServiceImpl implements CreditNoteGenerationService {

	@Autowired
	CreditNoteGenerationDao creditNoteGenerationDao;
	
	@Override
	public List<Object[]> getAllVerifiedWeighment() {
		return creditNoteGenerationDao.getAllVerifiedWeighment();
	}

	@Override
	public String create(CreditNotes creditNotes) {
	  return creditNoteGenerationDao.create(creditNotes);
		
	}

	@Override
	public List<Object[]> getAllCreditNotes() {
		return creditNoteGenerationDao.getAllCreditNotes();
	}

	@Override
	public void chageStatusTo1(int id) {
	creditNoteGenerationDao.chageStatusTo1(id);
		
	}

	@Override
	public List<String> getMillNames() {
	return creditNoteGenerationDao.getMillNames();
	}

	@Override
	public List<Object[]> findDetails(String table, String contractNoString) {
		return creditNoteGenerationDao.findDetails(table, contractNoString);
	}

	@Override
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel) {
		 creditNoteGenerationDao.saveSettlementOfCnDn(settlemetCnDnModel) ;
		
	}

	@Override
	public List<String> getParamenterDetails(String parameter) {
		return creditNoteGenerationDao.getParamenterDetails(parameter);
	}

	@Override
	public List<Object[]> showFilterData(String parameter, String basedOn) {
		return creditNoteGenerationDao.showFilterData(parameter,basedOn);
	}

	@Override
	public double getAvgJuteValue(String challanNo) {
		return creditNoteGenerationDao.getAvgJuteValue(challanNo);
	}

	@Override
	public List<Object[]> getShipmentDetailsByChallanNo(String challanNo) {
		return creditNoteGenerationDao.getShipmentDetailsByChallanNo(challanNo);
	}

	@Override
	public List<Object[]> getMillDetailsByCode(String millcode) {
		return creditNoteGenerationDao.getMillDetailsByCode(millcode);
}

	@Override
	public List<Object[]> getDispatchDetails(String challanNo) {
		return creditNoteGenerationDao.getDispatchDetails(challanNo);
	}

	@Override
	public List<Object> getGradeRatio(String challanNo) {
		return creditNoteGenerationDao.getGradeRatio(challanNo);
	}

	@Override
	public List<Object> getChallanDetails(String challan) {
		return creditNoteGenerationDao.getChallanDetails(challan);
	}

	@Override
	public List<Object[]> getDetailsofSpp_Con_Rec(String bosNo) {
		return creditNoteGenerationDao.getDetailsofSpp_Con_Rec(bosNo);
	}

	@Override
	public List<Object[]> getStateAndPan(String millcode) {
		return creditNoteGenerationDao.getStateAndPan(millcode);
	}

	@Override
	public List<Object[]> getStateAndCodeOfSupplier(String dpc) {
		return creditNoteGenerationDao.getStateAndCodeOfSupplier(dpc);
	}

	@Override
	public int getGstCount(String gstCode) {
		return creditNoteGenerationDao.getGstCount(gstCode);
	}

	@Override
	public int getTotalCount() {
		return creditNoteGenerationDao.getTotalCount();
	}

	@Override
	public List<String> getAllContractNos(String mill) {
		return creditNoteGenerationDao.getAllContractNos(mill);
	}

	@Override
	public List<Object[]> getFullDetailsOfCrnAndDebit(String contract) {
		return creditNoteGenerationDao.getFullDetailsOfCrnAndDebit(contract);
	}

	@Override
	public List<settlemetCnDnModel> getAll() {
		// TODO Auto-generated method stub
		return creditNoteGenerationDao.getAll();
	}

	@Override
	public int CountRecord() {
		// TODO Auto-generated method stub
		return creditNoteGenerationDao.CountRecord();
	}

	@Override
	public List<Object[]> getMillDetails(String millcode) {
		// TODO Auto-generated method stub
		return creditNoteGenerationDao.getMillDetails(millcode);
	}

	@Override
	public List<settlemetCnDnModel> getAlldetails(String cndnIdentificationNumber) {
		// TODO Auto-generated method stub
		return creditNoteGenerationDao. getAlldetails(cndnIdentificationNumber);
	}

	@Override
	public String getAccountNo() {
		// TODO Auto-generated method stub
		return creditNoteGenerationDao.getAccountNo();
	}

	@Override
	public boolean duplicatechallan(String challan_no) {
		return creditNoteGenerationDao.duplicatechallan(challan_no);
	}

	@Override
	public List<Object[]> getDataForDocRegeneration(String crnNo) {
	    return creditNoteGenerationDao.getDataForDocRegeneration(crnNo);
	}
	
	

}
