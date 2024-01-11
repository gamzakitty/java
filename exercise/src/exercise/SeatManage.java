package exercise;

import java.util.ArrayList;

public class SeatManage {
	boolean[][] setTable = new boolean[2][5];
	
	int v=10; // false 자리 개수
	int c=10-v; // true 자리 개수(자리 참)

	
	SeatManage() {
		// setTable 배열의 모든 요소를 false로 초기화
		int i;
		int j;
		
		
		for (i=0;i<2;i++)
			for (j=0;j<5; j++)
			setTable[i][j]=false;
		

	}
	void clear() {
		// 3.관리자-> 2. 전체 좌석 리셋하기 메뉴를 선택했을 때 실행하는 메소드
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
		System.out.println("현재 남은 좌석은 " + v +"석 입니다(V:빈좌석/C:찬좌석)");
	}
	boolean setSeat(int x, int y) {
	
		// 사용자가 선택한 자리를 setTable에서 찾아서 
		// 비어있다면 V->C로 변경, 차 있다면 "이미 사용중입니다"출력
	
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
	// 그그그... 그그 뭐냐,, cst ArrayList에서 입력받은 자리값으로 remove
		// outName으로 outNum 찾기 그리고 연결
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
	void arrayMake() { // 이름 입력,자리 입력 받고 (입장할 때) 어레이리스트 만들기
		// 내가만들어둔 어레이리스트들
		// ArrayList<Customer> cst =new ArrayList<Customer>(10);
		// static ArrayList<Integer> seatID = new ArrayList<Integer>(10);
		// static ArrayList<Integer> foodPay = new ArrayList<Integer>(10);
		// static ArrayList<String> name = new ArrayList<String>(10);
		// customer.java 에 이클립스 제안대로 클래스 만ㄴ들었는데 뭐가 되긴함. 그러나 내가 하려고했던거랑 뭐가 다른지 잘 모르겠다.
	}
	// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rbdi3222&logNo=220699749409
	// 이거 해결하기
	
}
