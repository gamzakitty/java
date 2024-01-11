package inheri;

public class Monster {

	
	// ��� ���� Ŭ������ �θ�Ÿ������ ����� Ŭ����
	private String name; // ������ Ư���� ���� ������ �ĺ��ϱ� ���� ����
	private int hp;
	private int atk;
	private int def;
	private int exp; // ����ġ�� ���ͺ��� �� �ٸ��� ������ �������� ����

	
	// �θ��� �����ڷ� �ʱ�ȭ�� �� � ���Ͱ� �������� ������ �� �� ��������
	// �������� �ƴ� �ڽ��ʿ��� �Է¹��� �ڷḦ �����ϵ��� ������ ����
	
	public Monster(String name, int hp, int atk, int def, int exp) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getAtk() {
		return atk;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public int getDef() {
		return def;
	}


	public void setDef(int def) {
		this.def = def;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
