package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BlockDao;
import com.jci.model.blockModel;
import com.jci.service.blockService;

@Service
public class BlockServiceImpl implements blockService {

	@Autowired
	BlockDao blockdao;

	@Override
	public void create(blockModel block) {
		blockdao.create(block);
	}

	@Override
	public void update(blockModel block) {
		blockdao.update(block);

	}

	@Override
	public blockModel edit(int id) {
		return blockdao.edit(id);
	}

	@Override
	public void delete(int id) {
		blockdao.delete(id);

	}

	@Override
	public blockModel find(int id) {
		return blockdao.find(id);
	}

	@Override
	public List<blockModel> getAll() {
		return blockdao.getAll();
	}


	@Override
	public boolean submitform(blockModel off) {
		return blockdao.submitform(off);
	}

	@Override
	public List<String> getAllFilledlock(int id) {
		return blockdao.getAllFilledlock(id);
	}
}
