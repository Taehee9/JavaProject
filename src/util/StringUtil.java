/*
 * StringUtil.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 21
 * Contact : dhstoalfh9509@gmail.com
 */
package util;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils 메소드 사용
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 21.
 */
public class StringUtil{
	
	public static void main(String...args){
		// 기본 문자열
		String defaultS;
		// 비교 문자열
		String compareS = null;
		
		defaultS = "hello java";
		// 해당 글자 포함 여부
		System.out.println("contains java - " + defaultS + " : " + defaultS.contains("java"));
		// 첫글자 대문자화
		System.out.println("Capitalize - " + defaultS + " : " + StringUtils.capitalize(defaultS));
		// 설정한 문자를 추가해서 설정한 문자열의 길이로 만들기
		System.out.println("14글자 만들기 - " + defaultS + " : "  + StringUtils.center(defaultS, 14, '#'));
		// 공백 있으면 공백 제거
		System.out.println("공백 제거 - " + defaultS + " : "  + StringUtils.deleteWhitespace(defaultS));
		System.out.println();
		
		// null이면 "" , null 아니면 해당 문자열 반환
		System.out.println("null 여부 - " + compareS + " : "  + StringUtils.defaultString(compareS));
		System.out.println("null 여부 - " + defaultS + " : "  + StringUtils.defaultString(defaultS));
		// 띄어쓰기, 공백, null이면 입력한 문자열 반환
		System.out.println("null 일 때 - " + defaultS + " : "  + StringUtils.defaultIfBlank(defaultS, "hihi"));
		System.out.println("null 일 때 - " + compareS + " : "  + StringUtils.defaultIfBlank(compareS, "hihi"));
		System.out.println();
		
		// 대소문자 신경안쓰고 비교
		compareS = "HELLO JAVA";
		System.out.println("대소문자 x 비교 - " + defaultS + " / " + compareS + " : "  + StringUtils.equalsIgnoreCase(defaultS, compareS));
		// 비교해서 차이점
		compareS = "hello JAVA";
		System.out.println("비교 - " + defaultS + " / " + compareS + " : "  + StringUtils.difference(defaultS, compareS));
		// 비교해서 같은지 다른지 여부
		System.out.println("비교 - " + defaultS + " / " + compareS + " : "  + StringUtils.equals(defaultS, compareS));
		System.out.println();
		
		// 문자 다 제외하고 숫자만 출력
		compareS = "123hello.456!@#";
		System.out.println("숫자만 출력 - " + compareS + " : " + StringUtils.getDigits(compareS));
		// 찾는 문자열의 index 번호 반환
		System.out.println("찾는 문자열 - " + compareS + " : " + StringUtils.indexOf(compareS, "hello"));
		System.out.println();
		
		compareS = "hello JAVA";
		// 문자열의 대문자 -> 소문자 / 소문자 -> 대문자
		System.out.println("대소문자 변경 - " + compareS + " : " + StringUtils.swapCase(compareS));
		System.out.println("대문자로 변경 - " + compareS + " : " + StringUtils.upperCase(compareS));
		System.out.println("소문자로 변경 - " + compareS + " : " + StringUtils.lowerCase(compareS));
		// 문자열의 앞 뒤 순서 변경
		System.out.println("순서 변경 - " + compareS + " : " + StringUtils.reverse(compareS));
		System.out.println();
		
		// 특정 문자열로 문자열 분리
		compareS="hello,java,javascript,jquery";
		String[] compare = compareS.split(",");
		System.out.println("특정 문자열로 분리 - " + compareS + " : ");
		for(int i = 0; i < compare.length; i++){
			System.out.print(compare[i] + " ");
		}
		System.out.println();
		
		// 앞 뒤 공백 제거
		compareS = " he llo ";
		System.out.println("앞뒤 공백제거 - " + compareS + " : " + compareS.trim());
		// 숫자만 있는지 체크
		defaultS = "123";
		compareS = "123hello";
		System.out.println("숫자 체크 - " + defaultS + " / " + compareS + " : " + StringUtils.isNumeric(defaultS) + " / " + StringUtils.isNumeric(compareS));
	}
}