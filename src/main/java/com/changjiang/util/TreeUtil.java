package com.changjiang.util;

import java.util.ArrayList;
import java.util.List;

import com.changjiang.common.Assist;
import com.changjiang.dao.OrganizationDao;
import com.changjiang.entity.Organization;
import com.changjiang.viewModel.FunctionNode;

public class TreeUtil {
	public static List<FunctionNode> getOrganizationTree(List<Organization> organizations,OrganizationDao dao){
		List<FunctionNode> result=new ArrayList<>();
		List<Organization> os=new ArrayList<>();
		for(Organization o:organizations){
			os=dao.selectOrganization(new Assist(Assist.and_eq("upper_level_id",o.getId().toString())));
			if(os==null||os.size()==0){
				FunctionNode node=new FunctionNode();
				node.setId(o.getId());
				node.setName(o.getName());
				node.setpId(o.getUpperLevelId().toString());
				result.add(node);
			}else{
				result.addAll(getOrganizationTree(os,dao));
			}
		}
		return result;
	}
}
