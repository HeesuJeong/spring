package edu.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class MemberController {
	
	@RequestMapping("login")
	public ModelAndView login(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			ModelAndView mv, HttpSession session) {
		
		//(1) id/pw가 실제 가입 회원인지 조회
		//ser > repo > sql
		
		//(2) 가입회원이라면, 세션에 저장한다.
		//1번이 true라면, 세션을 가져온다. (request를 받아서 getSession 하거나, httpsession 변수로 받아서 저장)
		session.setAttribute("userid", id);
		
		//(3) 결과화면 실행
		return mv;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:boardlist";
	}
}
