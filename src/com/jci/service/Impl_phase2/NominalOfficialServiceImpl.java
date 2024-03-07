package com.jci.service.Impl_phase2;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.NominalOfficialDao;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;
import com.jci.service_phase2.NominalOfficialService;

@Service
public class NominalOfficialServiceImpl implements NominalOfficialService {

	@Autowired
	NominalOfficialDao nominalOfficialDao;
	
	@Override
	public void create(Jciclaim_NominationModel nominal) {
		// TODO Auto-generated method stub
		nominalOfficialDao.create(nominal);
		
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
	public int CountRecord(){
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

}
