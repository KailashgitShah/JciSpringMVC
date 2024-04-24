package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CreationofBidOfferingModel;
import com.jci.model.OperationAndTransportCostModel;

public interface CreationofBidOfferingDao {

	void create(CreationofBidOfferingModel creationofbidModel);
	
	void update(CreationofBidOfferingModel creationofbidModel);

	List<CreationofBidOfferingModel> getAlllist();
	
	

}
