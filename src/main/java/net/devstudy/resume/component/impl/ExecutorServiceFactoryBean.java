package net.devstudy.resume.component.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("defaultExecutorService")
public class ExecutorServiceFactoryBean implements FactoryBean<ExecutorService> {
	public static final String AUTO = "AUTO";
	private ExecutorService executorService;
	
	private boolean autoThreadCount;
	private int threadCount;
	
	@Value("${executorService.threadCount}")
	public void setThreadCount(String threadCount) {
		if(AUTO.equalsIgnoreCase(threadCount.trim())) {
			autoThreadCount = true;
		}
		else {
			this.threadCount = Integer.parseInt(threadCount.trim());
			if(this.threadCount <= 0) {
				autoThreadCount = true;
			}
		}
	}
	
	@PostConstruct
	private void postConstruct(){
		if(autoThreadCount) {
			executorService = Executors.newCachedThreadPool();
		} else {
			executorService = Executors.newFixedThreadPool(threadCount);
		}
	}
	
	@PreDestroy
	private void preDestroy (){
		executorService.shutdown();
	}
	
	@Override
	public ExecutorService getObject() throws Exception {
		return executorService;
	}

	@Override
	public Class<?> getObjectType() {
		return ExecutorService.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
