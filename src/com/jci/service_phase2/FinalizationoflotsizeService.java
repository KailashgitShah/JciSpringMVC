package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jci.model.FactorHeadList;
import com.jci.model.FinalizationoflotsizegradesModel;
import com.jci.model.FinalizationoflotsizerspModel;

@Service
public interface FinalizationoflotsizeService {
	public void create(FinalizationoflotsizerspModel FinalizationoflotrspModel);

	public void create1(FinalizationoflotsizegradesModel finalizationoflotsizegradesModel);

	public void update(FinalizationoflotsizerspModel FinalizationoflotrspModel);

	List<FinalizationoflotsizerspModel> getAlllist();

	public List<String> Binnoget(String region, String cropyr, String basis);

	public ModelAndView JuteVarietyGradeWiseGet(String cropyr, String basis, String region, String variety);

	public ModelAndView commercialPriceCalculation(String cropyr, String basis, String region, String binNos);

	List<Object[]> getFactorList(String region, String cropyear, String basis);

	public List<String> getJuteVerity(char c);

	public void createModel(FactorHeadList factorList);

	public void creategrade(FinalizationoflotsizegradesModel gradeModel);

	public List<Object[]> getLotData(String string);

	public List<Object[]> getDetails(String id);

}
