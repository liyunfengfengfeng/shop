package com.changjiang.controller;

import com.changjiang.common.Assist;

/**
 * Created by a1996_000 on 2017/6/2.
 */

import com.changjiang.entity.OfficialTrade;
import com.changjiang.entity.ProducteType;
import com.changjiang.entity.StoreProducte;
import com.changjiang.service.ProducteTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品分类控制层
 */
@Controller
@RequestMapping("/producttype")
public class ProductTypeController {
    @Autowired
    private ProducteTypeService producteTypeService;

    /**
     * 查询所有的产品类型
     * @return
     */
    @RequestMapping(value = "/queryAll")
    public String queryAllProductTypes(){
    	Assist assist = new Assist();
        List<ProducteType> producteTypes = producteTypeService.selectProducteType(assist);
        if(producteTypes != null && producteTypes.size() > 0){
            for (ProducteType producteType:producteTypes){
                System.out.println(producteType.getName());
            }
        }
        return "index";
    }

    /**
     * 通过产品类型查询所有的店面产品以及办公贸易
     * @param
     * @return
     */
    @RequestMapping(value = "/queryproducttype")
    public String queryProductType(){
        int id = 1;
        List<ProducteType> producteTypes = producteTypeService.selectOfficialTradeAndProductByTypeId(id);
        if(producteTypes != null && producteTypes.size() > 0){
            for(ProducteType producteType:producteTypes){
                //办公贸易
                List<OfficialTrade> officialTrades = producteType.getOfficialTrades();
                System.out.print("officialTrades.size() :"  + officialTrades.size());
                for (OfficialTrade officialTrade:officialTrades){
                    System.out.println("officialTrade.getOfficialName() :" + officialTrade.getOfficialName());
                }
                //店面产品
                List<StoreProducte> storeProductes = producteType.getStoreProductes();
                System.out.println("storeProductes.size() :" + storeProductes.size());
                for (StoreProducte storeProducte:storeProductes){
                    System.out.println("storeProducte.getName() :" + storeProducte.getName());
                }
            }
        }
        return "index";
    }
    /**
     * 通过产品类型查询所有的店面产品
     * @param
     * @return
     */
    @RequestMapping(value = "/querystoreproduct")
    public String queryStoreProducteByType(){
        int id = 1;
        List<ProducteType> producteTypeList = producteTypeService.selectStoreProductByTypeId(id);
        if (producteTypeList != null && producteTypeList.size() > 0){
            System.out.println(" producteTypeList.size() :" + producteTypeList.size());
            for (ProducteType producteType:producteTypeList){
                System.out.println("producteType.getStoreProductes().size() :" + producteType.getStoreProductes().size());
            }
        }

        return "index";
    }
    /**
     * 删除所有的产品类型   (当有外键约束时无法删除)
     * @return
     */
    @RequestMapping(value = "/deleteproducttype")
    public String deleteProductTypes(){
    	int id = 2;
    	producteTypeService.deleteProducteTypeById(id);
        return "index";
    }
    /**
     * 添加所有的产品类型
     * @return
     */
    @RequestMapping(value = "/addproduct")
    public String addProductTypes(){
    	ProducteType productType = new ProducteType();
    	productType.setId(3);
    	productType.setDbDesc("test");
    	productType.setName("test");
    	producteTypeService.insertNonEmptyProducteType(productType);
        return "index";
    }
    /**
     * 更新所有的产品类型 
     * @return
     */
    @RequestMapping(value = "/updateproduct")
    public String updateProductTypes(){
    	ProducteType productType = new ProducteType();
    	productType.setId(3);
    	productType.setDbDesc("desc");
    	productType.setName("name");
    	producteTypeService.updateNonEmptyProducteTypeById(productType);
        return "index";
    }
}
