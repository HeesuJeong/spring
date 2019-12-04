package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

@Controller
public class MemberController {
	//@RequestMapping(value= {"/","index"},method=RequestMethod.GET)
	@GetMapping("/") //알아서 get 방식 돈다 => spring framework 4.3부터 어노테이션 지원했다!! @PutMapping @PostMapping @DeleteMapping
	public String home() {
		return "index";
	}
	

	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ser;

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv; // 등록페이지 불러온다
	}

	// 클라이언트에서 멤버 정보 주면 서비스로 가서
	// 서비스에서 레포지터리 가서 저장하는 것 까지 해보겠다.
	@RequestMapping("/meminsert") /* /member/memregpage */
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리
		ser.insert(id, pw, name, email);
		/* 하나 처리하고 하나 리턴하지 말고 리스트로 한번에! */
		// 결과처리
		/*
		 * List<Member> list = ser.selectList();
		 * 
		 * // list.add(new Member(id,null,name,email)); mv.addObject("list", list);
		 * mv.setViewName("member/memlist"); // test.jsp로 res데이터 넘긴다.
		 */		
		//sendredirect하쟈(forward도 가능) request살아남냐,url변경되냐의 차이점
		mv.setViewName("redirect:memselectlist");
		return mv;
	}

	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리
		ser.update(id, pw, name, email);
		// 화면처리
		mv.setViewName("redirect:memselectlist");
		
		return mv;
	}

	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		ser.delete(id);
		// 화면처리
		List<Member> list = ser.selectList();
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}

	@RequestMapping("/memselectone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		Member selectOne=ser.selectOne(id);
		// 화면처리
		mv.addObject("mem",selectOne);
		mv.setViewName("member/memview");
		return mv;
	}

	@RequestMapping("/memselectlist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		List<Member> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("member/memlist"); // test.jsp로 res데이터 넘긴다.

		return mv;
	}
}
