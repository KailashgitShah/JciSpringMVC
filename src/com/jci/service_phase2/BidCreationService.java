package com.jci.service_phase2;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.BidCreation;

@Service
public interface BidCreationService {
              List<BidCreation> getAllbid() ;
              public void create(BidCreation bid);
              List<Object[]> getLot(String basis);
              List<Object[]> getList();
              List<Object[]> getBidDetails(String decryptId);
              void update(Date d, Integer bid, String bidclosingdate, String bidref);
              List<Object[]> getNonActiveList();
              public void deleteBid(String decryptId);
              void updateflag();
              void updateNonActiveBid(String basis, Integer pClaim, String bid_Reference, String formattedDate1,
                                           String formattedDate2, String securityDepositAmount, String daystoAccept, String daystodeposit,
                                           String delivery_Period);
              
              
              }
