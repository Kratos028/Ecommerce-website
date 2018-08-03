package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.Products;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBconfig {

		@Bean("datasource")
		public DataSource getH2Datasource() {
			DriverManagerDataSource datasource = new DriverManagerDataSource(); 
			datasource.setDriverClassName("org.h2.Driver");
			datasource.setUrl("jdbc:h2:tcp://localhost/~/Shop");
			datasource.setUsername("sa");
			datasource.setPassword("");
			System.out.println("Data Created");
			return datasource;
			
		}
		@Bean
		public SessionFactory getSessionFactory()
		{
			Properties property = new Properties();
			property.put("hibernate.hbm2ddl.auto", "update");
			property.put("hibernate.show_sql", "true");
			property.put("hibernate.format_sql", "true");
			property.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(getH2Datasource());
			lsfb.addProperties(property);
			lsfb.addAnnotatedClass(Category.class);
			lsfb.addAnnotatedClass(User.class);
			lsfb.addAnnotatedClass(Supplier.class);
			lsfb.addAnnotatedClass(Products.class);
			lsfb.addAnnotatedClass(Cart.class);
			lsfb.addAnnotatedClass(OrderDetail.class);
			SessionFactory sessionFactory = lsfb.buildSessionFactory();
			System.out.println("Session Created");
			return sessionFactory;			
		}
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("Session Created");
			return new HibernateTransactionManager(getSessionFactory());
		}
}
