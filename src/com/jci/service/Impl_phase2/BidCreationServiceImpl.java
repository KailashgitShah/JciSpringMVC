package com.jci.service.Impl_phase2;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.BidCreationDao;
import com.jci.model.BidCreation;
import com.jci.service_phase2.BidCreationService;

@Service
public class BidCreationServiceImpl implements BidCreationService {
              
              @Autowired
              BidCreationDao bidcreationDao;

              @Override
              public List<BidCreation> getAllbid() {
                             // TODO Auto-generated method stub
                             return bidcreationDao.getAllbid() ;
              }
              
              @Override
              public void create(BidCreation bid) {       
                             bidcreationDao.create(bid);
                             
              }

              @Override
              public List<Object[]> getLot(String basis) {
                             // TODO Auto-generated method stub
                             return bidcreationDao.getLot(basis);
              }

              @Override
              public List<Object[]> getList() {
                             // TODO Auto-generated method stub
                             return bidcreationDao.getList();
              }

              @Override
              public List<Object[]> getBidDetails(String decryptId) {
                             // TODO Auto-generated method stub
                             return bidcreationDao.getBidDetails(decryptId);
              }

              @Override
              public void update(Date d, Integer bid, String bidclosingdate, String bidref) {
                             // TODO Auto-generated method stub
                             bidcreationDao.updatebid(d,bid,bidclosingdate,bidref);
                             return;
              }

              @Override
              public List<Object[]> getNonActiveList() {
                             // TODO Auto-generated method stub
                             return bidcreationDao.getNonActiveList();
              }

              @Override
public void deleteBid(String decryptId) {
                             // TODO Auto-generated method stub
                             bidcreationDao.deleteBid(decryptId);
                             return;
              }

              @Override
              public void updateflag() {
                             // TODO Auto-generated method stub
                             bidcreationDao.updateFlag();
                             return;
                             
              }

              @Override
              public void updateNonActiveBid(String basis, Integer pClaim, String bid_Reference, String formattedDate1,
                                           String formattedDate2, String securityDepositAmount, String daystoAccept, String daystodeposit,
                                           String delivery_Period) {
                             bidcreationDao.updateNonActiveBid(basis,pClaim,bid_Reference,formattedDate1,formattedDate2,securityDepositAmount,daystoAccept,daystodeposit,delivery_Period);
                             return;
                             // TODO Auto-generated method stub
                             
              }

              

}
