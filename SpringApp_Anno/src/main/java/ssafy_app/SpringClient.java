package ssafy_app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BeanFactory fac = new ClassPathXmlApplicationContext("/ssafy/spring/config/config.xml");
		
		BeanFactory fac=new AnnotationConfigApplicationContext(config.class); 
		IMember mem = (IMember)fac.getBean("mem");
		mem.setBig(new BigMouse("선한빛"));
		System.out.println(mem.toString());
	}

}
