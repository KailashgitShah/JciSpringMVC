package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.DailyPurchaseConfDao;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.InventoryDTO;
import com.jci.service.DailyPurchaseModelConfService;

@Service
public class DailyPurchaseConfModelServiceImpl  implements DailyPurchaseModelConfService{

	@Autowired
	DailyPurchaseConfDao dailyPurchaseConfDao;

	@Override
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel) {
		dailyPurchaseConfDao.create(dailyPurchaseConfModel);

	}

	@Override
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel) {
		dailyPurchaseConfDao.update(dailyPurchaseConfModel);
	}

	@Override
	public DailyPurchaseConfModel edit(int id) {
		return dailyPurchaseConfDao.edit(id);
	}

	@Override
	public void delete(int id) {
		dailyPurchaseConfDao.delete(id);
	}

	@Override
	public DailyPurchaseConfModel find(int id) {
		return dailyPurchaseConfDao.find(id);
	}

	@Override
	public List<DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId) {
		return dailyPurchaseConfDao.getAll(dpcid, regionId, zoneId);
	}

	@Override
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel) {
		return dailyPurchaseConfDao.submitform(dailyPurchaseConfModel);
	}

	@Override
	public List<DailyPurchaseConfModel> dpc2() {
		return dailyPurchaseConfDao.dpc2();
		
	}

	@Override
	public String findGradePriceJuteVariety(String variety, int msp_no, String cropyr, String dpcid) {
		return dailyPurchaseConfDao.findGradePriceJuteVariety(variety,msp_no,cropyr,dpcid);	
		}

	@Override
	public List<Double> firstLeveljute(String cropyr, String basis,String baled) {
		return dailyPurchaseConfDao.firstLeveljute(cropyr, basis, baled);
		
	}
	@Override
	public List<Double> firstLevelbale(String cropyr, String basis,String baled) {
		return dailyPurchaseConfDao.firstLevelbale(cropyr, basis, baled);
		
	}
	@Override
	public List<Object[]> firstLeveljuteRegionwise(String cropyr, String basis) {
		return dailyPurchaseConfDao.firstLeveljuteRegionwise(cropyr, basis);
		
	}
	@Override
	public List<Object[]> firstLevelbaleRegionwise(String cropyr, String basis) {
		return dailyPurchaseConfDao.firstLevelbaleRegionwise(cropyr, basis);
}

	@Override
	public List<Object[]> firstLeveljutedpcwise(String cropyr, String basis, String region) {
		return dailyPurchaseConfDao.firstLeveljutedpcwise(cropyr, basis, region);
	}

	@Override
	public List<InventoryDTO> secondLeveljuteRegionwise(String cropyear, String basis,String baled,String variety) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.secondLeveljuteRegionwise(cropyear, basis, baled, variety);
	}

	@Override
	public List<InventoryDTO> secondLevelbaleRegionwise(String cropyear, String basis) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.secondLevelbaleRegionwise(cropyear, basis);
	}

	@Override
	public List<InventoryDTO> second_level_jute_DPCwise(String cropyear, String basis, String region,String baled,String variety) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.second_level_jute_DPCwise(cropyear, basis, region,baled,variety);

	}

	@Override
	public List<InventoryDTO> second_level_bale_DPCwise(String cropyear, String basis, String region) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.second_level_bale_DPCwise(cropyear, basis, region);
	}

	@Override
	public List<Double> contractInHand_firstlevel(String currCropYear, String basis) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.contractInHand_firstlevel(currCropYear, basis);
	}

	@Override
	public List<InventoryDTO> regionAvailable(String currCropYear, String basis,String baled,String variety) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.regionAvailable(currCropYear, basis,baled,variety);	}

	@Override
	public List<InventoryDTO> dpc_wise_available(String currCropYear, String basis, String region,String baled,String variety) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.dpc_wise_available(currCropYear, basis, region, baled, variety);	}

	@Override
	public List<Double> contractInHand_2ndlevel(String currCropYear, String basis, String status) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.contractInHand_2ndlevel(currCropYear, basis, status);
	}

	@Override
	public List<InventoryDTO> contract3rd_level(String currCropYear, String basis) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.contract3rd_level(currCropYear, basis);	
	}

	@Override
	public List<InventoryDTO> contract4th_level(String currCropYear, String basis, String contractno) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.contract4th_level(currCropYear, basis, contractno);	
	}

	@Override
	public List<String> getCropYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryDTO> juteVarityAvailable(String cropyr, String basis, String baled) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.juteVarityAvailable(cropyr, basis, baled);	
	}

	@Override
	public List<InventoryDTO> juteVarityProcured(String cropyr, String basis, String baled) {
		// TODO Auto-generated method stub
		return dailyPurchaseConfDao.juteVarityProcured(cropyr, basis, baled);	
	}

}
