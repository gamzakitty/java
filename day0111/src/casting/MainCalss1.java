package casting;

public class MainCalss1 {

	public static void main(String[] args) {
		// Promotion이 적용되면 자식클래스에만 정의된 요소 조회 불가능
		
		Parent p = new Child();
		p.method1(); //Parent에만 정의된 메서드
		p.method2(); // 오버라이딩 된 메서드는 타입 상관없이 인스턴스 내 자식쪽 호출
		//p.method3(); // p 타입 변수로는 자식쪽에만 정의된 요소는 호출 불가능
		System.out.println("_____________________________");

		Child c =(Child)p; // 부모타입 변수를 자식타입으로 강제 형변환
		// 자식변수를 부모타입으로 형변환은 안됨.
		
		c.method1();
		c.method2();
		c.method3(); // 형 변환 후에는 자식쪽에만 있는 요소도 호출 가능
		
		System.out.println("_____________________________");

		// 부모타입 자식타입 모두 갖고있다
		
		Child cc = new Child(); // 처음부터 자식타입으로
		
		cc.method3();
		System.out.println("_____________________________");

	}

}
