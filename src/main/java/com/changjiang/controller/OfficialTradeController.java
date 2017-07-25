package com.changjiang.controller;

import com.changjiang.common.Assist;

/**
 * Created by a1996_000 on 2017/6/2.
 */

import com.changjiang.entity.OfficialTrade;
import com.changjiang.service.OfficialTradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 官方商品控制层
 */
@Controller
@RequestMapping("/officialtrade")
public class OfficialTradeController {
    @Autowired
    private OfficialTradeService officialTradeService;
    /**
     * 查询所有的官方商品信息
     * @return
     */
    @RequestMapping(value = "/queryAll")
    public String queryAll(){
    	Assist assist = new Assist();
        List<OfficialTrade> officialTrades = officialTradeService.selectOfficialTrade(assist);
        System.out.println("officialTrades.size() :" + officialTrades.size());
        if(officialTrades != null && officialTrades.size() > 0){
            for (OfficialTrade officialTrade:officialTrades){
                System.out.println(officialTrade.getOfficialName());
            }
        }
        return "index1";
    }
    /**
     * 增加官方商品信息
     * 开发时可传入表单命令对象
     */
    @RequestMapping(value="/addofficialtrade")
    public String addOfficialTrade(){
    	OfficialTrade officialTrade = new OfficialTrade();
    	officialTrade.setAlias("testalias");
    	officialTrade.setDbDesc("testdesc");
    	officialTrade.setFormerName("testformaname");
    	officialTrade.setIcon("testicon");
    	officialTrade.setNumber("66666");
    	officialTrade.setOfficialName("testofficialname");
    	officialTrade.setOfficialType(1);
    	int add_num = officialTradeService.insertNonEmptyOfficialTrade(officialTrade);
    	System.out.println("添加了" + add_num + "条数据");
    	return "index";
    }
    /**
     * 删除官方商品信息
     * 传入官方商品id
     */
    @RequestMapping(value="/deleteofficialtrade/{officialtradeid}")
    public String deleteOfficialTrade(@PathVariable Integer officialtradeid){
    	int del_num = officialTradeService.deleteOfficialTradeById(officialtradeid);
    	System.out.println("删除了" + del_num + "条数据");
    	return "index";
    }
    /**
     * 更新官方商品信息
     * 传入官方商品id
     * 开发时传入表单对象
     */
    @RequestMapping(value="/updateofficialtrade/{officialtradeid}")
    public String updateOfficialTrade(@PathVariable Integer officialtradeid){
    	//模拟表单对象
    	OfficialTrade officialTrade = new OfficialTrade();
    	officialTrade.setAlias("testalias");
    	officialTrade.setDbDesc("testdesc");
    	officialTrade.setFormerName("testformaname");
    	officialTrade.setIcon("testicon");
    	officialTrade.setNumber("66666");
    	officialTrade.setOfficialName("testofficialname");
    	officialTrade.setOfficialType(1);
    	Assist assist = new Assist();
    	assist.setRequires(Assist.and_eq("id", officialtradeid.toString().trim()));
    	officialTradeService.updateNonEmptyOfficialTrade(officialTrade, assist);
    	return "index";
    }
}
