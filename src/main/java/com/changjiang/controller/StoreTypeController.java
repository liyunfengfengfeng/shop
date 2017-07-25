package com.changjiang.controller;

import com.changjiang.common.Assist;

/**
 * Created by a1996_000 on 2017/6/2.
 */

import com.changjiang.entity.Store;
import com.changjiang.entity.StoreType;
import com.changjiang.service.StoreTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 店面类型控制层
 */
@Controller
@RequestMapping("/storetype")
public class StoreTypeController {
    @Autowired
    private StoreTypeService storeTypeService;

    /**
     * 查询所有的店面类型
     * @return
     */
    @RequestMapping(value = "/queryAll")
    public String queryAllStoreTypes(){
    	Assist assist = new Assist();
        List<StoreType> storeTypes =  storeTypeService.selectStoreType(assist);
        if(storeTypes != null && storeTypes.size() > 0){
            for (StoreType storeType:storeTypes){
                System.out.println(storeType.getStoreTypeName());
            }
        }
        return "index";
    }
    /**
     * 通过店面类型查询所有的店面  嵌套结果: 使用嵌套结果映射来处理重复的联合结果的子集
     */
    @RequestMapping(value = "/queryStoreByTypeId")
    public String queryAllByStoreTypeId(){
        //店面类型id
        int id = 1;
        List<StoreType> storeTypes = storeTypeService.getStoresByStoreType(id);
        if(storeTypes != null && storeTypes.size() > 0){
            for(StoreType storeType:storeTypes){
                System.out.println("店面类型的名称:" + storeType.getStoreTypeName());
                List<Store> stores = storeType.getStores();
                if(stores != null && stores.size() > 0){
                    for (Store store:stores){
                        System.out.println("店面名称是:" + store.getName());
                    }
                }
            }
        }
        return "index";
    }
}
