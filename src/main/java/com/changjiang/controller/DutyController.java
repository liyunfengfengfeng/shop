package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.changjiang.entity.Duty;
import com.changjiang.service.DutyService;

@RestController
public class DutyController {
	@Autowired
	private DutyService service;
	@RequestMapping(value="/duties",method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	public List<Duty> getAllDuty(@RequestParam("storeNumber") String storeNumber){
		List<Duty> duties=service.selectDutyByStoreNumber(storeNumber);
		return duties;
	}
	
}
