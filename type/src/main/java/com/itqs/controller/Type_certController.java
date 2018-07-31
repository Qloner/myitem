package com.itqs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itqs.entity.Cert;
import com.itqs.entity.Type;
import com.itqs.entity.Type_cert;
import com.itqs.service.Type_certService;


@Controller
@RequestMapping("/type")
public class Type_certController {
	@Autowired
	private Type_certService service_t;
	
	@RequestMapping("/mymain")
	public String mymain(HttpServletRequest request){
		List<Cert> list_cert = service_t.findAll_cert();
		List<Type> list_type = service_t.findAll_type();
		request.setAttribute("list_cert", list_cert);
		request.setAttribute("list_type", list_type);
		List<Type_cert> list = service_t.findAll();
		String str_a="";
		for(Type_cert t:list){
			str_a+=t.getCertid()+"a"+t.getAccttype()+",";
		}
		System.out.println(str_a);
		request.setAttribute("str_a", str_a);		
		return "type";		
	}
	
	@RequestMapping(value="/adu")
	public String adu(String ids,HttpServletRequest request){
		service_t.deleteAll();
		String[] str = ids.split("b");
		//List<String> list_a=new ArrayList<String>();
		String str_a="";
		for (String a:str) {
			String[] id = a.split("a");
			
			Type_cert tc = new Type_cert();
			
			int id_c = Integer.parseInt(id[0]);  
			tc.setCertid(id_c);
			int id_t = Integer.parseInt(id[1]);  
			tc.setAccttype(id_t);			
			service_t.add(tc);	
			
			//list_a.add(a);	
			str_a +=a+",";
		}
		request.setAttribute("str_a", str_a);
		List<Cert> list_cert = service_t.findAll_cert();
		List<Type> list_type = service_t.findAll_type();
		request.setAttribute("list_cert", list_cert);
		request.setAttribute("list_type", list_type);
					
		return "type";
	}
	
	@RequestMapping("/mytype")
	public String mytype(){
		return "redirect:/type/mymain";		
	}
}
