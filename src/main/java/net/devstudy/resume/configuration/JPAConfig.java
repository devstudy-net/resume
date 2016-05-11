package net.devstudy.resume.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("net.devstudy.resume.repository.storage")
public class JPAConfig {

	@Autowired
	private Environment environment;
	
	/**
	 * http://docs.spring.io/autorepo/docs/spring/4.2.5.RELEASE/spring-framework-reference/html/beans.html
	 * 
	 * By default, beans defined using Java config that have a public close or shutdown method are automatically enlisted with a destruction callback.
	 */
	
	@Bean(/*destroyMethod="close"*/)
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.password"));
		dataSource.setInitialSize(Integer.parseInt(environment.getRequiredProperty("db.pool.initSize")));
		dataSource.setMaxTotal(Integer.parseInt(environment.getRequiredProperty("db.pool.maxSize")));
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("javax.persistence.validation.mode", "none");
		return properties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("net.devstudy.resume.entity");
		entityManagerFactory.setJpaProperties(hibernateProperties());
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
