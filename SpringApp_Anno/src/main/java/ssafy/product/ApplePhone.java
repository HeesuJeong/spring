package ssafy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="apple")
public class ApplePhone implements Phone {
	@Autowired /* 카메라 상속받은 클래스 두개 이상이면 어떤 놈 꽂을지 몰라서 나중에 에러나 */
	@Qualifier("cannoncam")
	private Camera cam;
	private int price;
	public ApplePhone() {
		// TODO Auto-generated constructor stub
	}
	public ApplePhone(Camera cam, int price) {
		super();
		this.cam = cam;
		this.price = price;
	}
	
	public void init() {
		
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("apple 폰 hi");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("apple 폰 bye");
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		this.cam.takePicture();
	}
	@Override
	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}


	
}
