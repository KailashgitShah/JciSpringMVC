package com.jci.service;

import java.util.List;

import com.jci.model.DailyPurchaseConfModel;

public interface DailyPurchaseModelConfService {
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel);
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel);
	public DailyPurchaseConfModel edit(int id);
	public void delete(int id);
	public DailyPurchaseConfModel find(int id);
	public List <DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId);
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel);
	public List<DailyPurchaseConfModel> dpc2();
	public String findGradePriceJuteVariety (String variety, int msp_no, String cropyr,String dpcid );
	public List<Double> firstLeveljute(String cropyr, String basis);
	public List<Integer> firstLevelbale(String cropyr, String basis);
	public List<Object[]> firstLeveljutedpcwise(String cropyr, String basis, String region);
	public List<Object[]> firstLeveljuteRegionwise(String cropyr, String basis);
	public List<Object[]> firstLevelbaleRegionwise(String cropyr, String basis);
	public List<String> getCropYear();
}
