package inheri;

// 해당 클래스의 인스턴스는 Monster 타입 변수에도 저장할 수 있음.
public class Rabbit extends Monster {

	public Rabbit() {
		// 부모인 Monster에 이름, 체력, 공격력, 방어력, 경험치 전
		super("토끼", 3, 0, 0, 5);
	}
}
