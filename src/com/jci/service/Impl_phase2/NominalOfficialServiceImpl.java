package com.jci.service.Impl_phase2;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.NominalOfficialDao;
import com.jci.model.ClaimSettlementReport;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;
import com.jci.service_phase2.NominalOfficialService;

@Service
public class NominalOfficialServiceImpl implements NominalOfficialService {

	@Autowired
	NominalOfficialDao nominalOfficialDao;
	
	@Override
	public void create(Jciclaim_NominationModel nominal ) {
		// TODO Auto-generated method stub
		nominalOfficialDao.create(nominal );
		
	}

	@Override
	public void update(Jciclaim_NominationModel nominal) {
		// TODO Auto-generated method stub
		nominalOfficialDao.update(nominal);
	}

	@Override
	public Jciclaim_NominationModel edit(int id) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.edit(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		nominalOfficialDao.delete(id);
	}

	@Override
	public List<Jciclaim_NominationModel> getAll() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getAll();
	}

	@Override
	public boolean submitform(Jciclaim_NominationModel off) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.submitform(off);
	}

	@Override
	public List<String> millid_MillReceipt() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.millid_MillReceipt();
	}

	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.FetchMillReceiptData(millid);
	}

	@Override
	public List<String> contractno_ContractTable() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.contractno_ContractTable();
	}

	@Override
	public List<String> UsernameOM_jciumt(String role) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.UsernameOM_jciumt(role);
	}

	@Override
	public List<String> UsernameFA_jciumt(String role) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.UsernameFA_jciumt(role);
	}

	@Override
	public List<UserRegistrationModel> getom_official() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getom_official();
	}

	@Override
	public List<UserRegistrationModel> getfa_official() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getfa_official();
	}

	@Override
	public String CountRecord(){
		// TODO Auto-generated method stub
		
		return nominalOfficialDao.CountRecord();
	}

	@Override
	public List<Object> gradecomposition(String contractno) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.gradecomposition(contractno);
	}

	@Override
	public String getEmailForOmo(String omofficial) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getEmailForOmo(omofficial);
	}

	@Override
	public String getEmailForFA(String FAofficial) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getEmailForFA(FAofficial);
	}

	@Override
	public String getEmaiformills(String Mill) {
		return nominalOfficialDao.getEmaiformills( Mill);
	}

	@Override
	public void claimStatusUpdate(String ContractNoForClaimStatusUpdate) {
		this.nominalOfficialDao.claimStatusUpdate(ContractNoForClaimStatusUpdate);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> gethodi() {
		// TODO Auto-generated method stub
		return nominalOfficialDao.gethodi();
	}

	@Override
	public List<Object[]> getchallan(String hodi) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getchallan(hodi);
	}

	@Override
	public List<Object[]> dateofInspection(String dateOfInspection) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.dateofInspection(dateOfInspection);
	}

	@Override
	public String getcontractidentification(String ContractNo) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getcontractidentification(ContractNo);
	}

	@Override
	public String getmillcode(String millname) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getmillcode(millname);
	}

	@Override
	public Jciclaim_NominationModel find(String id) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.find(id);
	}

	@Override
	public void millrecieptstatus(String mr) {
		nominalOfficialDao.millrecieptstatus(mr);
		
	}

	@Override
	public void updatefa(String id, String FAomofficial) {
		nominalOfficialDao.updatefa( id,  FAomofficial);
	
	}

	@Override
	public List<Jciclaim_NominationModel> getAlldetails(String settlement_id,String hodiNo) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getAlldetails(settlement_id,hodiNo);
	}

	@Override
	public List<Jciclaim_NominationModel> findnominationdetails(String id) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.findnominationdetails(id);
	}

	@Override
	public List<ClaimSettlementReport> getNominationReportData(String settlement_id) {
		// TODO Auto-generated method stub
		return nominalOfficialDao.getNominationReportData(settlement_id);
	}

	@Override
	public List<Object[]> getAllHoDiByContract(String Contract) {
		return nominalOfficialDao.getAllHoDiByContract(Contract);
	}

}
