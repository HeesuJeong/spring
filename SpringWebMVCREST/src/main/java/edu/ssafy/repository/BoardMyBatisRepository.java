package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;

@Repository
public class BoardMyBatisRepository implements BoardRepository {
	@Autowired
	SqlSession session;

	
	public void insert(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("+" + dto.toString());
		int instret = session.insert("board.insertdto", dto);
		System.out.println("asdasd      " + instret);
	}

	public List<BoardResult> selectList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("board.selectList");
	}

	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		session.update("board.update", dto);
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
		session.delete("board.delete", num);
	}

	public BoardResult selectOne(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectOne",num);
	}
}
