package instanceof_;

public class MainClass {

	public static void main(String[] args) {
		// Human, Student, Cat �ν��Ͻ� ����
		Human h1 = new Human("���ڹ�", 20);
		h1.showInfo();
		
		Student s1 = new Student("�±���", 19);
		s1.showInfo();
		
		Cat c1 = new Cat("������", 26);
		c1.meow();
		
		System.out.println(h1 instanceof Human);
		System.out.println(s1 instanceof Human);

	}

}
