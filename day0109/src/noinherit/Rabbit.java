package noinherit;

public class Rabbit {

	// �䳢 ���͸� ����ϴ�. 
	// �䳢�� HP, ATK, DEF
	private int hp;
	private int atk;
	private int def;
	
	// �����ڿ��� void �Ķ���ͷ� ���� 3,0,0���� �ʱ�ȭ 
	public Rabbit() {
		this.hp =3;
		this.atk =0;
		this.def =0;
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
	
	
}
