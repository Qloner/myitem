package com.itqs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itqs.entity.T_cert;
import com.itqs.mapper.T_certMapper;
import com.itqs.service.T_certSetvice;
@Service
@Transactional
public class T_certServiceImpl implements T_certSetvice{
	@Autowired
	private T_certMapper mapper;
	
	@Override
	public List<T_cert> listPage(Map<String, Object> map) {		
		return mapper.listPage(map);
	}

	@Override
	public void addT_cert(T_cert t) {
		mapper.addT_cert(t);
	}

	@Override
	public void delT_cert(int id) {
		mapper.delT_cert(id);
	}

	@Override
	public void updateT_cert(T_cert t) {
		mapper.updateT_cert(t);
	}

	@Override
	public T_cert getOnes(String ids) {
		String[] strs = ids.split(",");
		return mapper.getOnes(strs);
	}

	@Override
	public int getT_certCount(String queryName) {
		return mapper.getT_certCount(queryName);
	}

	@Override
	public T_cert getOne(int id) {
		return mapper.getOne(id);
	}

	@Override
	public void delones(String ids) {
		String[] str = ids.split(",");
		mapper.delones(str);		
	}


}
