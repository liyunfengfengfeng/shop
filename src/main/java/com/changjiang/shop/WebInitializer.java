package com.changjiang.shop;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.changjiang.config.MyMvcConfig;


public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		ctx.setServletContext(arg0);
		Dynamic servlet=arg0.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true);//开启Servlet异步方法的支持
		javax.servlet.FilterRegistration.Dynamic encodingFilter=arg0.addFilter
				("encodingFilter",CharacterEncodingFilter.class);
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
		encodingFilter.setInitParameter("encoding", "UTF-8");//解决中文乱码
		// TODO Auto-generated method stub
		
	}
}
