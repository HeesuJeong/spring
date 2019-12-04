package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository repo;


	public void insert(String num, String title, String content) throws Exception {
		// TODO Auto-generated method stub
		repo.insert(new BoardDto(num,title,content));
	}

	
	public List<BoardResult> selectList() throws Exception {
		// TODO Auto-generated method stub
		return repo.selectList();
	}


	public void update(String num, String title, String content) {
		// TODO Auto-generated method stub
		repo.update(new BoardDto(num, title, content));
	}


	public void delete(String num) {
		// TODO Auto-generated method stub
		repo.delete(num);
	}


	public BoardResult selectOne(String num) {
		// TODO Auto-generated method stub
		return repo.selectOne(num);
	}
}
