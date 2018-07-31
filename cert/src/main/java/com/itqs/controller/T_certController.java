package com.itqs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itqs.entity.T_cert;
import com.itqs.service.T_certSetvice;
import com.itqs.utils.PageUtils;
import com.sun.org.apache.regexp.internal.RE;

@Controller
@RequestMapping("/T_cert")
public class T_certController {
	@Autowired
	private T_certSetvice service_cert;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
		@RequestParam(value="queryName", required=false,defaultValue="") String queryName,
		HttpServletRequest request)
	{
		int pageSize=4;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("value1",queryName );
		map.put("m", (currentPage-1)*pageSize);
		map.put("n", pageSize);
		
		List<T_cert> source = service_cert.listPage(map);
		int dataCount = service_cert.getT_certCount(queryName);
		
		PageUtils.page(request, currentPage, pageSize, source, dataCount);			
		return "list";				
	}
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "add";
	}
	
	@RequestMapping(value="/add" )
	public String add(T_cert t){
		System.out.println(t.getName());
		service_cert.addT_cert(t);
		return "redirect:/T_cert/list";
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable("id") int id){
		service_cert.delT_cert(id);
		return "redirect:/T_cert/list";
	}
	
	@RequestMapping("/dels/{ids}")
	public String del(@PathVariable("ids") String ids){
		service_cert.delones(ids);
		return "redirect:/T_cert/list";
	}
	

	@RequestMapping("/toupdate/{id}")
	public String update(@PathVariable("id") int id,HttpServletRequest request){
		T_cert cert = service_cert.getOne(id);
		request.setAttribute("cert", cert);
		return "update";
	}
	
	@RequestMapping(value="/update" )
	public String update(T_cert t){
		service_cert.updateT_cert(t);
		return "redirect:/T_cert/list";
	}
	
}
