package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.Contractgeneration;

public interface millAcceptDao {
	public List<Contractgeneration> getAll();
	public void updatemillacceptflag(String contractId );
	
	

}
