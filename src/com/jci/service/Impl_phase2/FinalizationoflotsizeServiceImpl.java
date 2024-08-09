package com.jci.service.Impl_phase2;

import java.util.List;

import org.apache.http.auth.BasicUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jci.dao_phase2.FinalizationoflotsizeDao;
import com.jci.dao_phase2.OperationAndTransportCostDao;

import com.jci.model.FactorHeadList;
import com.jci.model.FinalizationoflotsizegradesModel;
import com.jci.model.FinalizationoflotsizerspModel;
import com.jci.model.OperationAndTransportCostModel;

import com.jci.service_phase2.FinalizationoflotsizeService;
import com.jci.service_phase2.OperationAndTransportCostService;

@Service
public class FinalizationoflotsizeServiceImpl implements FinalizationoflotsizeService {

	@Autowired
	FinalizationoflotsizeDao Finalizationoflotdao;

	@Override
	public void create(FinalizationoflotsizerspModel FinalizationoflotrspModel) {
		// TODO Auto-generated method stub
		Finalizationoflotdao.create(FinalizationoflotrspModel);
	}

	@Override
	public void create1(FinalizationoflotsizegradesModel finalizationoflotsizegradesModel) {
		// TODO Auto-generated method stub
		Finalizationoflotdao.create1(finalizationoflotsizegradesModel);
	}

	@Override
	public List<FinalizationoflotsizerspModel> getAlllist() {
		// TODO Auto-generated method stub
		return Finalizationoflotdao.getAlllist();
	}

	@Override
	public void update(FinalizationoflotsizerspModel FinalizationoflotrspModel) {
		// TODO Auto-generated method stub
		Finalizationoflotdao.update(FinalizationoflotrspModel);
	}

	@Override
	public List<String> Binnoget(String region, String cropyr, String basis) {
		return Finalizationoflotdao.Binnoget(region, cropyr, basis);
	}

	@Override
	public ModelAndView JuteVarietyGradeWiseGet(String cropyr, String basis, String region, String variety) {
		// TODO Auto-generated method stub
		return Finalizationoflotdao.JuteVarietyGradeWiseGet(cropyr, basis, region, variety);
	}

	@Override
	public ModelAndView commercialPriceCalculation(String cropyr, String basis, String region, String binNos) {
		return Finalizationoflotdao.commercialPriceCalculation(cropyr, basis, region, binNos);
	}

	@Override
	public List<Object[]> getFactorList(String region, String cropyear, String basis) {
		return Finalizationoflotdao.getFactorList(region, cropyear, basis);
	}

	@Override
	public List<String> getJuteVerity(char c) {
		return Finalizationoflotdao.getFactorList(c);
	}

	@Override
	public void createModel(FactorHeadList factorList) {
		// TODO Auto-generated method stub
		Finalizationoflotdao.createModel(factorList);

	}

	@Override
	public void creategrade(FinalizationoflotsizegradesModel gradeModel) {
		// TODO Auto-generated method stub
		Finalizationoflotdao.creategrade(gradeModel);

	}

	@Override
	public List<Object[]> getLotData(String basis) {
		// TODO Auto-generated method
		return Finalizationoflotdao.getLotData(basis);

	}

	@Override
	public List<Object[]> getDetails(String id) {
		// TODO Auto-generated method stub

		return Finalizationoflotdao.getDetails(id);
	}

}
