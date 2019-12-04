package edu.ssafy.repo;

import java.util.List;

import edu.ssafy.dto.BoardDto;

public interface BoardRepo {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(String no);
	public BoardDto selectOne(String no);
	public List<BoardDto> selectList();
}
