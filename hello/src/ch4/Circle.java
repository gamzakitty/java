package ch4;

public class Circle {
	int radius;
	String name;

	public Circle() { //매개변수 없는 생성자
		radius = 1; name = ""; //필드 초기화
	}
	public Circle(int r, String n) {
		radius = r; name = n; //매개변수로 필드 초기화
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		Circle pizza = new Circle(10, "자바피자"); //객체 생성. 반지름은 10으로 초기화 이름을 자바피자로 초기화
		
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Circle donut = new Circle(); //객체 생성. 반지름을 1으로 이름을 ""으로 초기화
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name +"의 면적은 " + area);
	}
}