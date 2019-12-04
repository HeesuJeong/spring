package edu.ssafy.repogitory;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;

@Repository("MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {
	//디비 연결이 이걸로 끄읕
	@Autowired
	private SqlSession session;
	
	
	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		//member_sql.xml에 선언한 insertMember명령어 사용하겠다. 파라미터로 m객체 넣겟다.
		session.insert("member.insertMember",m);
		
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		Member m = session.selectOne("member.selectMember",id); 
		//리턴타입이 객체 => 받는게 Member이므로 자동으로 type캐스팅
		return m;
	}

	@Override
	public List<Member> selectList() {
		// TODO Auto-generated method stub
		List<Member> selectList=session.selectList("member.selectMembers");
		return selectList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
