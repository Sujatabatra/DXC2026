package com.sujata.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sujata.producer.Performer;

/*
 * IOC : Inversion of Control: seperating depedency logic from the actula bussiness logic of an application
 * how we do IOC with the help of dependency injection
 */
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
public class SpringbootPerformerProjectApplication {

	public static void main(String[] args) {

		ApplicationContext springContainer = SpringApplication.run(SpringbootPerformerProjectApplication.class, args);

		Performer performer1 = (Performer) springContainer.getBean("Bruno");
		performer1.perform();

		Performer performer2 = (Performer) springContainer.getBean("Avneet");
		performer2.perform();

		Performer performer3 = (Performer) springContainer.getBean("Gourav");
		performer3.perform();
		
		Performer performer4 = (Performer) springContainer.getBean("Harshitha");
		performer4.perform();
	}

}
