package com.changjiang.shop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.changjiang.config.MyMvcConfig;
import com.changjiang.service.FunctionService;
import com.changjiang.service.OrganizationService;
import com.changjiang.viewModel.FunctionNode;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestService {
	
	@Autowired
	private FunctionService functionService;
	@Autowired
	private OrganizationService organizationService;
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
		List<FunctionNode> result=organizationService.getAllOrganization();
		assertEquals(2,result.size());
	}

}
