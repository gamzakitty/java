package casting;

public class MainClass2 {

	public static void main(String[] args) {
		// ParentŸ�Կ��� Child, Child2 ��� ���� ����

		Parent p1 = new Child();
		p1.method2();
		// p1.method3();
		
		//Parent Ÿ�����δ�
		// Child1 �� method2 ��, Child2�� method2�� ȣ�� ����
		// method2�� Parent���� ���ǵǾ������� Child�� Child2���� ���ǵ�
		// �������̵�(������)�� �޼����̱� ������ ȣ�Ⱑ����. 
		
		// ������ ������ �ȵǾ��ٸ�?
		Child child = new Child();
		child.method2();
		
		// child/ child2 �� ���� �� �� ���� Parent�� �ڽ����� ��� 
		// ���������� �����ϰ� �Ѵ�. ��ü���� �������� ����. 
		
		
	}

}
