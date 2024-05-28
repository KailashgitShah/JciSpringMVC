package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BalePrepareDao;
import com.jci.model.BalePreparation;
import com.jci.model.PurchaseCenterModel;
import com.jci.service.BalePrepareService;

@Service
public class BalePrepareServiceImpl implements BalePrepareService	{

	@Autowired
	BalePrepareDao balePrepare;

	@Override
	public void create(BalePreparation BalePreparation) {
		balePrepare.create(BalePreparation);
	}

	@Override
	public void update(BalePreparation BalePreparation) {
		balePrepare.update(BalePreparation);
	}

	@Override
	public BalePreparation edit(int id) {
		return balePrepare.edit(id);
	}

	@Override
	public void delete(int id) {
		balePrepare.delete(id);
	}

	@Override
	public BalePreparation find(int id) {
		return balePrepare.find(id);
	}

	@Override
	public List<BalePreparation> getAll(String place_of_packing, String regionId, String zoneId) {
		return balePrepare.getAll(place_of_packing, regionId, zoneId);
	}

	@Override
	public boolean submitform(BalePreparation BalePreparation) {
		return balePrepare.submitform(BalePreparation);
	}

	public List<BalePreparation> getbyFilter(String dpc,String fromdate,  String todate, String cropyear, String basis,String jutevariety){
		return balePrepare.getbyFilter(dpc,fromdate, todate,cropyear,basis, jutevariety);
	}

	@Override
	public String getcropYear(String cropyear) {
		// TODO Auto-generated method stub
		return balePrepare.getcropYear(cropyear);
	}

	@Override
	public String getjuteVariety(String juteVariety) {
		// TODO Auto-generated method stub
		return balePrepare.getjuteVariety(juteVariety);
	}

	@Override
	public String getbasis(String basis) {
		// TODO Auto-generated method stub
		return balePrepare.getbasis(basis);
	}

}
