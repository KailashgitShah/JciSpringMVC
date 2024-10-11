package com.jci.service;

import java.util.List;

import com.jci.model.DistributionoftallyslipModel;

public interface DistributionoftallyslipService {

	public void create(DistributionoftallyslipModel distributionoftallyslipModel);
	public void update(DistributionoftallyslipModel distributionoftallyslipModel);
	public DistributionoftallyslipModel edit(int id);
	public void delete(int id);
	public DistributionoftallyslipModel find(int id);
	public List <DistributionoftallyslipModel> getAll(String dpcId);
	public boolean submitform(DistributionoftallyslipModel distributionoftallyslipModel);

}
