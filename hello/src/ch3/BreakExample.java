package ch3;
import java.util.Scanner;

public class BreakExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit 를 입력하면 자동으로 종료됩니다. ");
		while( true ){
			System.out.print(">>");
			String text = scanner.nextLine();
			if(text.equals("exit")) // "exit"이 입력되면 반복 종료
				break;
		}
		System.out.println("종료합니다.");
		scanner.close();
	}
}
