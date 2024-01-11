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
		// "1. 입장"을 선택했을 때, 실행되는 메소드
		// 이름 입력
		System.out.print("이름을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String perName = scanner.nextLine();
		Person.name.add(perName);

		// 좌석 상태 출력
		seatMan.print();

		// 사용자에게 좌석 번호 입력받기
		while (true) {
			System.out.print("원하는 좌석을 고르세요 : ");

			try {
				String seatNum = scanner.nextLine();

				if (seatNum.length() == 1) {
					System.out.println("좌석번호를 잘못 입력하셨습니다.");
					Person.name.remove(Person.name.size() - 1);
					System.out.println("아무문자나 치고 엔터치세요.");
					scanner.next();
					break;
				} else {
					char seatNumFirst = seatNum.charAt(0); // 10의 자리 수 선택
					int firstNum = seatNumFirst - '0'; // 문자열을 정수로
					firstNum -= 1;

					char seatNumSecond = seatNum.charAt(1); // 1의 자리 수 선택
					int secondNum = seatNumSecond - '0'; // 문자열을 정수로
					secondNum -= 1;

					// 자리값 문자열로 받은거 정수로 변경해서 ArrayList에 보내기
					int seatNum1 = Integer.parseInt(seatNum); // 문자열을 정수형으로
					Customer.seatID.add(seatNum1); // 배열에 추가
					Customer.foodPay.add(0);// 낼 값 초기값은 0원
					pay.setCheckln(); // 이때의 밀리초, 날짜 문자열 저장할거 arraylist에 add 해주는 메소드
					// 매개변수에 해당하는 자리 true false 변경하는 메소드

					if (seatMan.setSeat(firstNum, secondNum) == true) {
						System.out.println("선택되었습니다. ");
						Calendar cal = Calendar.getInstance(Locale.KOREA);
						System.out.println("입장 시간: " + cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1)
								+ "월 " + cal.get(Calendar.DATE) + "일 " + cal.get(Calendar.HOUR_OF_DAY) + "시 "
								+ cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초 ");
						seatMan.c++;
						seatMan.v = 10 - seatMan.c;
						currnetNo += 1;
					} else {
						System.out.println("이미 사용 중 입니다.");
						currnetNo += 1;
						// 좀전에 입력받은 이름, 자리값 삭제
						Person.name.remove(Person.name.size() - 1);
						Customer.seatID.remove(Customer.seatID.size() - 1);
						Customer.startTime.remove(Customer.startTime.size() - 1);
						Customer.endTime.remove(Customer.endTime.size() - 1);
						Customer.foodPay.remove(Customer.foodPay.size() - 1);
					}
					break;
				}
			} catch (Exception e) {
				System.out.println("없는 좌석입니다.");
				System.out.println("아무문자나 치고 엔터.");
				currnetNo += 1;
				// 좀전에 입력받은 이름, 자리값 삭제
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
			System.out.print("이름을 입력하세요 : ");
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
					System.out.println("당신의 좌석 번호는 " + Customer.seatID.get(nowPersonIndex) + "입니다");
					System.out.println("해제되었습니다.");
					// 자리 t/f 변경
					String outNum1 = String.valueOf(Customer.seatID.get(nowPersonIndex));

					char outNumFirst = outNum1.charAt(0); // 10의 자리 수 선택
					int firstNum = outNumFirst - '0'; // 문자열을 정수로

					char outNumSecond = outNum1.charAt(1); // 1의 자리 수 선택
					int secondNum = outNumSecond - '0'; // 문자열을 정수로
					firstNum -= 1;
					secondNum -= 1;

					// 매개변수에 해당하는 자리 true false 변경하는 메소드
					seatMan.setSeat(firstNum, secondNum);
					seatMan.v += 1;
					seatMan.c = 10 - seatMan.v;
					Calendar cal = Calendar.getInstance(Locale.KOREA);

					pay.setCheckOut();
					totalTime = totalTime + pay.calculateFee(nowPersonIndex);
					int total = pay.calculateFee(nowPersonIndex) + Customer.foodPay.get(nowPersonIndex);

					System.out.println("\n");
					System.out.println("퇴장 시간: " + cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 "
							+ cal.get(Calendar.DATE) + "일 " + cal.get(Calendar.HOUR_OF_DAY) + "시 "
							+ cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초 ");
					System.out.println("사용 시간: " + pay.hour(nowPersonIndex) + "시간" + pay.minute(nowPersonIndex) + "분");
					System.out.println("시간 사용 요금: " + pay.calculateFee(nowPersonIndex) + "원");
					System.out.println("음식 요금: " + Customer.foodPay.get(nowPersonIndex) + "원");
					System.out.println("총 요금: " + total + "원");

					// arraylist 값 삭제
					Person.name.remove(nowPersonIndex);
					Customer.seatID.remove(nowPersonIndex);
					Customer.foodPay.remove(nowPersonIndex);
					Customer.startTime.remove(nowPersonIndex);
					Customer.endTime.remove(nowPersonIndex);
					break;
				}
				if (find == false) {
					System.out.println("찾는 이름이 없습니다.");
					break;

				}
			} catch (Exception e) {
				System.out.println(" ");
				break;
			}
		}
	}

	void admin(int i) {

		if (i == 1) // 현재 좌석 상태 보기
		{
			System.out.println("[현재 좌석 상태]");
			seatMan.print();
			System.out.println("찬 좌석 : " + seatMan.c);
			System.out.println("남은 좌석 : " + seatMan.v);

		}
		if (i == 2) // 전체 좌석 리셋 하기
		{
			seatMan.clear();
			System.out.println("[현재 좌석 상태]");
			seatMan.print();
			System.out.println("찬 좌석 : " + seatMan.c);
			System.out.println("남은 좌석 : " + seatMan.v);

			for (int f = 0; f < Person.name.size(); f++) {
				Calendar cal = Calendar.getInstance(Locale.KOREA);

				Payment.total_Income += Customer.foodPay.get(f);

				System.out.println(Person.name.get(f) + "님, 좌석번호: " + Customer.seatID.get(f));
				System.out.println("퇴장시간 : " + cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 "
						+ cal.get(Calendar.DATE) + "일 " + cal.get(Calendar.HOUR_OF_DAY) + "시 "
						+ cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초 ");
				long mSecondTimeEnd = System.currentTimeMillis();
				Customer.endTime.set(f, mSecondTimeEnd);
				System.out.println("사용 시간: " + pay.hour(f) + "시간" + pay.minute(f) + "분");
				System.out.println("시간 사용 요금: " + pay.calculateFee(f) + "원");
				System.out.println("음식 요금: " + Customer.foodPay.get(f) + "원");
				int total = pay.calculateFee(f) + Customer.foodPay.get(f);
				System.out.println("총 요금: " + total + "원");
				System.out.println("\n");

				totalTime = totalTime + pay.calculateFee(f);
			}

			System.out.println("모든 좌석이 해제되었습니다.");
			Person.name.clear();
			Customer.seatID.clear();
			Customer.foodPay.clear();
			Customer.startTime.clear();
			Customer.endTime.clear();
			currnetNo = 0;

		}
		if (i == 3) // 손님 현황 보기
		{
			System.out.println("좌석 번호 \t\t 이름");
			System.out.println("-------------------------");
			for (int m = 0; m < Person.name.size(); m++) // 손님 리스트 출력
			{
				System.out.println(Customer.seatID.get(m) + "\t\t" + Person.name.get(m));
			}
		}
		if (i == 4) // 총 수입 확인하기
		{
			int total = Payment.total_Income + totalTime;
			System.out.println("음식 수익 : " + Payment.total_Income + "원");
			System.out.println("시간 수익 : " + totalTime + "원");
			System.out.println("총 수익 : " + total + "원");
		}

	}

	void orderFood() {
		int nowPerson = -1;
		String[][] foodList = { { "1: 샌드위치", "5000" }, { "2: 김치볶음밥", "6500" }, { "3: 핫도그", "3000" },
				{ "4: 아이스 아메리카노", "2500" }, { "5: 콜라, 사이다", "1500" }, { "6: 아이스크림", "1200" }, { "7: 생수", "800" } };

		System.out.print("좌석번호를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String seat = scanner.nextLine();

		for (int i = 0; i < Person.name.size(); i++) {
			// 입력받은 좌석번호
			String ifIndex = Integer.toString(Customer.seatID.get(i));
			if (seat.equals(ifIndex)) {
				nowPerson = i;
			}
		}

		for (int t = 0; t < 7; t++) // 메뉴판 출력
		{
			for (int k = 0; k < 2; k++) {
				System.out.print(foodList[t][k] + "\t");
			}
			System.out.print("\n");
		}

		boolean torf = true;

		int paypay = 0;
		while (torf == true) {
			System.out.println("원하는 메뉴의 번호를 한 번에 하나씩입력하세요(그만 주문하시려면 99 입력):");
			try {
				int foodMenu = scanner.nextInt();

				switch (foodMenu) {
				case 1:
					System.out.println("샌드위치 선택: 5000원");
					paypay += 5000;
					// int ziguem1 = Customer.foodPaymid.get(nowPerson); // 그 사람의 인덱스값 찾아서foodPay에 값
					// 더하기
					// Customer.foodPaymid.set(nowPerson, ziguem1 + 5000);
					break;
				case 2:
					System.out.println("김치볶음밥 선택: 6500원");
					paypay += 6500;
					// int ziguem2 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem2 + 6500);
					break;
				case 3:
					System.out.println("핫도그 선택: 3000원");
					paypay += 3000;
					// int ziguem3 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem3 + 3000);
					break;
				case 4:
					System.out.println("아이스아메리카노 선택: 2500원");
					paypay += 2500;
					// int ziguem4 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem4 + 2500);
					break;
				case 5:
					System.out.println("콜라, 사이다 선택: 1500원");
					paypay += 1500;
					// int ziguem5 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem5 + 1500);
					break;
				case 6:
					System.out.println("아이스크림 선택: 1200원");
					paypay += 1200;
					// int ziguem6 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem6 + 1200);
					break;
				case 7:
					System.out.println("생수 선택: 800원");
					paypay += 800;
					// int ziguem7 = Customer.foodPaymid.get(nowPerson);
					// Customer.foodPaymid.set(nowPerson, ziguem7 + 800);
					break;
				case 99:
					torf = false;
					int nowPay = Customer.foodPay.get(nowPerson) + paypay;
					Customer.foodPay.set(nowPerson, nowPay);
					System.out.println("총 금액:" + paypay + "원");
					break;
				default:
					System.out.println("없는 메뉴입니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("처음으로 돌아갑니다.");
				break;
			}
		}

	}
}
