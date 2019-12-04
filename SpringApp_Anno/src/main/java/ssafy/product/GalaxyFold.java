package ssafy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("galaxy")

public class GalaxyFold implements Phone {
	@Autowired
	@Qualifier("samsungcam") /* autowired할때 붙을 얘가 여러개이면 어떤 cam붙일지 지정하는 것 */
	private Camera cam;
	private int price;
	
	public GalaxyFold() {
		// TODO Auto-generated constructor stub
	}
	
	public GalaxyFold(Camera cam, int price) {
		super();
		this.cam = cam;
		this.price = price;
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("galaxy hi");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("galaxy bye");
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
