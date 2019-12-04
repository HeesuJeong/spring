package edu.ssafy.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.service.BoardService;


@Controller
public class BoardController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionMethod(ModelAndView mv, Exception e) {
		mv.addObject("msg", ""+e.toString());
		mv.setViewName("error");
		return mv;
	}
	@Autowired
	BoardService ser;
	
	//리턴이 void이면 requestMapping의 value값과 같은 .jsp를 찾아
	//method명시 안 하면 get타고 post탄다
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model m) {
		//System.out.println("여기 들어는 와?");
		m.addAttribute("message", "메인페이지 입니다");
		return "index";
	}
	
	@RequestMapping(value="/boardinsertpage")
	public String boardInsertPage(Model m) {
		return "boardinsert";
	}
	@RequestMapping(value="/boardinsert")
	public String boardInsert(HttpServletRequest req,HttpServletResponse res, HttpSession session, ModelAndView mv, Locale local, Model m,
		/*	@RequestParam("num")String num,
			@RequestParam("title")String title,
			@RequestParam("content")String content*/
			BoardDto dto
			) throws Exception {
		/* param추출 방법 1
		 * String num=req.getParameter("num"); String title=req.getParameter("title");
		 * String content=req.getParameter("content");
		 */
		//param추출 방법2  @RequestParam 어노테이션 사용!
		//param추출 방법3 인자를 BoardDto 클래스로 받아오기
		System.out.println(dto.toString());
		ser.insert(dto.getNum(), dto.getTitle(), dto.getContent());
		return "redirect:boardlist"; //F5할 때 주소바뀌면서 새로 페이지 갱신하게 하기 위해서 redirect명시하는게 제일 좋아
		
	}
	@RequestMapping(value="boardlist")
	public ModelAndView boardlist(ModelAndView mv) throws Exception {
		List<BoardResult> selectList = ser.selectList();
		mv.addObject("list",selectList);
		mv.setViewName("boardlist");
		return mv;
	}
}
