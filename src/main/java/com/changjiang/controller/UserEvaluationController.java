package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.OfficialTrade;
import com.changjiang.entity.UserEvaluation;
import com.changjiang.service.UserEvaluationService;
/**
 * 
 * 用户评价
 *
 */
@Controller
@RequestMapping("/userevaluation")
public class UserEvaluationController {
	@Autowired
	private UserEvaluationService userEvaluationService;
	/**
	 * 查询所有的用户评价
	 * @return
	 */
	@RequestMapping(value="/queryuserevaluation")
	public String queryUserEvaluation(){
		Assist assist = new Assist();
		List<UserEvaluation> userEvaluations = userEvaluationService.selectUserEvaluation(assist);
		if(userEvaluations != null && userEvaluations.size() > 0){
			System.out.println("userEvaluations.size() :" + userEvaluations.size());
		}
		return "index";
	}
	/**
	 * 通过id查询用户评价
	 * @return
	 */
	@RequestMapping(value="/queryUserEvaluationById/{userevaluationbyid}")
	public String queryUserEvaluationById(@PathVariable Integer userevaluationbyid){
		
		UserEvaluation userEvaluation = userEvaluationService.selectUserEvaluationById(userevaluationbyid);
		if(userEvaluation != null){
			System.out.println("userEvaluation.getEvaluationTime() :" + userEvaluation.getEvaluationTime());
		}
		return "index";
	}
	/**
	 * 通过id删除用户评价
	 */
	@RequestMapping(value="/deleteUserEvaluationById/{userevaluationbyid}")
	public String deleteUserEvaluationById(@PathVariable Integer userevaluationbyid){
		
		int del_num = userEvaluationService.deleteUserEvaluationById(userevaluationbyid);
		System.out.println("del_num is :" + del_num);
		return "index";
	}
	/**
	 * 添加用户评价
	 */
	@RequestMapping(value="/addUserEvaluation")
	public String addUserEvaluationById(){
		UserEvaluation userEvaluation = new UserEvaluation();
		userEvaluation.setEvaluationContent("test");
		userEvaluation.setEvaluationPeople("test");
		userEvaluation.setEvaluationPeopleContactWay("test");
		userEvaluation.setEvaluationRank(1);
		userEvaluation.setNumber("654123");
		userEvaluation.setUserId(1);
		int add_num = userEvaluationService.insertNonEmptyUserEvaluation(userEvaluation);
		System.out.println("add_num is :" + add_num);
		return "index";
	}
	/**
	 * 更新用户评价
	 */
    @RequestMapping(value="/updateUserEvaluation/{userevaluationbyid}")
    public String updateUserEvaluation(@PathVariable("userevaluationbyid") Integer userevaluationbyid){
    	//模拟表单对象
    	UserEvaluation userEvaluation = new UserEvaluation();
		userEvaluation.setEvaluationContent("test");
		userEvaluation.setEvaluationPeople("test");
		userEvaluation.setEvaluationPeopleContactWay("test");
		userEvaluation.setEvaluationRank(1);
		userEvaluation.setNumber("654123");
		userEvaluation.setUserId(1);
    	Assist assist = new Assist();
    	assist.setRequires(Assist.and_eq("id", userevaluationbyid.toString().trim()));
    	userEvaluationService.updateNonEmptyUserEvaluation(userEvaluation, assist);
    	return "index";
    }
}
