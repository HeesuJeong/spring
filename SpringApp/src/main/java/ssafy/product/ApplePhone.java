package ssafy.product;

public class ApplePhone implements Phone {

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
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCam(Camera cam) {
		this.cam = cam;
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
