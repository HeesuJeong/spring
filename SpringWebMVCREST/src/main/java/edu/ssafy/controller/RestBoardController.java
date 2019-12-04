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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.service.BoardService;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api")
public class RestBoardController {
	@Autowired
	BoardService ser;

	@Autowired
	BoardDto dd;
	
	@ApiOperation(value="게시판에 보드를 입력합니다")
	@RequestMapping(value="/restboard",method=RequestMethod.POST)
	//json으로 날라온다. json파싱해서 각 이름에 매칭된 값 알아서 넣어줘
	public void boardInsert(@RequestBody BoardDto dto) throws Exception {
		ser.insert(dto.getNum(), dto.getTitle(), dto.getContent());
	}
	
	@ApiOperation(value="게시판을 조회합니다.",response=List.class)
	@RequestMapping(value="/restboard",method=RequestMethod.GET)
	public @ResponseBody List<BoardResult> boardlist() throws Exception {
		List<BoardResult> selectList = ser.selectList();
		return selectList;
	}
	//@ResponseBody=>결과를 json으로 리턴해준다.
	@ApiOperation(value="보드 하나를 조회합니다.",response=List.class)
	@RequestMapping(value="/restboard/{num}",method=RequestMethod.GET)
	public @ResponseBody BoardResult boardOne(@PathVariable String num) throws Exception {
		BoardResult selectOne = ser.selectOne(num);
		return selectOne;
	}
	
	@ApiOperation(value="게시판을 수정합니다")
	@RequestMapping(value="/restboard",method=RequestMethod.PUT)
	//json으로 날라온다. json파싱해서 각 이름에 매칭된 값 알아서 넣어줘
	public void boardUpdate(@RequestBody BoardDto dto) throws Exception {
		System.out.println("뽑아보자"+dto.toString());
		ser.update(dto.getNum(), dto.getTitle(), dto.getContent());
	}
	
	@ApiOperation(value="게시판을 삭제합니다")
	@RequestMapping(value="/restboard/{num}",method=RequestMethod.DELETE)
	public void boardDelete(@PathVariable String num) throws Exception {
		System.out.println("delete "+num);
		ser.delete(num);
	}
}
