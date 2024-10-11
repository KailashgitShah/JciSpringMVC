package com.jci.service;

import java.util.List;

import com.jci.model.BatchIdentificationModel;
import com.jci.model.BinListFromDbDTO;
import com.jci.model.BinPurchaseMappingDTO;

public interface BatchIdentificationService {
	public void create(BatchIdentificationModel batch);
	public void update(BatchIdentificationModel batch);
	public BatchIdentificationModel edit(int id);
	public void delete(int id);
	public BatchIdentificationModel find(int id);
	public List<BatchIdentificationModel> getAll(String dpcId, String regionId, String zoneId);
	public boolean submitform(BatchIdentificationModel batch);

	public List<String> GetDpcNamefromId(int dpcid);
	
	public List<String> FinddetailsbasedonBinNo(String BinNo);
	List<BinPurchaseMappingDTO> GetBinPurchasemappingdetails(String cropyr, String dadatepurchasetepurchase,
			String binNo);
	
	List<String> GetTotalofPurchaseParams(String BinNo, String cropYr, String dateOfPurchase);
	List<String> InsertToBinPurchaseMapping(String Date_of_purchase, String Dpc_code, String Basis, String Jute_variety,
			String CropYr, String binNo, String TotalNetQty, String TotalGarsatRate, String TotalValue);
	List<String> CalculateGainBasedonBinFromproc(String FinYear, String binNO);
	public  List<String> InsertTotalwithGaininBinTabledb(String FinYear,String binNO,String Fingain,String WeightGain);
	public List<BinListFromDbDTO> GetBinListFromDb();
	public String ropeAndJutePrice(String juteVariety, String basis, String binnumber);
}
