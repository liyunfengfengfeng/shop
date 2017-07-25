package com.changjiang.controller;

import com.changjiang.common.Assist;

/**
 * Created by a1996_000 on 2017/6/2.
 */

import com.changjiang.entity.Store;
import com.changjiang.entity.StoreProducte;
import com.changjiang.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 店面控制层
 */
@Controller
public class StoreController {
    //店面业务层
    @Autowired
    private StoreService service;

    /**
     * 查询所有的店面信息
     * @return
     */
    @RequestMapping(value = "/queryAllStore")
    public String queryAllStores(){
    	Assist assist = new Assist();
        List<Store> stores = service.selectStore(assist);
        if(stores != null && stores.size() > 0){
            for(Store store:stores){
                System.out.println(store.getName());
            }
        }
        return "index";
    }
    /**
     * 通过店面id查询某个店中所有的产品
     */
    @RequestMapping(value = "/queryStoreProducteByStoreId/{storeid}")
    public String queryStoreProducteByStoreId(@PathVariable Integer storeid){
    	List<StoreProducte>  storeProductes= service.queryStoreProducteByStoreId(storeid);
    	System.out.println(storeid + "对应店面产品数是" + storeProductes.size());
        return "index";
    }
    @RequestMapping(value="/storeId",produces="text/plain;charset=UTF-8",
    		method=RequestMethod.POST)
    @ResponseBody
    public String getStoreIdByStoreNumber(@RequestParam("storeNumber") String storeNumber){
    	return service.selectStoreIdByStoreNumber(storeNumber).toString();
    }
    @RequestMapping(value="/enabledStoresByOraganization",produces="application/json;charset=UTF-8",
    		method=RequestMethod.POST)
    @ResponseBody
    public List<Store> getEnabledStoreByOraganization(@RequestParam("oraganization") Integer
    		id){
    	return service.selectEnabledStoreByOrganizationId(id);
    }
}
