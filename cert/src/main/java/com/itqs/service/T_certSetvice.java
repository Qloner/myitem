package com.itqs.service;

import java.util.List;
import java.util.Map;

import com.itqs.entity.T_cert;

public interface T_certSetvice {
	public List<T_cert> listPage(Map<String, Object> map);
	
	public void addT_cert(T_cert t);
	
	public void delT_cert(int id);
	
	public void delones(String ids);
	
	public void updateT_cert(T_cert t);
	
	public T_cert getOne(int id);
	
	public T_cert getOnes(String ids);
	
	public int getT_certCount(String queryName);
}
