package net.devstudy.resume.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Configuration
@PropertySource("classpath:properties/mongo.properties")
@EnableMongoRepositories("net.devstudy.resume.repository.storage")
public class MongoConfig {

	@Autowired
	private Environment environment;
	
	/**
	 * http://docs.spring.io/autorepo/docs/spring/4.2.5.RELEASE/spring-framework-reference/html/beans.html
	 * 
	 * By default, beans defined using Java config that have a public close or shutdown method are automatically enlisted with a destruction callback.
	 */
	
	@Bean(/*destroyMethod="close"*/)
	public MongoClient mongoClient() throws UnknownHostException {
		return new MongoClient(
				environment.getRequiredProperty("mongo.host"), 
				Integer.parseInt(environment.getRequiredProperty("mongo.port")));
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(
				mongoClient(), 
				environment.getRequiredProperty("mongo.db"));
		return mongoTemplate;
	}
}
