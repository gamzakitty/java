package exercise;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Management method = new Management();

		while (true) {
			System.out.println("[LaLaLa StudyRoom]");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. �����ֹ�");
			System.out.println("4. ������");
			System.out.println("5. ����");
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
					// ������ �޴��� ����
					System.out.println("1. ���� �¼� ���� ����");
					System.out.println("2. ��ü �¼� ���� �ϱ�");
					System.out.println("3. �մ� ��Ȳ ����");
					System.out.println("4. �� ���� Ȯ���ϱ�");
					System.out.print("-->");

					int adminMenu = scanner.nextInt();
					method.admin(adminMenu);
					continue;
				}
				if (menuInt == 5) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				} else {
					System.out.println("�ùٸ� ���ڸ� �Է� �� �ּ���.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է��ϼ̽��ϴ�.");
				scanner.next();
				continue;
			}
		}
	}
}
