package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;

public interface DispatchHODao {
List<Object[]>getContract();

List<String> getDetails(String contractNo);

List<Object[]> getRoname();

Object getCount(String reg);


void save(JciDIHoModel hodispatch);

List<Object[]> getAll();

void delete(String parseInt);

String getContractNo(String id);

String check(String string);

List<String> juteVariety();

List<Object[]> getJasperData(String diNoString);

}
