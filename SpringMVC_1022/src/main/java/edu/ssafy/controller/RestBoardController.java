package edu.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import edu.ssafy.dto.BoardDto;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.BoardService;

@Controller
@RequestMapping("/api")
public class RestBoardController {
	@Autowired
	private BoardService ser;

	@RequestMapping("boardregpage")
	public String insertPage() {
		return "board/boardreg";
	}

	
	@GetMapping(value="boardviewpage")
	//@RequestMapping(value="boardviewpage",method=RequestMethod.GET)
	// 모든 인자는 json으로 넘어오는데 spring이 json을 알아서 객체로 바꿔서 가져온다
	// jacksonbinder 라이브러리가 한다! pom.xml에 꼭 추가해야해
	public @ResponseBody BoardDto viewPage(@RequestBody BoardDto dto) {
		
		
		BoardDto board = null;
		try {
		board=ser.selectOne(dto.getNo()); //조회한 객체를 json으로 바꿔서 다시 리턴하려면 @ResponseBody
		}catch(Exception e){
			
		}
		return board;
	}

	@PostMapping("boardreg/{no}/{title}/{content}")
	//@RequestMapping("boardreg/{no}/{title}/{content}")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> insert(@PathVariable("no") String no,@PathVariable("title") String title,@PathVariable("content") String content){
	/* (@RequestBody BoardDto dto) { */
		//응답하는 객체 하나 만들어서 뭐가 됐든 객체에 담아 보내쟈
		//무조건 이 객체를 던진다. void가 아니라 =>객체 또한 json으로 바뀌어야 하므로 @ResponseBody
		HashMap<String, Object> map=new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res=null;
		try {
			//ser.insert(dto.getNo(), dto.getTitle(), dto.getContent());
			ser.insert(no, title, content);
			map.put("resmsg","입력성공");
			map.put("resdata",new BoardDto(no,title,content));
			//통신이 잘 됐다는 의미의 OK이다
			//catch에서도 OK그대로!
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg","입력실패");
			map.put("resdata",new BoardDto(no,title,content));
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@GetMapping("boardlist")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> selectList() {
		HashMap<String, Object> map=new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res=null;
		try {
			List<BoardDto> list = ser.selectList();
			map.put("resmsg","리스트 조회 성공");
			map.put("resdata",list);
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg","리스트 조회 실패");
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@PutMapping("boardupdate")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> update(@RequestBody BoardDto dto) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res=null;
		try {
			int update = ser.update(dto.getNo(), dto.getTitle(), dto.getContent());
			map.put("resmsg","수정 성공");
			map.put("resdata",update);
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg","수정  실패");
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@DeleteMapping("boarddelete/{no}") //인자로 @RequestBody BoardDto dto 받지 말고, path로 받을 수 있어
	//delete의 경우 no만 담긴 dto여도 나머지 null값이 들어있어도 dto를 인자로 가져와!
	public @ResponseBody ResponseEntity<HashMap<String, Object>> delete(@PathVariable("no") String no) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res=null;
		try {
			//int delete = ser.delete(dto.getNo());
			int delete = ser.delete(no);
			map.put("resmsg","삭제 성공");
			//map.put("resdata",delete);
			map.put("resdata",no);
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg","삭제  실패");
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@GetMapping("boardselectone")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> selectOne(@RequestBody BoardDto dto) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res=null;
		try {
			BoardDto selectOne = ser.selectOne(dto.getNo());
			map.put("resmsg","조회 성공");
			map.put("resdata",selectOne);
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg","조회  실패");
			res = new ResponseEntity<HashMap<String, Object>>(map,HttpStatus.OK);
		}
		return res;
	}
}