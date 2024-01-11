package casting;

public class MainClass2 {

	public static void main(String[] args) {
		// Parent타입에는 Child, Child2 모두 대입 가능

		Parent p1 = new Child();
		p1.method2();
		// p1.method3();
		
		//Parent 타입으로는
		// Child1 의 method2 도, Child2의 method2도 호출 가능
		// method2는 Parent에도 정의되어있지만 Child와 Child2에도 정의된
		// 오버라이딩(재정의)된 메서드이기 때문에 호출가능함. 
		
		// 다형성 적용이 안되었다면?
		Child child = new Child();
		child.method2();
		
		// child/ child2 가 있을 때 이 둘을 Parent의 자식으로 묶어서 
		// 유지보수를 용이하게 한다. 객체지향 다형성의 장점. 
		
		
	}

}
