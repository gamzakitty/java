package casting;

public class MainCalss1 {

	public static void main(String[] args) {
		// Promotion�� ����Ǹ� �ڽ�Ŭ�������� ���ǵ� ��� ��ȸ �Ұ���
		
		Parent p = new Child();
		p.method1(); //Parent���� ���ǵ� �޼���
		p.method2(); // �������̵� �� �޼���� Ÿ�� ������� �ν��Ͻ� �� �ڽ��� ȣ��
		//p.method3(); // p Ÿ�� �����δ� �ڽ��ʿ��� ���ǵ� ��Ҵ� ȣ�� �Ұ���
		System.out.println("_____________________________");

		Child c =(Child)p; // �θ�Ÿ�� ������ �ڽ�Ÿ������ ���� ����ȯ
		// �ڽĺ����� �θ�Ÿ������ ����ȯ�� �ȵ�.
		
		c.method1();
		c.method2();
		c.method3(); // �� ��ȯ �Ŀ��� �ڽ��ʿ��� �ִ� ��ҵ� ȣ�� ����
		
		System.out.println("_____________________________");

		// �θ�Ÿ�� �ڽ�Ÿ�� ��� �����ִ�
		
		Child cc = new Child(); // ó������ �ڽ�Ÿ������
		
		cc.method3();
		System.out.println("_____________________________");

	}

}
