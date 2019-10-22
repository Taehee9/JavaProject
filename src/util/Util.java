/*
 * Util.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 22
 * Contact : dhstoalfh9509@gmail.com
 */
package util;

/**
 * 자주 사용하는 유틸 관리 객체
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 22.
 */
public class Util {
	/**
	 * 문자열이 null 또는 공백("")인지 체크 / escape 문자 제외
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param s 체크할 문자열
	 * @return  true = null이거나 "" 일 때
	 * 			false = 빈칸으로만 이루어진 문자열일 때, 문자 있을 때
	 */
	public static boolean isEmpty(String s){
		return s == null || "".equals(s);
	}
	/**
	 * 문자열이 빈칸으로만 이루어져있는지 체크("     ") / escape 문자 제외
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param s 체크할 문자열
	 * @return  true = 빈칸으로만 이루어진 문자열일 때("     ")
	 * 			false = null이거나 "" 일 때, 문자 있을 때
	 */
	public static boolean isWhiteSpace(String s){
		if(isEmpty(s)){
			return false;
		}
		char c;
		for(int i = 0, n = s.length(); i < n; i++){
			c = s.charAt(i);
			if(c != ' '){
				return false;
			}
		}
		return true;
	}
	/**
	 * 문자열이 null 또는 공백(""), 빈칸으로만("     ") 이뤄져있는지 체크 / escape 문자(\n처럼 \ 사용하는 문자) 제외
	 * 2019. 10. 22., dhstoalfh9509@gmail.com
	 * @param s 체크할 문자열
	 * @return  true = 빈칸으로만 이루어져 있거나, null이거나 "" 일 때
	 * 			false = 문자가 들어있을 때 
	 */
	public static boolean isEmptyOrWhiteSpace(String s){
		return isEmpty(s) || isWhiteSpace(s);
	}
	
	public static void main(String... args) {
		String s = "ㄴㄴ   ";
		System.out.println(isEmpty(s));
		String ss = "\r";
		System.out.println(isEmpty(ss));
		String sss = ""; //true
		System.out.println(isEmpty(sss));
		
		String a = "ㄴㄴ   ";
		System.out.println(isEmptyOrWhiteSpace(a));
		String aa = "\n"; //true
		System.out.println(isEmptyOrWhiteSpace(aa));
		String aaa = ""; //true
		System.out.println(isEmptyOrWhiteSpace(aaa));
	}

}
