package com.sujata.producer;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PerformerInitialization implements BeanPostProcessor {

	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("6. postProcessBeanInitialization happens for "+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	@Override
	public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("9. postProcessAfterInitialization happens for "+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
