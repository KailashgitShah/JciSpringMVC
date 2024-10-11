package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.DistributionoftallyslipDao;
import com.jci.model.DistributionoftallyslipModel;
import com.jci.service.DistributionoftallyslipService;



@Service
public class DistributionoftallyslipServiceImpl implements DistributionoftallyslipService {

	@Autowired
	DistributionoftallyslipDao distributionoftallyslipDao;

	@Override
	public void create(DistributionoftallyslipModel distributionoftallyslipModel) {
		distributionoftallyslipDao.create(distributionoftallyslipModel);

	}

	@Override
	public void update(DistributionoftallyslipModel distributionoftallyslipModel) {
		distributionoftallyslipDao.update(distributionoftallyslipModel);

	}

	@Override
	public DistributionoftallyslipModel edit(int id) {
		return distributionoftallyslipDao.edit(id);
	}

	@Override
	public void delete(int id) {
		distributionoftallyslipDao.delete(id);

	}

	@Override
	public DistributionoftallyslipModel find(int id) {
		return distributionoftallyslipDao.find(id);
	}

	@Override
	public List<DistributionoftallyslipModel> getAll(String dpcId) {
		return distributionoftallyslipDao.getAll(dpcId);
	}

	@Override
	public boolean submitform(DistributionoftallyslipModel distributionoftallyslipModel) {

				return distributionoftallyslipDao.submitform(distributionoftallyslipModel);
	}

}
