package com.jci.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.UserActionModel;
@Service
public interface UserActionService {

	void create(UserActionModel useraction);

	List<UserActionModel> getAll();
	
	public 	Integer getactionid(String useraction);

	void deleteAction(String actionname);


}
