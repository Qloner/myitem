package com.itqs.service;

import java.util.List;

import com.itqs.entity.Cert;
import com.itqs.entity.Type;
import com.itqs.entity.Type_cert;

public interface Type_certService {
	
	public List<Cert> findAll_cert();
	
	public List<Type> findAll_type();
	
	public void deleteAll();
	
	public void add(Type_cert tc);
	
	public List<Type_cert> findAll();
}
