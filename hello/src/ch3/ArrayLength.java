package ch3;
import java.util.Calendar;
import java.util.*; 
import java.text.*;


public class ArrayLength {
	public static void main(String[] args) {
		long mSecondTime = System.currentTimeMillis();
		System.out.println(mSecondTime);
		
		// �� �� �� �� �� �� ���ϱ�
		// ǥ�� �ð��븦 �����ϰ� ��¥ ��������
		//DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA); 
		Calendar cal = Calendar.getInstance(Locale.KOREA); 
		// nal = df.format(cal.getTime());
		//TimeZone jst = TimeZone.getTimeZone ("JST"); 
		// �־��� �ð��뿡 �°� ���� �ð����� �ʱ�ȭ�� GregorianCalender ��ü�� ��ȯ.
		//Calendar now = Calendar.getInstance(Locale.KOREA); 
		System.out.println ( cal.get ( Calendar.YEAR ) + "�� " + ( cal.get ( Calendar.MONTH ) + 1 ) + "�� " + cal.get ( Calendar.DATE ) + "�� " + cal.get ( Calendar.HOUR_OF_DAY ) + "�� " + cal.get ( Calendar.MINUTE ) + "�� " + cal.get ( Calendar.SECOND ) + "�� " );
		
		
	}
}
