package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;

public interface BoardService {
	public void insert(String num,String title,String content) throws Exception;
	public List<BoardResult> selectList() throws Exception;
	public void update(String num,String title,String content);
	public void delete(String num);
	public BoardResult selectOne(String num);
}
