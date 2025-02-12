package com.seleniumexpress.selexplms.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class SelExpLmsConfig {
	
//	@Autowired
//	private SessionFactory sessionFactory;

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException{
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSouce());
		sessionFactoryBean.setPackagesToScan("com.seleniumexpress.selexplms.entity");
		sessionFactoryBean.setHibernateProperties(getHibernateProerties());
		return sessionFactoryBean;
		
	}

	
	@Bean
	public DataSource getDataSouce(){
		
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("abhilash");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/seleniumexpressportal");
//		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		
		
//		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//		comboPooledDataSource.setUser("root");
//		comboPooledDataSource.setPassword("abhilash");
//		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/seleniumexpressportal");
//		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//		comboPooledDataSource.setInitialPoolSize(10);
//		comboPooledDataSource.setAcquireIncrement(5);
//		comboPooledDataSource.setMaxPoolSize(30);
//		comboPooledDataSource.setMaxIdleTime(3000);
		
	    BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/resumeproject");
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		basicDataSource.setInitialSize(10);
		basicDataSource.setMaxTotal(30);
		
		
		
		return basicDataSource;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		//transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
		
	}
	
	
	
	private Properties getHibernateProerties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

}





