/*
 * StaticTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 13
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic.staticTest;

/**
 * 
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 13.
 */
public class StaticTest {

	public static void main(String...args){
		// str 값 print & static 초기블록 print
		System.out.println(StaticEx.str);

		// static 변수 값 다시 setting
		StaticEx.setCount(5);
		StaticEx.str = "abc";
		
		StaticEx st = new StaticEx();
		System.out.println(st.getCount());
		
		// 생성안한 str 과 생성한 StaticEx의 str 값 비교
		System.out.println("=============================");
		System.out.println(StaticEx.str + " vs " + st.str);
		System.out.println(StaticEx.str == st.str);
		System.out.println("=============================");
		
		// static 클래스 안의 count 정의
		StaticEx.MyStaticClass myStatic = new StaticEx.MyStaticClass();
		myStatic.count = 10;
		
		StaticEx.MyStaticClass myStatic2 = new StaticEx.MyStaticClass();
		myStatic2.count = 20;
		
		System.out.println(myStatic.count);
		System.out.println(myStatic2.count);
	}
}
