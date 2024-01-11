package exercise;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Management method = new Management();

		while (true) {
			System.out.println("[LaLaLa StudyRoom]");
			System.out.println("1. 입장");
			System.out.println("2. 퇴장");
			System.out.println("3. 음식주문");
			System.out.println("4. 관리자");
			System.out.println("5. 종료");
			System.out.print("-->");

			try {

				int menuInt = scanner.nextInt();

				if (menuInt == 1) {
					method.setIn();
					continue;
				}
				if (menuInt == 2) {
					method.setOut();
					continue;
				}
				if (menuInt == 3) {
					method.orderFood();
					continue;
				}
				if (menuInt == 4) {
					// 관리자 메뉴가 보임
					System.out.println("1. 현재 좌석 상태 보기");
					System.out.println("2. 전체 좌석 리셋 하기");
					System.out.println("3. 손님 현황 보기");
					System.out.println("4. 총 수입 확인하기");
					System.out.print("-->");

					int adminMenu = scanner.nextInt();
					method.admin(adminMenu);
					continue;
				}
				if (menuInt == 5) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("올바른 숫자를 입력 해 주세요.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("문자를 입력하셨습니다.");
				scanner.next();
				continue;
			}
		}
	}
}
