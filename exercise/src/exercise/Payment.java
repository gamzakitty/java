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
	
		// ���� �ʿ��Ѱ� �к��ʹϱ� 60000���� ������ �� ã��
		minute = (((int) chaMilli / 60000)%60);
		// ���� 60������ ������ �ð� �������� ��
		hour = (((int) chaMilli / 3600000)%24);
		// �װ� 60���� ������ �� ã�� hour �� �־��ֱ�
		// �ð��� 24�� ������ �� �������� �ð�
		
		int gap =(minute*FEE_PER_MINUTE) + (hour*FEE_PER_HOUR);
		return gap;
	};
	int minute(int i) {
		long chaMilli = Customer.endTime.get(i)- Customer.startTime.get(i);
		
		// ���� �ʿ��Ѱ� �к��ʹϱ� 60000���� ������ �� ã��
		minute = (((int) chaMilli / 60000)%60);
		return minute;
	};
	int hour(int i) {
		long chaMilli = Customer.endTime.get(i)- Customer.startTime.get(i);
		// ���� 60������ ������ �ð� �������� ��
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
