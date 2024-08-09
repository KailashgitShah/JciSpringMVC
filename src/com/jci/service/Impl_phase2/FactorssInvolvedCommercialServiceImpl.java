

package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.FactorssInvolvedCommercialDao;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.service_phase2.FactorssInvolvedCommercialService;

@Service
public class FactorssInvolvedCommercialServiceImpl implements FactorssInvolvedCommercialService {

	@Autowired
	FactorssInvolvedCommercialDao factorsinvolvolveddao;
	
	@Override
	public void create(List<FactorssInvolvedCommercial> allList) {
		// TODO Auto-generated method stub
		this.factorsinvolvolveddao.create(allList);
	}

	@Override
	public List<FactorssInvolvedCommercial> getAll() {
		return factorsinvolvolveddao.getAll();
	
	}

}
