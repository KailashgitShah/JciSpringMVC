package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.Dispatchdetaildao;

import com.jci.model.dispatchdetailModel;
import com.jci.service_phase2.DispatchService;
@Service
public class DispatchServiceImpl implements DispatchService {
	@Autowired
	Dispatchdetaildao dispatchdetaildao;
	
	@Override
	 public List<dispatchdetailModel> getviewDispatchChallan() {
	       
	        return dispatchdetaildao.getviewDispatchChallan();
	    }
}
