package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.ProducteEvaluation;
import com.changjiang.service.ProducteEvaluationService;

/**
 * 
 * 产品的评价
 * @author a1996_000
 *
 */
@Controller
@RequestMapping("/producteevaluation")
public class ProducteEvaluationController {
	@Autowired
	private ProducteEvaluationService producteEvaluationService;
	/**
	 * 查询所有的产品的评价
	 */
	@RequestMapping(value="queryallproducteevaluation")
	public String queryAllproducteEvaluation(){
		Assist assist = new Assist();
		List<ProducteEvaluation> producteEvaluations = producteEvaluationService.selectProducteEvaluation(assist);
		System.out.println("producteEvaluations.size() :" + producteEvaluations.size());
		return "index";
	}
	/**
	 * 通过id删除产品的评价
	 */
	@RequestMapping(value="deleteproducteevaluationbyid/{producteevaluationbyid}")
	public String deleteStoreEvaluationById(@PathVariable("producteevaluationbyid") Integer producteevaluationbyid){
		Assist assist = new Assist();
		int del_num = producteEvaluationService.deleteProducteEvaluationById(producteevaluationbyid);
		System.out.println("del_num :" + del_num);
		return "index";
	}
	/**
	 *  添加产品的评价
	 */
	@RequestMapping(value="addproducteevaluation")
	public String addStoreEvaluationById(){
		ProducteEvaluation producteEvaluation = new ProducteEvaluation();
		producteEvaluation.setEvaluationContent("test");
		int add_num = producteEvaluationService.insertNonEmptyProducteEvaluation(producteEvaluation);
		System.out.println("add_num :" + add_num);
		return "index";
	}
	/**
	 * 更新产品的评价
	 */
	@RequestMapping(value="updateproducteevaluationbyid")
	public String updateProducteEvaluationById(){
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("id", "1"));
		ProducteEvaluation producteEvaluation = new ProducteEvaluation();
		producteEvaluation.setEvaluationContent("tedsdsdst");
		int del_num = producteEvaluationService.updateNonEmptyProducteEvaluation(producteEvaluation, assist);
		System.out.println("del_num :" + del_num);
		return "index";
	}
}
