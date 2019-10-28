/*
 * StreamTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 28
 * Contact : dhstoalfh9509@gmail.com
 */
package apiTest;

import java.util.Arrays;
import java.util.List;

/**
 * Stream API TEST
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 28.
 */
public class StreamTest {
	/**
	 * 해당 문자 filter
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list contain filter 적용할 string 으로 이뤄진 list
	 * @param text contain 할 문자
	 */
	public static void containFilterTest(List<String> list, String text){
		list.stream().filter(x -> x.contains(text)).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 길이 filter
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list length filter 적용할 string 으로 이뤄진 list
	 * @param length 제한할 길이의 숫자
	 */
	public static void lengthFilterTest(List<String> list, int length){
		list.stream().filter(x -> x.length() > length).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 정렬
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list 정렬할 string list
	 */
	public static void sortTest(List<String> list){
		list.stream().sorted().forEach(x -> System.out.print(x + " "));;
		System.out.println();
	}
	
	public static void main(String...args){
		List<String> names = Arrays.asList("fantastic", "nice", "awesome", "gorgeous");

		System.out.println("contain");
		containFilterTest(names, "a");
		System.out.println();
		
		System.out.println("length");
		lengthFilterTest(names, 6);
		System.out.println();
		
		System.out.println("sort");
		sortTest(names);
	}
}
