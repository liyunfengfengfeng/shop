package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.changjiang.entity.Role;
import com.changjiang.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	@RequestMapping(value="/getRoles",method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	public List<Role> getRoleByStoreId(@RequestParam("id") String id){
		return service.selectRole(id);
	}
	@RequestMapping(value="/EnabledRoles",method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	public List<Role> getEnabledRoleByStoreId(@RequestParam("storeId") String storeId){
		return service.selectEnabledRole(storeId);
	}
	@RequestMapping(value="/DisabledRoles",method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	public List<Role> getDisabledRoleByStoreId(@RequestParam("storeId") String storeId){
		return service.selectDisabledRole(storeId);
	}
	@RequestMapping(value="/deleteManyRole",method=RequestMethod.POST,
			produces="text/plain;charset=UTF-8")
	public String deleteManyRole(@RequestParam("deleteRoles") Integer[] roles){
		boolean sign=service.deleteManyRole(roles);
		if(sign){
			return "success";
		}else{
			return "defeat";
		}
	}
	@RequestMapping(value="/deleteSingleRole",method=RequestMethod.POST,
			produces="text/plain;charset=UTF-8")
	public String deleteSingleRole(@RequestParam("id") Integer role){
		int sign=service.deleteRoleById(role);
		if(sign==1){
			return "success";
		}else{
			return "defeat";
		}
	}
}
