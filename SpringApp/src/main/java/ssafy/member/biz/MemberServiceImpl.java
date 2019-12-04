package ssafy.member.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ssafy.member.domain.MemberDTO;
import ssafy.member.repo.MemberDAO;

@Component(value="memberser")
@Scope(value="prototype")
public class MemberServiceImpl implements MemberService{
	@Autowired //memberDAO상속받는게 하나라면 안 해줘도 되고
	//여러개명 어떤 DTO 가져올지 지정해야해
	@Qualifier("memberdao")
	MemberDAO dao;
	
	//생성자 안 써도 꼭 선언하쟈
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void memberInsert(String name, String age) {
		// TODO Auto-generated method stub
		dao.memberInsert(new MemberDTO(name,Integer.parseInt(age)));
	}

	@Override
	public void memberUpdate(String name, String age) {
		// TODO Auto-generated method stub
		dao.memberUpdate(new MemberDTO(name,Integer.parseInt(age)));
	}

	@Override
	public void memberDelete(String name) {
		// TODO Auto-generated method stub
		dao.memberDelete(name);
	}

	@Override
	public MemberDTO memberSelectOne(String name) {
		// TODO Auto-generated method stub
		
		return dao.memberSelectOne(name);
	}

	@Override
	public ArrayList<MemberDTO> memberSelectList() {
		// TODO Auto-generated method stub
		return dao.memberSelectList();
	}

}
