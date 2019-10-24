/*
 * CalculateUtil.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 22
 * Contact : dhstoalfh9509@gmail.com
 */
package util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
	private static String removeComma(String value){
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
			value = removeComma(value);
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
	 * 두 BigDecimal 더하기
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param first 합할 첫 번째 문자
	 * @param second 합할 두 번째 문자
	 * @return 두 BigDecimal의 합
	 */
	public static BigDecimal add(BigDecimal first, BigDecimal second){
		return first.add(second);
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
	 * 두 BigDecimal 빼기
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param first 뺄 첫 번째 문자
	 * @param second 뺄 두 번째 문자
	 * @return 두 BigDecimal의 차
	 */
	public static BigDecimal subtract(BigDecimal first, BigDecimal second){
		return first.subtract(second);
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
	 * 두 BigDecimal 나누기
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param first 나눌 첫 번째 문자
	 * @param second 나눌 두 번째 문자
	 * @return 두 BigDecimal의 나눈 값
	 */
	public static BigDecimal divide(BigDecimal first, BigDecimal second){
		// 소수점은 6자리까지, 버림처리
		return first.divide(second, 6, BigDecimal.ROUND_DOWN);
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
	 * 두 BigDecimal 곱하기
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param first 곱할 첫 번째 문자
	 * @param second 곱할 두 번째 문자
	 * @return 두 BigDecimal의 곱
	 */
	public static BigDecimal multiply(BigDecimal first, BigDecimal second){
		return first.multiply(second);
	}
	/**
	 * double 타입 콤마 추가(소수점 7자리 - 6자리에서 버림처리 하려고)
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param value 콤마 추가할 수
	 * @return 콤마 추가된 string 타입의 숫자
	 */
	public static String addCommaDouble(Double value){
		String result = "";
		// 콤마 추가 & 소수점 7자리
		DecimalFormat formatter = new DecimalFormat("###,###.#######");
		result = formatter.format(value);
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
		if(!Util.isEmptyOrWhiteSpace(value)){
			Double doubleNum = Double.valueOf(value);
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
		return addCommaString(value.toString());
	}
	/**
	 * 소수점 자리 수 6자리, 버림처리
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param value 소수점 자리 표현할 수 
	 * @return 소수점 6자리의 숫자
	 */
	public static String moveDecimalPoint(String value){
		String result = "";
		if(!Util.isEmptyOrWhiteSpace(value)){
			result = getDecimal(value).setScale(6, RoundingMode.DOWN).toString();
		}
		return result;
	}
	/**
	 * 양수 -> 음수 / 음수 -> 양수로 전환
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param value 전환할 숫자
	 * @return value의 반대 값
	 */
	public static BigDecimal negate(BigDecimal value) {
		return value.negate(MathContext.DECIMAL64);
	}
	/**
	 * bigDecimal 타입 value의 퍼센트 금액을 반환
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param value 퍼센트 산출할 원가
	 * @param percent 퍼센트 백분율
	 * @return 퍼센트 금액 반환
	 */
	public static BigDecimal getPercentValue(BigDecimal value, BigDecimal percent){
		return multiply(value, percent.movePointLeft(2));
	}
	/**
	 * 숫자형 문자열 value의 퍼센트 금액을 반환
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param value 퍼센트 산출할 원가
	 * @param percent 퍼센트 백분율
	 * @return 퍼센트 금액 반환
	 */
	public static String getPercentValue(String value, String percent){
		return multiply(value, getDecimal(percent).movePointLeft(2).toString());
	}
	/**
	 * 부동 소수점 자리 제한
	 * 2019. 10. 24., dhstoalfh9509@gmail.com
	 * @param value 제한할 숫자
	 * @param position 소수점 자리수
	 * @param type 기준 타입
	 * @return 소수점 자리 제한한 숫자
	 */
	public static String scale(String value, int position, decimalType type){
		String result = "";
		if(!Util.isEmptyOrWhiteSpace(value)){
			BigDecimal decimalValue = getDecimal(value);
			if(type == decimalType.UP){
			// 올림
				result = decimalValue.setScale(position, RoundingMode.UP).toString();
			} else if(type == decimalType.DOWN){
			// 내림(버림)
				result = decimalValue.setScale(position, RoundingMode.DOWN).toString();
			} else if(type == decimalType.HALF_UP){
			// 반올림(5이상 올림)
				result = decimalValue.setScale(position, RoundingMode.HALF_UP).toString();
			} else if(type == decimalType.HALF_DOWN){
			// 반내림(5초과 올림)
				result = decimalValue.setScale(position, RoundingMode.HALF_DOWN).toString();
			}
		}
		return result;
	}
	
	// https://cofs.tistory.com/339
	public static void main(String...args){
		System.out.println(addCommaString(moveDecimalPoint(subtract("98765.12345678", "1234"))));
		System.out.println(negate(getDecimal("-123.456")));
		System.out.println(getPercentValue("12345","12"));
	}
}
