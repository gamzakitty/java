package exercise;

import java.util.*;

public class Management {
	int currnetNo;
	static int nowPersonIndex = 11;
	static ArrayList<Customer> cst = new ArrayList<Customer>(10);
	SeatManage seatMan = new SeatManage();
	Payment pay = new Payment();
	String foodList[][];
	int totalTime = 0;

	Management() {
		for (int n = 0; n < Person.name.size(); n++) {
			Management.cst.add(new Customer(Person.name.get(n), Customer.seatID.get(n), Customer.foodPay.get(n)));
		}
	}

	void setIn() {
		// "1. ����"�� �������� ��, ����Ǵ� �޼ҵ�
		// �̸� �Է�
		System.out.print("�̸��� �Է��ϼ��� : ");
		Scanner scanner = new Scanner(System.in);
		String perName = scanner.nextLine();
		Person.name.add(perName);

		// �¼� ���� ���
		seatMan.print();

		// ����ڿ��� �¼� ��ȣ �Է¹ޱ�
		while (true) {
			System.out.print("���ϴ� �¼��� ������ : ");

			try {
				String seatNum = scanner.nextLine();

				if (seatNum.length() == 1) {
					System.out.println("�¼���ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					Person.name.remove(Person.name.size() - 1);
					System.out.println("�ƹ����ڳ� ġ�� ����ġ����.");
					scanner.next();
					break;
				} else {
					char seatNumFirst = seatNum.charAt(0); // 10�� �ڸ� �� ����
					int firstNum = seatNumFirst - '0'; // ���ڿ��� ������
					firstNum -= 1;

					char seatNumSecond = seatNum.charAt(1); // 1�� �ڸ� �� ����
					int secondNum = seatNumSecond - '0'; // ���ڿ��� ������
					secondNum -= 1;

					// �ڸ��� ���ڿ��� ������ ������ �����ؼ� ArrayList�� ������
					int seatNum1 = Integer.parseInt(seatNum); // ���ڿ��� ����������
					Customer.seatID.add(seatNum1); // �迭�� �߰�
					Customer.foodPay.add(0);// �� �� �ʱⰪ�� 0��
					pay.setCheckln(); // �̶��� �и���, ��¥ ���ڿ� �����Ұ� arraylist�� add ���ִ� �޼ҵ�
					// �Ű������� �ش��ϴ� �ڸ� true false �����ϴ� �޼ҵ�

					if (seatMan.setSeat(firstNum, secondNum) == true) {
						System.out.println("���õǾ����ϴ�. ");
						Calendar cal = Calendar.getInstance(Locale.KOREA);
						System.out.println("���� �ð�: " + cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1)
								+ "�� " + cal.get(Calendar.DATE) + "�� " + cal.get(Calendar.HOUR_OF_DAY) + "�� "
								+ cal.get(Calendar.MINUTE) + "�� " + cal.get(Calendar.SECOND) + "�� ");
						seatMan.c++;
						seatMan.v = 10 - seatMan.c;
						currnetNo += 1;
					} else {
						System.out.println("�̹� ��� �� �Դϴ�.");
						currnetNo += 1;
						// ������ �Է¹��� �̸�, �ڸ��� ����
						Person.name.remove(Person.name.size() - 1);
						Customer.seatID.remove(Customer.seatID.size() - 1);
						Customer.startTime.remove(Customer.startTime.size() - 1);
						Customer.endTime.remove(Customer.endTime.size() - 1);
						Customer.foodPay.remove(Customer.foodPay.size() - 1);
					}
					break;
				}
			} catch (Exception e) {
				System.out.println("���� �¼��Դϴ�.");
				System.out.println("�ƹ����ڳ� ġ�� ����.");
				currnetNo += 1;
				// ������ �Է¹��� �̸�, �ڸ��� ����
				Person.name.remove(Person.name.size() - 1);
				Customer.seatID.remove(Customer.seatID.size() - 1);
				Customer.startTime.remove(Customer.startTime.size() - 1);
				Customer.endTime.remove(Customer.endTime.size() - 1);
				Customer.foodPay.remove(Customer.foodPay.size() - 1);
				scanner.next();
				break;
			}
		}
	}

