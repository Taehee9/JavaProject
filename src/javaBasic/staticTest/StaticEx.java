/*
 * StaticEx.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 13
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic.staticTest;

/**
 * Static 생성자, 변수, 함수 등 정의
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 13.
 */
public class StaticEx {
	// static 초기화 = 클래스가 최초 로딩될 때 수행 / 생성자 실행과 관계 없음
	static{
		System.out.println("StaticExample static block");
		str = "Test";
		setCount(2);
	}
	// static 초기화
	static{
		System.out.println("Static Example static block2");
	}
	
	// static 변수
	private static int count;
	public static String str;

	public int getCount(){
		return count;
	}
	
	// static method
	public static void setCount(int count){
		if(count > 0)
			StaticEx.count = count;
	}
	
	public static int addInts(int i, int...js){
		int sum = i;
		for(int x : js)
			sum += x;
		return sum;
	}
	
	// static class
	public static class MyStaticClass {
		public int count;
	}
	
}
