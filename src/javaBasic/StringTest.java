/*
 * StringTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 07
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic;

/**
 * String, StringBuilder, StringBuffer Test
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 7.
 */
public class StringTest {

	public static void main(String[] args) {
		// string 
		System.out.println("String Test");
		String string = "hello";
		System.out.println(string.concat(" world"));
		System.out.println(string + "\n");
		
		// string Builder
		System.out.println("StringBuilder Test");
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		System.out.println("capacity : " + sb.capacity() +"  /  length : " + sb.length());
		System.out.println(sb.append(" world!! stringBuilder"));
		System.out.println(sb);
		System.out.println("capacity : " + sb.capacity() +"  /  length : " + sb.length() + "\n");
		
		// string Buffer
		System.out.println("StringBuffer Test");
		StringBuffer sbuffer = new StringBuffer("Hello");
		System.out.println(sbuffer);
		System.out.println("capacity : " + sbuffer.capacity() +"  /  length : " + sbuffer.length());
		System.out.println(sbuffer.append(" world!! stringBuffer"));
		System.out.println(sbuffer);
		System.out.println("capacity : " + sbuffer.capacity() +"  /  length : " + sbuffer.length());

	}

}
