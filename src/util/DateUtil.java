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
		// **** 참고 ****
		// foramt을 HH로 하면 24시 체계, hh로 하면 12시 체계
		
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
		calendar.add(Calendar.DATE, days);
		
		return calendar.getTime();
	}
	/**
	 * 특정 날짜에서 특정 일수만큼 건너 뛴 날짜 정보 반환
	 * 2019. 10. 17., dhstoalfh9509@gmail.com
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
		calendar.add(Calendar.DATE, days);
		
		return calendar.getTime();
	}
	/**
	 * 종료 날짜 - 시작 날짜의 차를 "hh mm ss"형식의 int[]으로 반환
	 * 시작, 종료 날짜의 string 형식은 "yyyy-MM-dd HH:mm:ss" 형태로 입력
	 * 2019. 10. 18., dhstoalfh9509@gmail.com
	 * @param start String 형식의 시작날짜
	 * @param end String 형식의 끝나는 날짜
	 * @param format start와 end를 입력하는 날짜의 포맷
	 * @return 종료 날짜 - 시작 날짜의 차이를 hh mm ss 형식의 int 배열
	 */
	public static int[] elapsedTime(String start, String end, String format){
		// hh mm ss 형식의 int 배열
		int[] result = new int[3];
		
		// string 형식의 시작 날짜를 long 형식으로
		long startDate = StringToLong(format, start);
		// string 형식의 종료 날짜를 long 형식으로
		long endDate = StringToLong(format, end);
		
		// 종료날짜 - 시작날짜
		long elapsedTime = endDate - startDate;
		// 초 단위의 시간
		elapsedTime /= 1000;
		// 분 단위의 시간
		long gap = elapsedTime / 60;
		
		// 시, 분, 초
		result[0] = (int)gap / 60; //시
		result[1] = (int)gap % 60; //분
		result[2] = (int)(elapsedTime - ((result[0]*60 * 60) + (result[1] * 60))); //초
		
		return result;
	}
	/**
	 * 특정 format으로 된 string 형식의 날짜를 long 타입으로 변환
	 * 2019. 10. 18., dhstoalfh9509@gmail.com
	 * @param format 날짜의 포맷
	 * @param date string 타입의 날짜
	 * @return string 형태를 long으로 변환한 날짜
	 */
	public static long StringToLong(String format, String date){
		// string -> date -> long 타입 순으로 변환해야하므로 stringToDate 함수 이용
		return StringToDate(format,date).getTime();
	}
	/**
	 * 특정 format으로 된 string 형식의 날짜를 date 타입으로 변환
	 * 2019. 10. 18., dhstoalfh9509@gmail.com
	 * @param format 날짜의 포맷
	 * @param date string 타입의 날짜
	 * @return string 형태를 date로 변환한 날짜
	 */
	public static Date StringToDate(String format, String date){
		Date result = null;
		try {
			result = new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String...args){
		for(int i=0; i<3; i++){			
			System.out.println(elapsedTime("2019-10-18 12:30:30", "2019-10-18 14:31:35", "yyyy-MM-dd HH:mm:ss")[i]);
		}
	}
}