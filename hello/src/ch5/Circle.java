package ch5;

class Shape {
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println("Shape");
	}
}

public class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
	public static void main(String[] args) {
		Shape a = new Shape();
		a.paint();
		Shape b = new Circle();
		b.paint();
	}
}
