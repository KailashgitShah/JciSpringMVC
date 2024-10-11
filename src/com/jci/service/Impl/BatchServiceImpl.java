package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BatchDao;
import com.jci.model.BatchIdentificationModel;
import com.jci.model.BinListFromDbDTO;
import com.jci.model.BinPurchaseMappingDTO;
import com.jci.service.BatchIdentificationService;

@Service
public class BatchServiceImpl implements BatchIdentificationService {

	@Autowired
	BatchDao batchdao;

	@Override
	public void create(BatchIdentificationModel batch) {
		batchdao.create(batch);
	}

	@Override
	public void update(BatchIdentificationModel batch) {
		batchdao.update(batch);
	}

	@Override
	public BatchIdentificationModel edit(int id) {
		return batchdao.edit(id);
	}

	@Override
	public void delete(int id) {
		batchdao.delete(id);
	}

	@Override
	public BatchIdentificationModel find(int id) {
		return batchdao.find(id);
	}

	@Override
	public List<BatchIdentificationModel> getAll(String dpcId, String regionId, String zoneId) {
		return batchdao.getAll(dpcId, regionId, zoneId);
	}

	@Override
	public boolean submitform(BatchIdentificationModel batch) {
		return batchdao.submitform(batch);
	}

	@Override
	public List<String> GetDpcNamefromId(int dpcid) {
		// TODO Auto-generated method stub
		return batchdao.GetDpcNamefromId(dpcid);
	}

	@Override
	public List<String> FinddetailsbasedonBinNo(String BinNo) {
		// TODO Auto-generated method stub
		return batchdao.FinddetailsbasedonBinNo(BinNo);
	}

	@Override
	public List<BinPurchaseMappingDTO> GetBinPurchasemappingdetails(String cropyr, String dadatepurchasetepurchase,
			String binNo) {
		// TODO Auto-generated method stub
		return batchdao.GetBinPurchasemappingdetails(cropyr, dadatepurchasetepurchase, binNo);
	}

	@Override
	public List<String> GetTotalofPurchaseParams(String BinNo, String cropYr, String dateOfPurchase) {
		// TODO Auto-generated method stub
		return batchdao.GetTotalofPurchaseParams(BinNo, cropYr, dateOfPurchase);
	}

	@Override
	public List<String> InsertToBinPurchaseMapping(String Date_of_purchase, String Dpc_code, String Basis,
			String Jute_variety, String CropYr, String binNo, String TotalNetQty, String TotalGarsatRate,
			String TotalValue) {
		// TODO Auto-generated method stub
		return batchdao.InsertToBinPurchaseMapping(Date_of_purchase, Dpc_code, Basis, Jute_variety, CropYr, binNo, TotalNetQty, TotalGarsatRate, TotalValue);
	}

	@Override
	public List<String> CalculateGainBasedonBinFromproc(String FinYear, String binNO) {
		// TODO Auto-generated method stub
		return batchdao.CalculateGainBasedonBinFromproc(FinYear, binNO);
	}

	@Override
	public List<String> InsertTotalwithGaininBinTabledb(String FinYear,String binNO,String Fingain,String WeightGain) {
		// TODO Auto-generated method stub
		return batchdao.InsertTotalwithGaininBinTabledb(FinYear, binNO, Fingain, WeightGain);
	}

	@Override
	public List<BinListFromDbDTO> GetBinListFromDb() {
		// TODO Auto-generated method stub
		return batchdao.GetBinListFromDb();
	}

	@Override
	public String ropeAndJutePrice(String juteVariety, String basis , String binnumber) {
		// TODO Auto-generated method stub
		return batchdao.ropeAndJutePrice(juteVariety, basis,binnumber);
	}

}
