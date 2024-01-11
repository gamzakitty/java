package exercise;
import java.util.Calendar;
import java.util.Locale;

public class Payment {
	static int total_Income;
	final int FEE_PER_MINUTE=100;
	final int FEE_PER_HOUR=5000;
	static int minute;
	static int hour;
	
	int calculateFee(int i) {
		long chaMilli = Customer.endTime.get(i)- Customer.startTime.get(i);
	
		// 내가 필요한건 분부터니까 60000으로 나눠서 분 찾고
		minute = (((int) chaMilli / 60000)%60);
		// 분을 60분으로 나누면 시간 나머지는 분
		hour = (((int) chaMilli / 3600000)%24);
		// 그걸 60으로 나눠서 시 찾고 hour 에 넣어주기
		// 시간을 24로 나누면 일 나머지는 시간
		
		int gap =(minute*FEE_PER_MINUTE) + (hour*FEE_PER_HOUR);
		return gap;
	};
	int minute(int i) {
		long chaMilli = Customer.endTime.get(i)- Customer.startTime.get(i);
		
		// 내가 필요한건 분부터니까 60000으로 나눠서 분 찾고
		minute = (((int) chaMilli / 60000)%60);
		return minute;
	};
	int hour(int i) {
		long chaMilli = Customer.endTime.get(i)- Customer.startTime.get(i);
		// 분을 60분으로 나누면 시간 나머지는 분
				hour = (((int) chaMilli / 3600000)%24);
		return hour;
	}
	void setCheckln() {
		long mSecondTime = System.currentTimeMillis();
		Customer.startTime.add(mSecondTime);
		Customer.endTime.add(mSecondTime);
	};
	void setCheckOut() {
		long mSecondTimeEnd = System.currentTimeMillis();
		Customer.endTime.set(Management.nowPersonIndex,mSecondTimeEnd); // 
		
	};
}
