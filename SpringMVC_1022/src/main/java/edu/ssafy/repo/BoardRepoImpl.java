package edu.ssafy.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BoardDto;

@Repository(value="BoardRepoImpl")
public class BoardRepoImpl implements BoardRepo {
	
	@Autowired
	SqlSession session;
	
	public BoardRepoImpl(){} //넣는게 맞음
	
	@Override
	public int insert(BoardDto dto) {
		System.out.println("INSERT");
		return session.insert("board.insert", dto);
	}

	@Override
	public int update(BoardDto dto) {
		return session.update("board.update", dto);
	}

	@Override
	public int delete(String no) {
		return session.delete("board.delete", no);
	}

	@Override
	public BoardDto selectOne(String no) {
		return session.selectOne("board.selectOne", no);
	}

	@Override
	public List<BoardDto> selectList() {
		System.out.println("list");
		List<BoardDto> list = session.selectList("board.selectlist");
		return list;
	}
	
}
