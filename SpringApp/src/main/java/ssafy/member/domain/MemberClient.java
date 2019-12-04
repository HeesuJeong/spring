package ssafy.member.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssafy.member.biz.MemberService;

//MemberClient클래스가 서블릿으로 바뀌면 돼(나중에 인자는 getparameter())
//알고리즘은 MemberService 클래스에서 로직 다 들어가 =>"비즈니스 로직"담당
//MemberDTO 받은거 저장만 해! => db에 넣든, 서버에 보내든=>"저장"담당
public class MemberClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BeanFactory fac=new AnnotationConfigApplicationContext(MemberConfig.class);
		@SuppressWarnings("resource")
		BeanFactory fac=new ClassPathXmlApplicationContext("/membercontext.xml");
		MemberService ser=(MemberService) fac.getBean("memberser");//다운캐스팅 필요
		ser.memberInsert("홍길동","21");
		ArrayList<MemberDTO> list=ser.memberSelectList();
		ser.memberUpdate("홍길동", "21");
		ser.memberDelete("");
	}

}
