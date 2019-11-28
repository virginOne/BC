package com.zjj.bc.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *ClassName:SpringUtil
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月12日
 *@Version 1.0
 */
@Component
public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtil.applicationContext=applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if(applicationContext.containsBean(beanName)) {
			return (T)applicationContext.getBean(beanName);
		}else {
			return null;
		}
	}
	
	public static <T> Map<String, T> getBeansOfType(Class<T> baseType){
        return applicationContext.getBeansOfType(baseType);
    }

	public static <T> T getBean(Class<T> c){
		return (T) applicationContext.getBean(c);
	}

	
}
