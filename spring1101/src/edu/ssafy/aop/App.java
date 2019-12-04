package edu.ssafy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Iperson boy = context.getBean("boy", Iperson.class);
		Iperson girl = context.getBean("girl", Iperson.class);
		try {
			boy.doSomething();
			girl.doSomething();
		} catch (RuntimeException e) {

		}
	}

}
