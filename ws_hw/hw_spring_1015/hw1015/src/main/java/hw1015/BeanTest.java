package hw1015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory fac=new AnnotationConfigApplicationContext(ProductConfig.class);
		ProductService ps=(ProductService)fac.getBean("psimpl");
		
		//selectAll
		System.out.println("product 리스트를 출력합니다");
		List<Product> li= ps.selectAll();
		for (Product p : li) {
			System.out.println(p.toString());
		}
		
		//delete
		System.out.println("**********************************");
		System.out.print("삭제하고 싶은 id를 입력하세요: ");
		Scanner sc=new Scanner(System.in);
		String del=sc.next();
		ps.delete(del);
		System.out.println("삭제 후 product 리스트를 출력합니다");
		li= ps.selectAll();
		for (Product p : li) {
			System.out.println(p.toString());
		}
		
		//insert
		System.out.println("**********************************");
		System.out.println("새 상품을 등록합시다. \n한 줄 씩 id,name,price,description을 입력하세요");
		ps.insert(new Product(sc.next(),sc.next(),sc.nextInt(),sc.next()));
		
		System.out.println("등록 후 product 리스트를 출력합니다");
		li= ps.selectAll();
		for (Product p : li) {
			System.out.println(p.toString());
		}
		
		//select
		System.out.println("**********************************");
		System.out.println("id로 검색해보아요. 궁금한 상품의 id를 입력하세요");
		String sel=sc.next();
		Product p=ps.select(sel);
		System.out.println(p.toString());
		
		//update
		System.out.println("**********************************");
		System.out.println("update 검색해보아요. \n상품의 update정보(id,name,price,description)를 입력하세요");
		ps.update(new Product(sc.next(),sc.next(),sc.nextInt(),sc.next()));
		System.out.println("product 리스트 출력합니다(해당 id의 정보가 update되었는지 확인하세요)");
		li= ps.selectAll();
		for (Product p1 : li) {
			System.out.println(p1.toString());
		}
	}

	
	
}
