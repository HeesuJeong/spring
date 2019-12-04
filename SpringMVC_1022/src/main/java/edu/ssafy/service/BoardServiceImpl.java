package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.repo.BoardRepo;

@Service(value="BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	//@Qualifier("BoardRepo")
	private BoardRepo repo;
	
	public BoardServiceImpl() {}
	
	@Override
	@Transactional
	public int insert(String no, String title, String content) {
		return repo.insert(new BoardDto(no, title, content));
	}

	@Override
	@Transactional
	public int update(String no, String title, String content) {
		return repo.update(new BoardDto(no, title, content));
	}

	@Override
	@Transactional
	public int delete(String no) {
		return repo.delete(no);
	}

	@Override
	public BoardDto selectOne(String no) {
		return repo.selectOne(no);
	}

	@Override
	public List<BoardDto> selectList() {
		return repo.selectList();
	}
}
