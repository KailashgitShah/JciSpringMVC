package com.jci.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.model.UserActionModel;
@Transactional
@Repository
public interface UserActionDao {

	void create(UserActionModel useraction);

	List<UserActionModel> getAll();
	
	public 	Integer getactionid(String useraction);

	void deleteAction(String actionname);


}
