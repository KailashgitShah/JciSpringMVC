package com.jci.service.Impl_phase2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.verifyClaimDao;
import com.jci.service_phase2.verifyClaimService;
@Service
public class verifyClaimServiceImpl implements verifyClaimService {
	@Autowired
	verifyClaimDao verifyClaimDao;
	
	@Override
	public List<Object[]> fetchClaimsMill(String settlementId) {
		// TODO Auto-generated method stub
		return verifyClaimDao.fetchClaimsMill(settlementId);
	}

	@Override
	public void acceptClaim(Integer id, String username) {
		// TODO Auto-generated method stub
		verifyClaimDao.acceptClaim(id,username);
		
	}

	@Override
	public void rejectClaim(Integer id, String username) {
		// TODO Auto-generated method stub
		verifyClaimDao.rejectClaim(id,username);
		
	}

}
