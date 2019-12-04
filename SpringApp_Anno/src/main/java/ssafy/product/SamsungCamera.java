package ssafy.product;

import org.springframework.stereotype.Component;

@Component("samsungcam")
public class SamsungCamera implements Camera {

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		System.out.println("Samsung Camera 찰칵 몰랑이");
	}

}
