package com.changjiang.config;

import java.io.IOException;
import java.sql.SQLException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.changjiang.controller.StoreController;
import com.changjiang.service.StoreServiceImpl;
import com.changjiang.util.MybatisRedisCache;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy//开启切面自动代理
@EnableTransactionManagement//开启注解方式事务管理
@ComponentScan(basePackageClasses={MyMvcConfig.class,StoreController.class,
		StoreServiceImpl.class,MybatisRedisCache.class})
@PropertySource("classpath:db.properties")//配置文件
@MapperScan(basePackages="com.changjiang.dao") //扫描接口
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	  //关系型数据库配置信息
	  @Value("${jdbc.driver}")
	  private String driver;
	  @Value("${jdbc.url}")
	  private String url;
	  @Value("${jdbc.username}")
	  private String user;
	  @Value("${jdbc.password}")
	  private String password;
	  @Autowired
	  private ApplicationContext applicationContext;
	  public void setApplicationContext(ApplicationContext applicationContext) {
	    this.applicationContext = applicationContext;
	  }
	  
	  @Bean
	  public PlatformTransactionManager txManager() throws SQLException {
	     return new DataSourceTransactionManager(dataSource());
	  }
	  //用于读取配置文件
	  @Bean
	  public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		  return new PropertySourcesPlaceholderConfigurer();
	  }
	  //Druid数据库连接池
	  @Bean
	  public DruidDataSource dataSource() throws SQLException{
		  DruidDataSource data=new DruidDataSource();
		  //配置数据源
		  data.setDriverClassName(driver);
	      data.setUrl(url);
	      data.setUsername(user);
	      data.setPassword(password);
	       //配置连接池属性
		  data.setInitialSize(5);//初始化大小
		  data.setMinIdle(1);//最小连接数
		  data.setMaxActive(20);//最大连接数
		  data.setMaxWait(6000);//配置获取连接等待超时的时间
		  data.setTimeBetweenEvictionRunsMillis(6000);//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		  data.setMinEvictableIdleTimeMillis(300000);//配置一个连接在池中最小生存的时间，单位是毫秒
		  //打开PSCache，并且指定每个连接上PSCache的大小
		  data.setPoolPreparedStatements(true);
		  data.setMaxPoolPreparedStatementPerConnectionSize(20);
		  data.setFilters("start");
		  return data;
	  }
	  //JDBC事物管理
	  @Bean
	  public DataSourceTransactionManager transactionManager(DruidDataSource 
			  dataSource){
		  DataSourceTransactionManager manager=new DataSourceTransactionManager
				  (dataSource);
		  return manager;
	  }
	  //获取Mybatis的SqlSessionFactory
	  @Bean
	  public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) throws 
	  IOException{
		  SqlSessionFactoryBean b=new SqlSessionFactoryBean();
		  b.setDataSource(dataSource);
		  //将mybatis-config.xml配置文件注入到SqlSessionFactory
		  b.setConfigLocation(applicationContext.getResource
				  ("classpath:mybatis-config.xml"));
		  // 设置 mapper xml
	      b.setMapperLocations(applicationContext.getResources
	    		  ("classpath:com/changjiang/dao/*.xml"));
		  return b;
	  }
	  /**
	   * 以下三个Bean配置视图解析器
	   * @return
	   */
	  @Bean
	  public ViewResolver viewResolver() {
	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	    resolver.setTemplateEngine(templateEngine());
	    resolver.setCharacterEncoding("UTF-8");
	    return resolver;
	  }
	  @Bean
	  public TemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setEnableSpringELCompiler(true);
	    engine.setTemplateResolver(templateResolver());
	    return engine;
	  }
	@Bean
	public ITemplateResolver templateResolver(){
		SpringResourceTemplateResolver resolver = new 
				SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("/WEB-INF/classes/views/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver m=new CommonsMultipartResolver();
		return m;
	}
	//需要特别注意的是：/css/**的意思是这个文件夹下的文件为静态资源，它下面的文件夹不是静态资源，所以要单独的进行设置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("assets/**").addResourceLocations("classpath:"
				+ "/assets/");
		registry.addResourceHandler("yangtze_assets/**").addResourceLocations
		("classpath:/yangtze_assets/");
	}
	/**
	 * 对于/index访问参数视图解析器返回逻辑名称为index的视图用于显示
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
//		registry.addViewController("/").setViewName("login");
	}
}