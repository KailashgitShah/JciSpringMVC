package com.jci.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RawJuteProcurementAndPaymentDao;
import com.jci.model.RawJuteProcurementAndPayment;
import com.jci.service.RawJuteProcurementAndPaymentService;

@Service
public class RawJuteProcurementAndPaymentServiceImpl implements RawJuteProcurementAndPaymentService{

	@Autowired
	RawJuteProcurementAndPaymentDao rawJuteProcurementAndPaymentDao;

	@Override
	public void create(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		rawJuteProcurementAndPaymentDao.create(rawJuteProcurementAndPayment);

	}

	@Override
	public void update(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		rawJuteProcurementAndPaymentDao.update(rawJuteProcurementAndPayment);

	}

	@Override
	public RawJuteProcurementAndPayment edit(int id) {
		return rawJuteProcurementAndPaymentDao.edit(id);
	}

	@Override
	public void delete(int id) {
		rawJuteProcurementAndPaymentDao.delete(id);
	}

	@Override
	public RawJuteProcurementAndPayment find(int id) {
		return rawJuteProcurementAndPaymentDao.find(id);
	}

	@Override
	public List<RawJuteProcurementAndPayment> getAll() {
		return rawJuteProcurementAndPaymentDao.getAll();
	}

	@Override
	public boolean submitform(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		return rawJuteProcurementAndPaymentDao.submitform(rawJuteProcurementAndPayment);
	}

	@Override
	public  List<String> farmerNoVarification(String farmerNo) {
		return  rawJuteProcurementAndPaymentDao.farmerNoVarification(farmerNo);

	}

	@Override
	public List<String> allDpcList() {
		return rawJuteProcurementAndPaymentDao.allDpcList();
	}


	@Override
	public List<String> findJuteOnBasis(int msp_no) {
		return  rawJuteProcurementAndPaymentDao.findJuteOnBasis(msp_no);
	}

	@Override
	public List<String> findGradeOnJuteVariety(String variety, int basis_no) {
		return  rawJuteProcurementAndPaymentDao.findGradeOnJuteVariety(variety, basis_no);
	}

	@Override
	public List<String> findGradePriceJuteVariety(String variety, int basis_no ,String cropyr, String dpcid) {
		return  rawJuteProcurementAndPaymentDao.findGradePriceJuteVariety(variety, basis_no, cropyr,dpcid);
	}

	@Override
	public List<String> getfarmerno(String dpc) {

		return rawJuteProcurementAndPaymentDao.getfarmerno(dpc);
	}

	@Override
	public List<RawJuteProcurementAndPayment> farmerDetailsList() {

		return rawJuteProcurementAndPaymentDao.farmerDetailsList();
	}

	@Override
	public boolean updateProcurement(String status, int verified, String tallyno,String placeofp) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.updateProcurement(status, verified,tallyno,placeofp);
	}

	@Override
	public RawJuteProcurementAndPayment findbyTally(String tallyno, int regionId,String dpcid) {

		return rawJuteProcurementAndPaymentDao.findbyTally(tallyno, regionId, dpcid);
	}

	@Override
	public boolean updateProcurementerror(String status, int verified, String tallyno, String error,String region,String placeofp) {

		return rawJuteProcurementAndPaymentDao.updateProcurementerror(status, verified,tallyno, error,region,placeofp);
	}

	@Override 
	public List<RawJuteProcurementAndPayment> jutelistbystatus(String status, HttpServletRequest request) {
  
		return rawJuteProcurementAndPaymentDao.jutelistbystatus(status, request);
 
	}

	@Override
	public boolean validateTally(String tally, String ro) {
		
		return rawJuteProcurementAndPaymentDao.validateTally(tally, ro);
	}

	
	@Override
	public String getbinno(String binno) {
		return rawJuteProcurementAndPaymentDao.getbinno(binno);
		
	}

	@Override
	public boolean updateStatus(String tally,String placeofp) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.updateStatus(tally,placeofp);
	}

	@Override
	public JSONArray searchTally(String tallyno) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.searchTally(tallyno);
	}

	@Override
	public boolean updateStatusDPCW(String tally,String placeofp) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.updateStatusDPCW(tally,placeofp);
	}

	@Override
	public List<RawJuteProcurementAndPayment> delayedenteredtallylist(String status1, String status2,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.delayedenteredtallylist(status1,status2, request);
	}





}
