/*
 * DateUtil.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 17
 * Contact : dhstoalfh9509@gmail.com
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 관련 util
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 17.
 */
public class DateUtil{
	/**
	 * 시스템의 현재 일자를 format 형식으로 변경해서 반환
	 * foramt의 default = yyyy년 MM월 dd일 E요일 HH:mm:ss
	 * 2019. 10. 17., dhstoalfh9509@gmail.com
	 * @param format 날짜를 나타낼 방식
	 * @return 현재 일자를 format 형식으로 변경한 문자열
	 */
	public static String currentDate(String format){
		// format이 비어있을 때
		if("".equals(format) || format == null){
			format = "yyyy년 MM월 dd일 E요일 HH:mm:ss";
		}
		
		// 1. currentTimeMillis() 이용
		// 현재 시간 1000분의 1초의 값으로 반환(ex - 1571297488011)
		long milliseconds = System.currentTimeMillis();
		// ex - Thu Oct 17 16:32:16 KST 2019
		Date defaultDate1 = new Date(milliseconds);
		// format의 형태로 변경
		String currentDate1 = new SimpleDateFormat(format, Locale.KOREA).format(defaultDate1);
		
		// 2. calendar.getTime() 이용
		// 시스템의 날짜와 시간 정보 표현
		// GregorianCalendar 형태로 time, year, month 등 다양한 값들로 표현
		Calendar calendar = Calendar.getInstance();
		// 그 중 time 불러오기(ex - Thu Oct 17 16:32:16 KST 2019)
		Date defaultDate2 = calendar.getTime();
		// format의 형태로 변경
		String currentDate2 = new SimpleDateFormat(format).format(defaultDate2);
        
        // 3. Date() 이용
        // new Date에 인자가 없으면 현재 시간 불러옴
        Date defaultDate3 = new Date();
        String currentDate3 = new SimpleDateFormat(format).format(defaultDate3);
        
		return currentDate1;
	}
	/**
	 * 특정 날짜를 format에 맞게 변경해서 반환
	 * format default = yyyy년 MM월 dd일 E요일 HH:mm:ss
	 * 2019. 10. 17., dhstoalfh9509@gmail.com
	 * @param format 날짜를 나타낼 방식
	 * @param date 특정 날짜
	 * @return 특정 날짜를 format 형식으로 변경한 문자열
	 */
	public static String getFormatDate(String format, Date date){
		// format이 비어있을 때
		if("".equals(format) || format == null){
			format = "yyyy년 MM월 dd일 E요일 HH:mm:ss";
		}
		// 해당 date를 format에 맞게 변경
		return new SimpleDateFormat(format).format(date);
	}
	/**
	 * 현재 날짜에서 특정 일수만큼 건너 뛴 날짜 정보 반환
	 * 2019. 10. 17., dhstoalfh9509@gmail.com
	 * @param days 이동할 날짜 수
	 * @return 현재 날짜에서 days 만큼 건너 뛴 날짜 정보
	 */
	public static Date getDateFromCurrentDate(int days){
		// 시스템의 날짜와 시간 정보 표현
		Calendar calendar = Calendar.getInstance();
		// 현재 날짜 구하기
		calendar.setTime(new Date());
		// 현재 날짜에 days만큼 건너 뛴 날짜
		calendar.add(calendar.DATE, days);
		return calendar.getTime();
	}
	/**
	 * 특정 날짜에서 특정 일수만큼 건너 뛴 날짜 정보 반환
	 * 2019. 10. 17., dhstoalfh9509@xtock.io
	 * @param date 특정 날짜
	 * @param days 이동할 날짜 수
	 * @return 특정 날짜에서 days만큼 건너 뛴 날짜 정보
	 */
	public static Date getDateFromDate(Date date, int days){
		// 시스템의 날짜와 시간 정보 표현
		Calendar calendar = Calendar.getInstance();
		// 특정 날짜로 세팅
		calendar.setTime(date);
		// 특정 날짜에서 days만큼 건너 뛴 날짜
		calendar.add(calendar.DATE, days);
		return calendar.getTime();
	}
	
	public static void main(String...args){
		System.out.println(getFormatDate(null,getDateFromDate(new Date(86400000),428)));
	}
}