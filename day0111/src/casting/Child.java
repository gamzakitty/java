package casting;

public class Child extends Parent {

	
	@Override
	public void method2() {
		System.out.println("자식쪽에서 재정의한 2번 메서드!");
	}
	
	public void method3() {
		System.out.println("자식만 가지고 있는 3번 메서드!");
	}
}
