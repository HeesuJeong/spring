package app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {
	public static void main(String[] args) {

		BeanFactory cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
		System.out.println("?");
		/*
		 * IMember mem1 = cxt.getBean(MemberImpl.class);
		 * System.out.println(mem1.toString());
		 */
		/*
		 * mem1.setName("둘리"); Member mem2 = (Member) cxt.getBean("mem");
		 * System.out.println(mem2.toString());
		 */
		IMember mem2=(IMember)cxt.getBean("mem");
		System.out.println(mem2.toString());
	}

}
