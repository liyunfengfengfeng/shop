package com.changjiang.controller;

import com.changjiang.common.Assist;

/**
 * Created by a1996_000 on 2017/6/2.
 */

import com.changjiang.entity.StoreProducte;
import com.changjiang.service.StoreProducteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 店面产品控制层  官方商品的增删改查
 */
@Controller
@RequestMapping("/storeproducte")
public class StoreProducteController {
    @Autowired
    private StoreProducteService storeProducteService;
    /**
     * 查询所有的店面产品
     * @return
     */
    @RequestMapping(value = "/queryall")
    public String queryAll(){
    	Assist assist = new Assist();
        List<StoreProducte> storeProductes = storeProducteService.selectStoreProducte(assist);
        System.out.println("storeProductes.size()  is :" + storeProductes.size());
        if (storeProductes != null && storeProductes.size() > 0){
            for (StoreProducte storeProducte : storeProductes){
                System.out.println("storeProducte.getName() is ：" + storeProducte.getName());
            }
        }
        return "index";
    }
    /**
     * 删除店面产品
     * @return
     */
    @RequestMapping(value="/deleteproducte")
    public String deleteProduct(){
    	//删除id为2的店面产品
    	int id = 2;
    	int num = storeProducteService.deleteStoreProducteById(id);
    	System.out.println(" delete num are " + num);
    	return "index";
    }
    /**
     * 添加店面产品     (不能添加完整数据)
     * @return
     */
    @RequestMapping(value="/addproducte")
    public String addProduct(){
    	StoreProducte storeProducte = new StoreProducte();
    	storeProducte.setId(4);
    	storeProducte.setDbDesc("test");
    	storeProducte.setName("test");
    	storeProducte.setPrice(102.02);
    	int num = storeProducteService.insertNonEmptyStoreProducte(storeProducte);
    	System.out.println(" add num are " + num);
    	return "index";
    }
    /**
     * 更新店面产品		(不能更新完整数据)
     * @return
     */
    @RequestMapping(value="/updateproducte")
    public String updateProduct(){
    	StoreProducte storeProducte = new StoreProducte();
    	storeProducte.setId(4);
    	storeProducte.setName("name");
    	storeProducte.setDbDesc("update");
    	storeProducte.setName("update");
    	storeProducte.setPrice(201.20);
    	int num = storeProducteService.updateNonEmptyStoreProducteById(storeProducte);
    	System.out.println(" update num are " + num);
    	return "index";
    }
    
}
