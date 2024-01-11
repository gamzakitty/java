package inheri;

public class MainClass1 {

	public static void main(String[] args) {
		// 전사 생성
		Warrior w1 = new Warrior();
		w1.Warrior("주여노");
		// 상태 조회
		w1.showStatus();
		// 토끼 생성
		Rabbit r1 = new Rabbit();
		
		// 전사와 교전 2회
		w1.hunt(r1);
		w1.hunt(r1);
		
		// 상태 조회
		w1.showStatus();
		
		Rat t1 = new Rat();
		
		w1.hunt(t1);
		w1.hunt(t1);
		w1.hunt(t1);
		
		w1.showStatus();
	}

}
