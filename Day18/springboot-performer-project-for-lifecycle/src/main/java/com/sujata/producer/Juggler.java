package com.sujata.producer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("Gourav")
public class Juggler implements Performer, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,DisposableBean {

	
	private int balls;
	private String jugglerName;

	public Juggler(Dancer Bruno) {
		System.out.println("1. Instantiate Juggler, i.e Constructor");
		

	}

	// Setter Injection
	@Value("4")
	public void setBalls(int balls) {
		System.out.println("2. Populate Properties , ie Setter");
		this.balls = balls;
	}

	@Override
	public void perform() {
		System.out.println(this.jugglerName + " is juggling " + balls + " balls");

	}

	@Override
	public void setBeanName(String name) {
		System.out.println("3. setBeanName() from BeanNameAware called");
		this.jugglerName = name;

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4. setBeanFactory from BeanFactoryAware called");

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("5. setApplicationContext from ApplicationContextAware called");

	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("7. afterPropertiesSet from Initializing Bean called");
	}

	@PostConstruct
	public void jugglerInit() {
		System.out.println("8. custom init method called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destory from DisposableBean called for "+this.jugglerName);
		
	}
	
	@PreDestroy
	public void jugglerDestroy() {
		System.out.println("Custome destroy called for bean "+this.jugglerName);
	}
}
