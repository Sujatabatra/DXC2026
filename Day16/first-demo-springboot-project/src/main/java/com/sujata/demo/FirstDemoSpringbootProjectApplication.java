package com.sujata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sujata.producer.Performer;
import com.sujata.producer.Singer;


/*
 * Phases
 * 1. Application Starts
 * 2. SpringApplication.run()
 * 3. Create Application Context (Spring Container, which is responsible for maintaining the lifecycle of componenets)
 * 4. Auto Configuration
 * 5. Bean Creation (classes annotated with @Component those classes objects gets created
 * 6. Dependency Injection
 */
@SpringBootApplication(scanBasePackages = "com.sujata")
public class FirstDemoSpringbootProjectApplication {

	public static void main(String[] args) {
		
		 ApplicationContext springContainer= SpringApplication.run(FirstDemoSpringbootProjectApplication.class, args);
	
		 Performer performer1=(Performer)springContainer.getBean("Marcial");
		 performer1.perform();
		 
		/*
		 * Traditionally without Spring Creation and life cycle maintainance of component by the consumer developer itself
		 */
//		Performer performer1=new Singer();
		/*
		 * Spring says, being a component consumer, Spring Container will be handling the life cycle of the component,
		 * to maintain the lifecycle just tell what all are the components 
		 */
		
		
	}

}
