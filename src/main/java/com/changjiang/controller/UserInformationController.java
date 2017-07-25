//package com.changjiang.controller;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.changjiang.entity.UserEvaluation;
//import com.changjiang.entity.UserInformation;
//import com.changjiang.service.UserInformationService;
//import com.changjiang.viewModel.UserInformationModel;
//
///**
// * 
// * 用户信息控制层
// */
//@RestController
//public class UserInformationController {
//	@Autowired
//	private UserInformationService service;
//	/**
//	 * 查询用户信息和他的所有评价
//	 */
//	@RequestMapping(value="/queryUserInfoAndEvalu/{userinforid}")
//	public String queryUserInformationAndEvaluations(@PathVariable("userinforid") Integer userinforid){
//		List<UserInformation> userInformations = service.queryUserInformationAndEvaluations(userinforid);
//		if(userInformations != null && userInformations.size() > 0){
//			System.out.println("userInformations.size() :" + userInformations.size());
//			for(UserInformation userInformation : userInformations){
//				List<UserEvaluation> userEvaluations = userInformation.getUserEvaluations();
//				if(userEvaluations != null && userEvaluations.size() > 0){
//					System.out.println("userEvaluations.size() :"  +  userEvaluations.size());
//				}
//			}
//		}
//		System.out.println("userinforid :"  + userinforid);
//		return "index";
//	}
//	//添加用户信息，并返回id
//	@RequestMapping(value="/addUserInformation",method=RequestMethod.POST,produces
//			="text/plain;charset=UTF-8")
//	public String addUserInformation(UserInformationModel userInformation){
//		Integer id=service.addUserInformation(userInformation);
//		if(id!=null){
//			return id.toString();
//		}else{
//			return "defeat";
//		}
//	}
//	//根据状态获取员工信息
//	@RequestMapping(value="/stateUserInformation",method=RequestMethod.POST,produces
//			="application/json;charset=UTF-8")
//	public List<UserInformation> getUserInformationByState(Integer storeId,Integer state){
//		List<UserInformation> result=service.selectUserInformationByStoreIdAndState(storeId, state);
//		return result;
//	}
//	@RequestMapping(value="/deleteManyUserInformation",method=RequestMethod.POST,produces
//			="text/plain;charset=UTF-8")
//	public String deleteUserInforamtion(Integer[] userInformationIds){
//		if(service.deleteManyUserInformation(userInformationIds)){
//			return "success";
//		}else{
//			return "defeat";
//		}
//	}
//	@RequestMapping(value="/deleteManyUserInformation",method=RequestMethod.POST,produces
//			="text/plain;charset=UTF-8")
//	public String deleteSingleUserInformation(Integer userInformationId){
//		if(service.deleteSingleUserInformation(userInformationId)){
//			return "success";
//		}else{
//			return "defeat";
//		}
//	}
//	@RequestMapping(value="/changeUserInformation",method=RequestMethod.POST,produces
//			="text/plain;charset=UTF-8")
//	public String changeUserInformation(UserInformation userInformation){
//		int sign=service.updateNonEmptyUserInformationById(userInformation);
//		if(sign==1){
//			return "success";
//		}else{
//			return "defeat";
//		}
//	}
//}
