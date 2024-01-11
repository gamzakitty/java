package instanceof_;

public class MainClass {

	public static void main(String[] args) {
		// Human, Student, Cat 인스턴스 생성
		Human h1 = new Human("김자바", 20);
		h1.showInfo();
		
		Student s1 = new Student("태국인", 19);
		s1.showInfo();
		
		Cat c1 = new Cat("조계현", 26);
		c1.meow();
		
		System.out.println(h1 instanceof Human);
		System.out.println(s1 instanceof Human);

	}

}
