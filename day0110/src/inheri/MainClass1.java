package inheri;

public class MainClass1 {

	public static void main(String[] args) {
		// ���� ����
		Warrior w1 = new Warrior();
		w1.Warrior("�ֿ���");
		// ���� ��ȸ
		w1.showStatus();
		// �䳢 ����
		Rabbit r1 = new Rabbit();
		
		// ����� ���� 2ȸ
		w1.hunt(r1);
		w1.hunt(r1);
		
		// ���� ��ȸ
		w1.showStatus();
		
		Rat t1 = new Rat();
		
		w1.hunt(t1);
		w1.hunt(t1);
		w1.hunt(t1);
		
		w1.showStatus();
	}

}
