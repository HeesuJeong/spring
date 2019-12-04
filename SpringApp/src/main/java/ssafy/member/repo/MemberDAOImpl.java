package ssafy.member.repo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ssafy.member.domain.MemberDTO;

@Component(value="memberdao")
public class MemberDAOImpl implements MemberDAO{

	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void memberInsert(MemberDTO mem) {
		// TODO Auto-generated method stub
		System.out.println("멤버추가");
	}

	@Override
	public void memberUpdate(MemberDTO mem) {
		// TODO Auto-generated method stub
		System.out.println("멤버수정");
	}

	@Override
	public void memberDelete(String name) {
		// TODO Auto-generated method stub
		System.out.println("멤버삭제");
	}

	@Override
	public MemberDTO memberSelectOne(String name) {
		// TODO Auto-generated method stub
		System.out.println("멤버 one 조회");
		return null;
	}

	@Override
	public ArrayList<MemberDTO> memberSelectList() {
		// TODO Auto-generated method stub
		System.out.println("멤버 list 조회");
		return null;
	}

}
