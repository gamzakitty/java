package ch3;
import java.util.Scanner;

public class ArrayAccess {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int intArray[] = new int[5];
		int max=0;//현재 가장 큰 수 
		System.out.println("양수 5개를 입력하세요.");
		for(int i =0; i<5; i++) {
			intArray[i] = scanner.nextInt(); // 입력받은 정수를 배열에 저장
			if(intArray[i] > max) // 입력받은 정수가 현재 가장 큰 수보다 크면
				max = intArray[i];
		}
		System.out.print("가장 큰수는 " + max + "입니다.");
		
		scanner.close();
	}
}
