package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jci.model.RoDispatchModel;

public interface RoDispatchService {
  
 public List<String> loadAllDpc();
 public List<String> loadAllDiNo();
 public List<Object> loadFullContractDetails(String diNo);
 public int getCountOfAvailableEntries(String hoNo);
 public void create(RoDispatchModel roDispatchModel);
 public List<RoDispatchModel> getAllRoDi();
public List<String> getCooperative(String regionIdString);
public List<String> getDetails(String hOno);
public List<String> getprevious(String diNo);
public void update(String contractNoString);
public String dpcCheck(String dpc, String hoDIno);
}
