package ch3;
import java.util.Calendar;
import java.util.*; 
import java.text.*;


public class ArrayLength {
	public static void main(String[] args) {
		long mSecondTime = System.currentTimeMillis();
		System.out.println(mSecondTime);
		
		// 년 월 일 시 분 초 구하기
		// 표준 시간대를 지정하고 날짜 가져오기
		//DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA); 
		Calendar cal = Calendar.getInstance(Locale.KOREA); 
		// nal = df.format(cal.getTime());
		//TimeZone jst = TimeZone.getTimeZone ("JST"); 
		// 주어진 시간대에 맞게 현재 시각으로 초기화된 GregorianCalender 객체를 반환.
		//Calendar now = Calendar.getInstance(Locale.KOREA); 
		System.out.println ( cal.get ( Calendar.YEAR ) + "년 " + ( cal.get ( Calendar.MONTH ) + 1 ) + "월 " + cal.get ( Calendar.DATE ) + "일 " + cal.get ( Calendar.HOUR_OF_DAY ) + "시 " + cal.get ( Calendar.MINUTE ) + "분 " + cal.get ( Calendar.SECOND ) + "초 " );
		
		
	}
}
