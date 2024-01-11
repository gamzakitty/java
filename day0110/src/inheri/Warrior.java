package inheri;

public class Warrior {

	// 정보 은닉 적용
	private String id;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	
	// 생성자 만들기  id 만 입력받고
	// 나머지 필드 - 체력 20 공격력 3 방어 1 경험치 0으로 초기화 
	
	public void Warrior(String id) {
		this.id = id;
		this.hp = 20;
		this.atk =3;
		this.def = 1;
		this.exp = 0;
	}
	
	public void showStatus() {
		System.out.println("아이디 : " + this.id);
		System.out.println("체력 : " + this.hp);
		System.out.println("공격력 : " + this.atk);
		System.out.println("방어력 : " + this.def);
		System.out.println("획득경험치 : " + this.exp);
		System.out.println("-----------------");
	}
	
	
	// 파라미터로 모든 몬스터의 부모타입인 Monster 인스턴스를 요구하면
	// 다형성 원리에 의해서 상속받은 모든 몬스터를 다 대입할 수 있습니다. 
	public void hunt(Monster monster) {
		
		if(monster.getHp() <= 0) {
			System.out.println(monster.getName() +"은(는) 이미 죽어서 교전할 수 없습니다. ");
			return;
		}
		// 다음 공격으로 몬스터가 죽는 경우
		if(monster.getHp() - (this.atk - monster.getDef())<= 0)  {
			// 경험치 부여
			monster.setHp(0);
			System.out.println(monster.getName() + "이(가) 죽었습니다. ");
			this.exp += monster.getExp();
		}else {
		// 다음 공격으로 몬스터가 죽지 않아서 반격을 받는 경우
			// 몬스터 체력을 (내 공격력 - 몬스터방어력)만큼 차감하고
			monster.setHp(this.atk -= monster.getDef());
			
			// 내 체력을 (몬스터 공격력 - 내 방어력) 만큼 차감하고
			this.hp -= monster.getAtk() - this.def;
			// **이가 반격했습니다. 
			System.out.println(monster.getName() + "이(가) 반격했습니다.");
		}
	}
}
