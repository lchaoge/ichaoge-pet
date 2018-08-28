package com.ichaoge.pet.dao.mybatis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @description: spring application上下文获取工具类
 * @author  zengyang
 *
 */
@Lazy(false)
@Component
@SuppressWarnings("static-access")
public class ApplicationContextUtils implements ApplicationContextAware,Ordered,BeanPostProcessor {
	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	public static Object getService(String beanName) {
		return applicationContext.getBean(beanName);
	}
	public static <T> T getService(Class<T> type) {
		return applicationContext.getBean(type);
	}

	public int getOrder() {
		return 0;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
	 
}
