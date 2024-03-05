package com.jci.service.Impl_phase2;

import java.awt.Container;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.HoDispatchdao;
import com.jci.dao.impl_phase2.HODispatchDaoImpl;
import com.jci.dao_phase2.DispatchHODao;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;
import com.jci.service_phase2.HOInstService;
@Service
public class HODispachServiceImpl implements HOInstService{

                
                @Autowired
                DispatchHODao dispatchHODao;
                
                @Override
                public List<String> getContract() {
                                
                                
                                return dispatchHODao.getContract();
                }

                @Override
                public List<String> getDetails(String contractNo) {
                                return dispatchHODao.getDetails(contractNo);
                }

                @Override
                public List<Object[]> getRoname() {
                                return dispatchHODao.getRoname();
                                
                }

                @Override
                public Object getCount(String reg) {
                                return dispatchHODao.getCount(reg);
                                
                }

                @Override
                public void create(JciDIHoModel hodispatch) {
                                // TODO Auto-generated method stub
                                dispatchHODao.save(hodispatch);
                                return ;
                                
                }
                @Override
                public List<JciDIHoModel> getAll() {
                                return dispatchHODao.getAll();
                }

                @Override
                public void delete(int parseInt) {
                                dispatchHODao.delete(parseInt);
                                
                }

                @Override
                public String getContractNo(String id) {
                                // TODO Auto-generated method stub
                                return dispatchHODao.getContractNo(id);
                }

                @Override
                public String check(String string) {
                                // TODO Auto-generated method stub
                                return dispatchHODao.check(string);
                }
}
