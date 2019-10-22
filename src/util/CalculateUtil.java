/*
 * CalculateUtil.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 22
 * Contact : dhstoalfh9509@gmail.com
 */
package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * 계산 관련 util
 * 소수점은 6자리 버림 처리 & 콤마 추가
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 22.
 */
public class CalculateUtil {
	/**
	 * 소수점 타입
	 * UP = 올림, DOWN = 버림, HALF_UP = 반올림(5이상 올림), HALF_DOWN=반내림(5이하 내림)
	 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
	 * @since  2019. 10. 22.
	 */
	public enum decimalType{
		UP,
		DOWN,
		HALF_UP,
		HALF_DOWN
	}
	
	/**
	 * 콤마 여부 확인 후 콤마가 있으면 제거
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 문자열
	 * @return
	 */
	private static String replaceComma(String value){
		String result = value;
		if(Util.isEmptyOrWhiteSpace(value)){
			return "0";
		} else if(value.contains(",")){
			result = value.replace(",", "");
		}
		return result;
	}
	/**
	 * string 을 BigDecimal 타입으로 전환
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 문자열
	 * @return
	 */
	public static BigDecimal getDecimal(String value){
		BigDecimal result = null;
		if(!Util.isEmptyOrWhiteSpace(value)){
			// 콤마가 있으면 콤마 제거
			value = replaceComma(value);
			// MathContext.DECIMAL64 = Decimal64 형식, 16자리 수(소수점포함), HALF_EVEN(가까운 쪽으로 올림)의 정밀도 설정
			// result = new BigDecimal(value, MathContext.DECIMAL64);
			result = new BigDecimal(value);
		}else {
			result = new BigDecimal("0");
		}
		return result;
	}
	/**
	 * 두 string 더하기
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param first 합할 첫 번째 문자
	 * @param second 합할 두 번째 문자
	 * @return 두 string의 합
	 */
	public static String add(String first, String second){
		return getDecimal(first).add(getDecimal(second)).toString();
	}
	/**
	 * 두 string 빼기
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param first 뺄 첫 번째 문자
	 * @param second 뺄 두 번째 문자
	 * @return 두 string의 차
	 */
	public static String subtract(String first, String second){
		return getDecimal(first).subtract(getDecimal(second)).toString();
	}
	/**
	 * 두 string 나누기
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param first 나눌 첫 번째 문자
	 * @param second 나눌 두 번째 문자
	 * @return 두 string의 나눈 값
	 */
	public static String divide(String first, String second){
		// 소수점은 6자리까지, 버림처리
		return getDecimal(first).divide(getDecimal(second), 6, BigDecimal.ROUND_DOWN).toString();
	}
	/**
	 * 두 string 곱하기
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param first 곱할 첫 번째 문자
	 * @param second 곱할 두 번째 문자
	 * @return 두 string의 곱
	 */
	public static String multiply(String first, String second){
		return getDecimal(first).multiply(getDecimal(second)).toString();
	}
	/**
	 * double 타입 콤마 추가(소수점 7자리 - 6자리에서 버림처리 하려고)
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 콤마 추가할 수
	 * @return 콤마 추가된 string 타입의 숫자
	 */
	public static String addCommaDouble(Double value){
		String result = "";
		if(StringUtils.isNumeric(value.toString())){			
			// 콤마 추가 & 소수점 7자리
			DecimalFormat formatter = new DecimalFormat("###,###.#######");
			result = formatter.format(value);
		}
		return result;
	}
	/**
	 * string 타입 콤마 추가
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 콤마 추가할 문자열
	 * @return 콤마 추가된 string 타입의 숫자
	 */
	public static String addCommaString(String value){
		String result = "";
		if(!Util.isEmptyOrWhiteSpace(value) || StringUtils.isNumeric(value)){			
			// https://codeday.me/ko/qa/20190314/65346.html
			Double doubleNum = Double.valueOf(value);
			//Double doubleNum2 = Double.parseDouble(value);
			result = addCommaDouble(doubleNum);
		}
		return result;
	}
	/**
	 * bigDecimal 타입 콤마 추가
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 콤마 추가할 수
	 * @return 콤마 추가된 string 타입의 숫자
	 */
	public static String addCommaBigDecimal(BigDecimal value){
		String result = "";
		if(StringUtils.isNumeric(value.toString())){
			result = addCommaString(value.toString());
		}
		return result;
	}
	// https://cofs.tistory.com/339
	public static void main(String...args){
		System.out.println(add("123", "456"));
		System.out.println(subtract("456", "123"));
		System.out.println(divide("300", "7"));
		System.out.println(multiply("3", "50"));
		
		System.out.println(addCommaString("1234.123"));
	}
}
