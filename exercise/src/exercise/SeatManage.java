package exercise;

import java.util.ArrayList;

public class SeatManage {
	boolean[][] setTable = new boolean[2][5];
	
	int v=10; // false �ڸ� ����
	int c=10-v; // true �ڸ� ����(�ڸ� ��)

	
	SeatManage() {
		// setTable �迭�� ��� ��Ҹ� false�� �ʱ�ȭ
		int i;
		int j;
		
		
		for (i=0;i<2;i++)
			for (j=0;j<5; j++)
			setTable[i][j]=false;
		

	}
	void clear() {
		// 3.������-> 2. ��ü �¼� �����ϱ� �޴��� �������� �� �����ϴ� �޼ҵ�
		int q;
		int w;
		
		for (q=0;q<2;q++)
			for (w=0;w<5; w++)
			setTable[q][w]=false;
		v =10;
		c = 0;
		
		
	}
	void print() {
		int i;
		int j;

		String seat;
		
		for (i=1;i<3;i++)
			{
				for (j=1;j<6; j++)
			
					if(setTable[i-1][j-1] == true)
					{
						seat="C[" + i+j+ "]";
						System.out.print(seat+"\t");
					}
					else 
					{
						seat="V[" + i+ j+ "]";
						System.out.print(seat+"\t");
						
					}
				System.out.print("\n");
			}
		System.out.println("���� ���� �¼��� " + v +"�� �Դϴ�(V:���¼�/C:���¼�)");
	}
	boolean setSeat(int x, int y) {
	
		// ����ڰ� ������ �ڸ��� setTable���� ã�Ƽ� 
		// ����ִٸ� V->C�� ����, �� �ִٸ� "�̹� ������Դϴ�"���
	
		if(setTable[x][y]==false)
		{
			setTable[x][y] = true;
			return true;
		}
		else
		{
			setTable[x][y] = false;
			return false;
		}	
	}
	void releaseSeat(int x, int y) {
		if(setTable[x][y]==true)
		{
			setTable[x][y] = false;
		}
	// �ױױ�... �ױ� ����,, cst ArrayList���� �Է¹��� �ڸ������� remove
		// outName���� outNum ã�� �׸��� ����
		for(int i =0; i<10; i++)
		{
			int seatNum = 'x' + 'y'; 
			String to = Integer.toString(seatNum);
			if(Customer.seatID.get(i)== seatNum)
			{
				Management.cst.remove(i);
			}
		}
	}
	void arrayMake() { // �̸� �Է�,�ڸ� �Է� �ް� (������ ��) ��̸���Ʈ �����
		// ���������� ��̸���Ʈ��
		// ArrayList<Customer> cst =new ArrayList<Customer>(10);
		// static ArrayList<Integer> seatID = new ArrayList<Integer>(10);
		// static ArrayList<Integer> foodPay = new ArrayList<Integer>(10);
		// static ArrayList<String> name = new ArrayList<String>(10);
		// customer.java �� ��Ŭ���� ���ȴ�� Ŭ���� ��������µ� ���� �Ǳ���. �׷��� ���� �Ϸ����ߴ��Ŷ� ���� �ٸ��� �� �𸣰ڴ�.
	}
	// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rbdi3222&logNo=220699749409
	// �̰� �ذ��ϱ�
	
}
