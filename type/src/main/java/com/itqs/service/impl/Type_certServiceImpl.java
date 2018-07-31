package com.itqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itqs.entity.Cert;
import com.itqs.entity.Type;
import com.itqs.entity.Type_cert;
import com.itqs.mapper.CertMapper;
import com.itqs.mapper.TypeMapper;
import com.itqs.mapper.Type_certyMapper;
import com.itqs.service.Type_certService;


@Service
@Transactional
public class Type_certServiceImpl implements Type_certService{
	@Autowired
	private CertMapper mapper_c;
	@Autowired
	private TypeMapper mapper_t;
	@Autowired
	private Type_certyMapper mapper_ct;
	
		
	@Override
	public List<Cert> findAll_cert() {
		return mapper_c.findAll_cert();
	}

	@Override
	public List<Type> findAll_type() {
		return mapper_t.findAll_type();
	}

	@Override
	public void deleteAll() {
		mapper_ct.deleteAll();		
	}

	@Override
	public void add(Type_cert tc) {
		mapper_ct.add(tc);		
	}

	@Override
	public List<Type_cert> findAll() {		
		return mapper_ct.findAll();
	}
		
}
