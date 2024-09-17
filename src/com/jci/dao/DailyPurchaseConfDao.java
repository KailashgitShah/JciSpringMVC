package com.jci.dao;

import java.util.List;

import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.InventoryDTO;

public interface DailyPurchaseConfDao {

	public void create(DailyPurchaseConfModel dailyPurchaseConfModel);
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel);
	public DailyPurchaseConfModel edit(int id);
	public void delete(int id);
	public DailyPurchaseConfModel find(int id);
	public List <DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId);
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel);
	public  List<DailyPurchaseConfModel> dpc2();
	public String findGradePriceJuteVariety (String variety, int msp_no, String cropyr,String dpcid );
	public List<Double> firstLeveljute(String cropyr, String basis, String baled);
	public List<Double> firstLevelbale(String cropyr, String basis, String baled);
	public List<Object[]> firstLeveljutedpcwise(String cropyr, String basis, String region);
	public List<Object[]> firstLeveljuteRegionwise(String cropyr, String basis);
	public List<Object[]> firstLevelbaleRegionwise(String cropyr, String basis);
	public List<InventoryDTO> secondLeveljuteRegionwise(String cropyear, String basis, String baled);
	public List<InventoryDTO> secondLevelbaleRegionwise(String cropyear, String basis);
	public List<InventoryDTO> second_level_jute_DPCwise(String cropyear, String basis, String region, String baled);
	public List<InventoryDTO> second_level_bale_DPCwise(String cropyear, String basis, String region);
	public List<Double> contractInHand_firstlevel(String currCropYear, String basis);
	public List<InventoryDTO> regionAvailable(String currCropYear, String basis, String baled);
	public List<InventoryDTO> dpc_wise_available(String currCropYear, String basis, String region, String baled);
	public List<Double> contractInHand_2ndlevel(String currCropYear, String basis, String status);
	public List<InventoryDTO> contract3rd_level(String currCropYear, String basis);
	public List<InventoryDTO> contract4th_level(String currCropYear, String basis, String contractno);
}
