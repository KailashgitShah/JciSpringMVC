package com.jci.service_phase2;

import java.util.List;

import com.jci.model.Contractgeneration;




public interface MillAccept {
	
	public List<Contractgeneration> getAll();
	public void updatemillacceptflag(String contractId);
	
	
	
	

}
