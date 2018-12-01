package net.devstudy.resume.configuration;

import java.util.Collections;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public SimpleCacheManager cacheManager(){
		SimpleCacheManager manager = new SimpleCacheManager();
		manager.setCaches(Collections.singleton(profileCache().getObject()));
		return manager;
	}
	
	@Bean
	public ConcurrentMapCacheFactoryBean profileCache(){
		ConcurrentMapCacheFactoryBean cache = new ConcurrentMapCacheFactoryBean();
		cache.setName("profile");
		return cache;
	}
}
