package com.changjiang.shop;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.changjiang.config.MyMvcConfig;
import com.changjiang.service.FunctionService;
import com.changjiang.viewModel.FunctionNestNode;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestReidsCache {
	@Autowired
	@Qualifier("functionService")
	private FunctionService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<FunctionNestNode> nodes=service.getFunctionByUserId(1);
		System.out.println(nodes.get(0).getName());
		System.out.println(nodes.get(0).getNodes().get(0).getName());
	}

}
