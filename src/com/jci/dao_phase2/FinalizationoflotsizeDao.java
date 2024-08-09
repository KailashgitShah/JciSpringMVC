package com.jci.dao_phase2;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.jci.model.FactorHeadList;
import com.jci.model.FinalizationoflotsizegradesModel;
import com.jci.model.FinalizationoflotsizerspModel;

public interface FinalizationoflotsizeDao {

    void create(FinalizationoflotsizerspModel FinalizationoflotrspModel );
    void create1(FinalizationoflotsizegradesModel finalizationoflotsizegradesModel );
    void update(FinalizationoflotsizerspModel FinalizationoflotrspModel);
    public List<String> Binnoget(String region , String cropyr , String basis);
    List<FinalizationoflotsizerspModel> getAlllist();
    public ModelAndView JuteVarietyGradeWiseGet(String cropyr , String basis , String region, String variety);
	ModelAndView commercialPriceCalculation(String cropyr, String basis, String region, String binNos);
	List<Object[]> getFactorList(String region, String cropyear, String basis);
	List<String> getFactorList(char c);
    void createModel(FactorHeadList factorList);
    void creategrade(FinalizationoflotsizegradesModel gradeModel);
    List<Object[]> getLotData(String basis);
    List<Object[]> getDetails(String id);

}
