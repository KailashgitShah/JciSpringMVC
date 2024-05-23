package com.jci.dao_phase2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface verifyClaimDao {

	

	List<Object[]> fetchClaimsMill(String settlementId);

	void acceptClaim(Integer id, String username);

	void rejectClaim(Integer id, String username);

}
