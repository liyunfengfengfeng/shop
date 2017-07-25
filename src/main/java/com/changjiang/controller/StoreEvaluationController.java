package com.changjiang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.StoreEvaluation;
import com.changjiang.service.StoreEvaluationService;

/**
 * 店面评价
 * @author a1996_000
 *
 */
@Controller
@RequestMapping("/storeevaluation")
public class StoreEvaluationController {
	@Autowired
	private StoreEvaluationService storeEvaluationService;
	/**
	 * 查询所有的店面评价
	 */
	@RequestMapping(value="queryallstoreevaluation")
	public String queryAllStoreEvaluation(){
		Assist assist = new Assist();
		List<StoreEvaluation> storeEvaluations = storeEvaluationService.selectStoreEvaluation(assist);
		System.out.println("storeEvaluations.size() :" + storeEvaluations.size());
		return "index";
	}
	/**
	 * 通过id删除店面评价
	 */
	@RequestMapping(value="deletestoreevaluationbyid/{storeevaluationbyid}")
	public String deleteStoreEvaluationById(@PathVariable Integer storeevaluationbyid){
		Assist assist = new Assist();
		int del_num = storeEvaluationService.deleteStoreEvaluationById(storeevaluationbyid);
		System.out.println("del_num :" + del_num);
		return "index";
	}
	/**
	 *  添加店面评价
	 */
	@RequestMapping(value="addstoreevaluationbyid")
	public String addStoreEvaluationById(){
		StoreEvaluation storeEvaluation = new StoreEvaluation();
		storeEvaluation.setEvaluationContent("test");
		storeEvaluation.setEvaluationPeople("test");
		storeEvaluation.setEvaluationPeopleContactWay("test");
		storeEvaluation.setEvaluationTime(new Date());
		storeEvaluation.setNumber("123");
		storeEvaluation.setStoreNumber("123465");
		int add_num = storeEvaluationService.insertNonEmptyStoreEvaluation(storeEvaluation);
		System.out.println("add_num :" + add_num);
		return "index";
	}
	/**
	 * 更新店面评价
	 */
	@RequestMapping(value="updatestoreevaluationbyid")
	public String updateStoreEvaluationById(){
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("id", "2"));
		StoreEvaluation storeEvaluation = new StoreEvaluation();
		storeEvaluation.setEvaluationContent("test");
		storeEvaluation.setEvaluationPeople("test");
		storeEvaluation.setEvaluationPeopleContactWay("test");
		storeEvaluation.setEvaluationTime(new Date());
		storeEvaluation.setNumber("123");
		storeEvaluation.setStoreNumber("123465");
		int del_num = storeEvaluationService.updateNonEmptyStoreEvaluation(storeEvaluation, assist);
		System.out.println("del_num :" + del_num);
		return "index";
	}
}
