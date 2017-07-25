package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.Vip;
import com.changjiang.entity.VipGoups;
import com.changjiang.service.VipGoupsService;
import com.changjiang.service.VipService;

/**
 * 
 * 会员组控制层
 *
 */
@Controller
@RequestMapping("/vipgoups")
public class VipGoupsController {
	@Autowired
	private VipGoupsService vipGoupsService;
	/**
	 * 查询所有的会员组信息
	 * @return
	 */
	@RequestMapping(value="/queryAllVipGoups")
	public String queryAllVipGoups(){
		//System.out.println("vipGoupsService is :" + vipGoupsService);
		List<VipGoups> vipListGoups = vipGoupsService.queryAllVipGoups();
		if(vipListGoups != null && vipListGoups.size() > 0){
			for(VipGoups vipGoups: vipListGoups){
				if(vipGoups != null && !"".equals(vipGoups.getName())){
					System.out.println("vipGoups.getName is :" + vipGoups.getName());
				}
			}
		}
		return "index";
	}
	/**
	 * 通过id删除会员组信息
	 * @return
	 */
	@RequestMapping(value="/deletevipgoupsbyid/{vipgoupid}")
	public String deleteVipById(@PathVariable("vipgoupid") Integer id){
		//删除会员组时先通过vipgoupid找到其下所有的会员 删除他们
		//System.out.println("vipService is :" + vipService);
		Assist assist = new Assist();
		//删除通过URL限定:绑定{xxx}中的值的会员组信息
		assist.setRequires(Assist.and_eq("id", id.toString().trim()));
		//返回删除数据的数目
		int del_num = vipGoupsService.deleteVipGoups(assist);
		return "index";
	}
	/**
	 * 添加会员组信息
	 * @return
	 */
	@RequestMapping(value="/addvipgoupsbyid")
	public String addVipGoups(){
		//System.out.println("vipService is :" + vipService);
		VipGoups vipGoups = new VipGoups();
		vipGoups.setDbDesc("testdesc");
		vipGoups.setDiscount(200);
		vipGoups.setNumber("123456");
		vipGoups.setName("test");
		vipGoups.setState("0");
		vipGoups.setStoreNumber(0);
		//开发中从前端传入表单/命令对象
		int add_num = vipGoupsService.insertNonEmptyVipGoups(vipGoups);
		
		return "index";
	}
	/**
	 * 更新会员组信息
	 * @return
	 */
	@RequestMapping(value="/updatevipgoupsbyid")
	public String updateVipGoups(){
		//System.out.println("vipService is :" + vipService);
		VipGoups vipGoups = new VipGoups();
		vipGoups.setDbDesc("testdesc");
		vipGoups.setDiscount(200);
		
		vipGoups.setNumber("123456");
		vipGoups.setName("test");
		vipGoups.setState("0");
		vipGoups.setStoreNumber(0);
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("id", "1"));
		//开发中从前端传入表单/命令对象
		int add_num = vipGoupsService.updateNonEmptyVipGoups(vipGoups, assist);
		
		return "index";
	}
	/**
	 * 通过会员组id查询其下所有的会员信息
	 */
	@RequestMapping("/queryvipsbyvipgoups/{vipgoupsid}")
	public String queryVipsByVipGoups(@PathVariable String vipgoupsid){
		//System.out.println("绑定入参的id是  :" + vipgoupsid);
		List<Vip> vips = vipGoupsService.queryAllVipsByVipGoupid(vipgoupsid);
		//System.out.println("vip.size() is :" + vips.size());
		if(vips != null && vips.size() > 0){
			for(Vip vip : vips){
				System.out.println("vip.getName() :" + vip.getName());
			}
		}
		return "index";
	}
}
