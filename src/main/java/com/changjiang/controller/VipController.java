package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.Vip;
import com.changjiang.service.VipService;

/**
 * 
 * 会员控制层
 *
 */
@Controller
public class VipController {
	@Autowired
	private VipService vipService;
	/**
	 * 查询所有的会员信息
	 * @return
	 */
	@RequestMapping(value="/queryallvips")
	public String queryAllVips(){
		//System.out.println("vipService is :" + vipService);
		List<Vip> vips = vipService.queryAllVips();
		if(vips != null && vips.size() > 0){
			for(Vip vip: vips){
				if(vip != null && !"".equals(vip.getName())){
					System.out.println("vip.getName is :" + vip.getName());
				}
			}
		}
		return "index";
	}
	/**
	 * 通过id删除会员信息
	 * @return
	 */
	@RequestMapping(value="/deletevipbyid")
	public String deleteVipById(){
		//System.out.println("vipService is :" + vipService);
		int id = 1;
		Assist assist = new Assist();
		//删除id为1的会员信息
		assist.setRequires(Assist.and_eq("id", "1"));
		//返回删除数据的数目
		int del_num = vipService.deleteVip(assist);
		return "index";
	}
	/**
	 * 添加会员信息
	 * @return
	 */
	@RequestMapping(value="/addvipbyid")
	public String addVip(){
		//System.out.println("vipService is :" + vipService);
		Vip vip = new Vip();
		vip.setName("test3");
		vip.setGender("男");
		vip.setNumber("985254");
		vip.setPassword("test3");
		vip.setPersonalizedSignature("test3");
		//设置该会员所属店面id
		vip.setStoreId(1);
		//开发中从前端传入表单/命令对象
		int add_num = vipService.insertNonEmptyVip(vip);
		
		return "index";
	}
	/**
	 * 更新会员信息
	 * 通过URL限定:绑定{xxx}中的值
	 * @return
	 */
	@RequestMapping(value="/updatevipbyid/{vipid}")
	public String updateVip(@PathVariable("vipid") Integer vipid){
		//System.out.println("vipService is :" + vipService);
		Vip vip = new Vip();
		vip.setId(vipid);
		vip.setName("0000000");
		vip.setGender("男");
		vip.setNumber("000000000");
		vip.setPassword("00000000");
		vip.setPersonalizedSignature("00000000");
		//设置该会员所属店面id
		vip.setStoreId(1);
		//开发中从前端传入表单/命令对象
		int upd_num = vipService.updateVipById(vip);
		
		return "index";
	}
	/**
	 * 通过店面id查找其下所有的会员信息
	 */
	@RequestMapping(value="/queryvipsbystoreid/{storeid}")
	public String queryVipsByStoreId(@PathVariable String storeid){
		List<Vip> vips = vipService.queryVipsByStoreId(storeid);
		//输出会员信息
		if(vips != null && vips.size() > 0){
			System.out.println("vips.size() :" + vips.size());
			for(Vip vip : vips){
				System.out.println("vip.getPersonalizedSignature() :" + vip.getPersonalizedSignature());
			}
		}
		return "index";
	}
}
