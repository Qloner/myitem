package com.itqs.mapper;

import java.util.List;

import com.itqs.entity.Type_cert;



public interface Type_certyMapper {
	
	public void deleteAll();
	
	public void add(Type_cert tc);
	
	public List<Type_cert> findAll();
	
}
