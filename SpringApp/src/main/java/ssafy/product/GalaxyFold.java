package ssafy.product;

public class GalaxyFold implements Phone {

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
