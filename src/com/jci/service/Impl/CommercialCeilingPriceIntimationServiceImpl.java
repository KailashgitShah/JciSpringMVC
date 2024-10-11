package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.CommercialCeilingPriceIntimationDao;
import com.jci.model.CommercialCeilingPriceIntimationModel;
import com.jci.service.CommercialCeilingPriceIntimationService;

@Service
public class CommercialCeilingPriceIntimationServiceImpl implements CommercialCeilingPriceIntimationService {

	@Autowired
	CommercialCeilingPriceIntimationDao commercialCeilingPriceDao;

	@Override
	public void create(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		commercialCeilingPriceDao.create(commercialCeilingPriceIntimationModel);

	}

	@Override
	public void update(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		commercialCeilingPriceDao.update(commercialCeilingPriceIntimationModel);

	}

	@Override
	public CommercialCeilingPriceIntimationModel edit(int id) {
		return commercialCeilingPriceDao.edit(id);
	}

	@Override
	public void delete(int id) {
		commercialCeilingPriceDao.delete(id);

	}

	@Override
	public CommercialCeilingPriceIntimationModel find(int id) {
		return commercialCeilingPriceDao.find(id);
	}

	@Override
	public List<CommercialCeilingPriceIntimationModel> getAll() {
		return commercialCeilingPriceDao.getAll();
	}

	@Override
	public boolean submitform(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		// TODO Auto-generated method stub
		return commercialCeilingPriceDao.submitform(commercialCeilingPriceIntimationModel);
	}

}
