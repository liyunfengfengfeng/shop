package com.changjiang.controller;



import com.changjiang.entity.Organization;
import com.changjiang.service.OrganizationService;
import com.changjiang.viewModel.FunctionNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by a1996_000 on 2017/6/1.
 * 组织控制层
 */
@Controller
public class OrganizationController {
    @Autowired
    private OrganizationService service;
    /**
     * 查询所有的组织
     * @return
     */
    @RequestMapping(value = "/Organizations",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
    public List<FunctionNode> queryAll(){
    	List<FunctionNode> organization=service.getAllOrganization();
    	return organization;
    }
	@RequestMapping(value="/deleteSingleOrganization",produces="text/plain;charset=UTF-8",
			method=RequestMethod.POST)
	public String deleteSingleOrganization(@RequestParam("organization_id") Integer id){
		int sign=service.deleteOrganizationById(id);
		if(sign==1){
			return "success";
		}else{
			return "defeat";
		}
	}
	@RequestMapping(value="/changeOrganizationName",produces="text/plain;charset=UTF-8",
			method=RequestMethod.POST)
	public String changeOrganizationName(@RequestParam("organization_id") Integer id,@RequestParam("newName") 
	String newName){
		Organization o=new Organization();
		o.setId(id);
		o.setName(newName);
		int sign=service.updateNonEmptyOrganizationById(o);
		if(sign==1){
			return "success";
		}else{
			return "defeat";
		}
	}
	@RequestMapping(value="/addOrganization",produces="text/plain;charset=UTF-8",
			method=RequestMethod.POST)
	public String addOrganization(@RequestParam("name") String name,@RequestParam("pId") Integer pId){
		Integer id=service.insertNonEmptyOrganization(name, pId);
		return id.toString();
	}
}
