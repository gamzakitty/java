package hetero;

public class MainClass {

	public static void main(String[] args) {
		// 기본형 자료형으로 만든 배열 예시
		// 다른 자료형을 넣을 수 없음
		
		
		// A 자료형의 힙 주소를 배열로 저장가능한 배열 생성
		A[] aArr = new A[2];
		
		A a1 = new A();
		A a2 = new A();
		
		aArr[0] = a1;
		aArr[1] = a2;
		
		Object[] oArr = new Object[2];
		
		B b1 = new B();
		oArr[0] = b1;
		oArr[1] = a2;
		
		oArr[1] = 100;

	}

}
