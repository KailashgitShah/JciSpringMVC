package com.jci.dao_phase2;

import java.util.Date;
import java.util.List;

import com.jci.model.BidCreation;

public interface BidCreationDao {
              
              List<BidCreation> getAllbid();
              public void create(BidCreation bidCreation);
              List<Object[]> getLot(String basis);
              List<Object[]> getList();
              List<Object[]> getBidDetails(String decryptId);
              void updatebid(Date d, Integer bid, String bidclosingdate, String bidref);
              List<Object[]> getNonActiveList();
              public void deleteBid(String decryptId);
              void updateFlag();
              void updateNonActiveBid(String basis, Integer pClaim, String bid_Reference, String formattedDate1,
                                           String formattedDate2, String securityDepositAmount, String daystoAccept, String daystodeposit,
                                           String delivery_Period);
              

}
