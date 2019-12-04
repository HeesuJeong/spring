package ssafy.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * BeanFactory factory = new
		 * ClassPathXmlApplicationContext("/ssafy/phone/config/phonebean.xml");
		 */
		
		BeanFactory factory = new AnnotationConfigApplicationContext(PhoneConfig.class);
		
		Phone phone=(Phone)factory.getBean("apple");
		phone.powerOn();
		phone.takePicture();
		phone.powerOff();
		System.out.println(phone.howmuch());
	}

}
