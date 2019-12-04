package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.repogitory.MemRepo;

@Service("MemServiceImpl")
public class MemServiceImpl implements MemService {
	@Autowired
	@Qualifier("MemMybatisRepoImpl")
	private MemRepo repo;
	
	
	public MemServiceImpl() {
		// TODO Auto-generated constructor stub
	
	}
	
	@Override
	@Transactional()
	public void insert(String id, String pw, String name, String email) {
		// TODO Auto-generated method stub
		repo.insert(new Member(id,pw,name,email));
		//repo.insert(new Member("1",pw,name,email));
		//repo.insert(new Member("2",pw,name,email));
		//repo.insert(new Member("2",pw,name,email));
		//repo.insert(new Member("3",pw,name,email));
	}

	@Override
	@Transactional()
	public void update(String id, String pw, String name, String email) {
		// TODO Auto-generated method stub
		repo.update(new Member(id,pw,name,email));
	}

	@Override
	@Transactional()
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		return repo.selectOne(id);
	}

	@Override
	public List<Member> selectList() {
		// TODO Auto-generated method stub
		return repo.selectList();
	}

}
