package edu.ssafy.aop;

import org.springframework.stereotype.Component;

@Component
public class Boy implements Iperson{

	@Override
	public void doSomething() throws RuntimeException {
		// TODO Auto-generated method stub
		System.out.println("인형을 가지고 논다.");
	}

}