	void setOut() {

		while (true) {
			System.out.print("�̸��� �Է��ϼ��� : ");
			Scanner scanner = new Scanner(System.in);

			try {
				String outName = scanner.nextLine();
				boolean find = false;
				for (int s = 0; s < Person.name.size(); s++) {
					if (outName.equals(Person.name.get(s))) {
						nowPersonIndex = s;
						find = true;
					}
				}
				if (find == true) {
					Payment.total_Income += Customer.foodPay.get(nowPersonIndex);
					System.out.println("����� �¼� ��ȣ�� " + Customer.seatID.get(nowPersonIndex) + "�Դϴ�");
					System.out.println("�����Ǿ����ϴ�.");
					// �ڸ� t/f ����
					String outNum1 = String.valueOf(Customer.seatID.get(nowPersonIndex));

					char outNumFirst = outNum1.charAt(0); // 10�� �ڸ� �� ����
					int firstNum = outNumFirst - '0'; // ���ڿ��� ������

					char outNumSecond = outNum1.charAt(1); // 1�� �ڸ� �� ����
					int secondNum = outNumSecond - '0'; // ���ڿ��� ������
					firstNum -= 1;
					secondNum -= 1;

					// �Ű������� �ش��ϴ� �ڸ� true false �����ϴ� �޼ҵ�
					seatMan.setSeat(firstNum, secondNum);
					seatMan.v += 1;
					seatMan.c = 10 - seatMan.v;
					Calendar cal = Calendar.getInstance(Locale.KOREA);

					pay.setCheckOut();
					totalTime = totalTime + pay.calculateFee(nowPersonIndex);
					int total = pay.calculateFee(nowPersonIndex) + Customer.foodPay.get(nowPersonIndex);

					System.out.println("\n");
					System.out.println("���� �ð�: " + cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1) + "�� "
							+ cal.get(Calendar.DATE) + "�� " + cal.get(Calendar.HOUR_OF_DAY) + "�� "
							+ cal.get(Calendar.MINUTE) + "�� " + cal.get(Calendar.SECOND) + "�� ");
					System.out.println("��� �ð�: " + pay.hour(nowPersonIndex) + "�ð�" + pay.minute(nowPersonIndex) + "��");
					System.out.println("�ð� ��� ���: " + pay.calculateFee(nowPersonIndex) + "��");
					System.out.println("���� ���: " + Customer.foodPay.get(nowPersonIndex) + "��");
					System.out.println("�� ���: " + total + "��");

					// arraylist �� ����
					Person.name.remove(nowPersonIndex);
					Customer.seatID.remove(nowPersonIndex);
					Customer.foodPay.remove(nowPersonIndex);
					Customer.startTime.remove(nowPersonIndex);
					Customer.endTime.remove(nowPersonIndex);
					break;
				}
				if (find == false) {
					System.out.println("ã�� �̸��� �����ϴ�.");
					break;

				}
			} catch (Exception e) {
				System.out.println(" ");
				break;
			}
		}
	}

	void admin(int i) {

		if (i == 1) // ���� �¼� ���� ����
		{
			System.out.println("[���� �¼� ����]");
			seatMan.print();
			System.out.println("�� �¼� : " + seatMan.c);
			System.out.println("���� �¼� : " + seatMan.v);

		}
		if (i == 2) // ��ü �¼� ���� �ϱ�
		{
			seatMan.clear();
			System.out.println("[���� �¼� ����]");
			seatMan.print();
			System.out.println("�� �¼� : " + seatMan.c);
			System.out.println("���� �¼� : " + seatMan.v);

			for (int f = 0; f < Person.name.size(); f++) {
				Calendar cal = Calendar.getInstance(Locale.KOREA);

				Payment.total_Income += Customer.foodPay.get(f);

				System.out.println(Person.name.get(f) + "��, �¼���ȣ: " + Customer.seatID.get(f));
				System.out.println("����ð� : " + cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1) + "�� "
						+ cal.get(Calendar.DATE) + "�� " + cal.get(Calendar.HOUR_OF_DAY) + "�� "
						+ cal.get(Calendar.MINUTE) + "�� " + cal.get(Calendar.SECOND) + "�� ");
				long mSecondTimeEnd = System.currentTimeMillis();
				Customer.endTime.set(f, mSecondTimeEnd);
				System.out.println("��� �ð�: " + pay.hour(f) + "�ð�" + pay.minute(f) + "��");
				System.out.println("�ð� ��� ���: " + pay.calculateFee(f) + "��");
				System.out.println("���� ���: " + Customer.foodPay.get(f) + "��");
				int total = pay.calculateFee(f) + Customer.foodPay.get(f);
				System.out.println("�� ���: " + total + "��");
				System.out.println("\n");

				totalTime = totalTime + pay.calculateFee(f);
			}

			System.out.println("��� �¼��� �����Ǿ����ϴ�.");
			Person.name.clear();
			Customer.seatID.clear();
			Customer.foodPay.clear();
			Customer.startTime.clear();
			Customer.endTime.clear();
			currnetNo = 0;

		}
		if (i == 3) // �մ� ��Ȳ ����
		{
			System.out.println("�¼� ��ȣ \t\t �̸�");
			System.out.println("-------------------------");
			for (int m = 0; m < Person.name.size(); m++) // �մ� ����Ʈ ���
			{
				System.out.println(Customer.seatID.get(m) + "\t\t" + Person.name.get(m));
			}
		}
		if (i == 4) // �� ���� Ȯ���ϱ�
		{
			int total = Payment.total_Income + totalTime;
			System.out.println("���� ���� : " + Payment.total_Income + "��");
			System.out.println("�ð� ���� : " + totalTime + "��");
			System.out.println("�� ���� : " + total + "��");
		}

	}

	void orderFood() {
		int nowPerson = -1;
		String[][] foodList = { { "1: ������ġ", "5000" }, { "2: ��ġ������", "6500" }, { "3: �ֵ���", "3000" },
				{ "4: ���̽� �Ƹ޸�ī��", "2500" }, { "5: �ݶ�, ���̴�", "1500" }, { "6: ���̽�ũ��", "1200" }, { "7: ����", "800" } };

		System.out.print("�¼���ȣ�� �Է��ϼ��� : ");
		Scanner scanner = new Scanner(System.in);
		String seat = scanner.nextLine();

		for (int i = 0; i < Person.name.size(); i++) {
			// �Է¹��� �¼���ȣ
			String ifIndex = Integer.toString(Customer.seatID.get(i));
			if (seat.equals(ifIndex)) {
				nowPerson = i;
			}
		}

		for (int t = 0; t < 7; t++) // �޴��� ���
		{
			for (int k = 0; k < 2; k++) {
				System.out.print(foodList[t][k] + "\t");
			}
			System.out.print("\n");
		}

		boolean torf = true;

		int paypay = 0;
		while (torf == true) {
			System.out.println("���ϴ� �޴��� ��ȣ�� �� ���� �ϳ����Է��ϼ���(�׸� �ֹ��Ͻ÷��� 99 �Է�):");
			try {
				int foodMenu = scanner.nextInt();

				switch (foodMenu) {
				case 1:
					System.out.println("������ġ ����: 5000��");
					paypay += 5000;
					// int ziguem1 = Customer.foodPaymid.get(nowPerson); // �� ����� �ε����� ã�Ƽ�foodPay�� ��
					// ���ϱ�
					// Customer.foodPaymid.set(nowPerson, ziguem1 + 5000);
					break;
				case 2:
					System.out.println("��ġ������ ����: 6500��");
					paypay += 6500;
					// int ziguem2 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem2 + 6500);
					break;
				case 3:
					System.out.println("�ֵ��� ����: 3000��");
					paypay += 3000;
					// int ziguem3 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem3 + 3000);
					break;
				case 4:
					System.out.println("���̽��Ƹ޸�ī�� ����: 2500��");
					paypay += 2500;
					// int ziguem4 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem4 + 2500);
					break;
				case 5:
					System.out.println("�ݶ�, ���̴� ����: 1500��");
					paypay += 1500;
					// int ziguem5 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem5 + 1500);
					break;
				case 6:
					System.out.println("���̽�ũ�� ����: 1200��");
					paypay += 1200;
					// int ziguem6 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem6 + 1200);
					break;
				case 7:
					System.out.println("���� ����: 800��");
					paypay += 800;
					// int ziguem7 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem7 + 800);
					break;
				case 99:
					torf = false;
					int nowPay = Customer.foodPay.get(nowPerson) + paypay;
					Customer.foodPay.set(nowPerson, nowPay);
					System.out.println("�� �ݾ�:" + paypay + "��");
					break;
				default:
					System.out.println("���� �޴��Դϴ�.");
					break;
				}
			} catch (Exception e) {
				System.out.println("ó������ ���ư��ϴ�.");
				break;
			}
		}

	}
}
