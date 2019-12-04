package ssafy_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mem")
public class MemberImpl implements IMember{
	private String name="홍길동";
	private int age=21;
	private String addr="광산구";
	@Autowired() /* bigmouse 타입에 맞게 객체 생성해서 꽂아준다 */
	private BigMouse big;
	
	
	public void init() {
	System.out.println("init Member");
}
	public void destory() {
		System.out.println("destory Member");
	}
	public MemberImpl() {
		// TODO Auto-generated constructor stub
	}
	public MemberImpl(String name, int age, String addr,BigMouse big) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.big=big;
	}
	public void setBig(BigMouse big) {
		this.big = big;
	}
	public BigMouse getBig() {
		return big;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + ", big=" + big + "]";
	}
	
}
