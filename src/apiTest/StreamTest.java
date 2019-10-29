/*
 * StreamTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 28
 * Contact : dhstoalfh9509@gmail.com
 */
package apiTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Stream API TEST
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 28.
 */
public class StreamTest {
	/**
	 * list에 있는 string들 중 text의 문자가 있으면 출력
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list contain filter 적용할 string 으로 이뤄진 list
	 * @param text contain filter 적용 할 문자
	 */
	public static void containFilter(List<String> list, String text){
		list.stream().filter(x -> x.contains(text)).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 해당 문자가 들어있는 string의 개수
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list contain filter 적용할 string 으로 이뤄진 list
	 * @param text contain filter 적용할 문자
	 */
	public static void containFilterAndCount(List<String> list, String text){
		System.out.println(list.stream().filter(x -> x.contains(text)).count());
	}
	/**
	 * 길이 filter
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list length filter 적용할 string 으로 이뤄진 list
	 * @param length 제한할 길이의 숫자
	 */
	public static void lengthFilter(List<String> list, int length){
		list.stream().filter(x -> x.length() > length).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 정렬
	 * 2019. 10. 28., dhstoalfh9509@gmail.com
	 * @param list 정렬할 list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(List<String> list, Comparator order){
		list.stream().sorted(order).forEach(x -> System.out.print(x + " "));;
		System.out.println();
	}
	/**
	 * 특정 문자 추가해서 반환 후 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list 추가해야 할 list
	 * @param addText 추가할 특정 문자
	 */
	public static void map(List<String> list, String addText){
		list.stream().map(x -> {return x.concat(addText);}).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 중복 제거해서 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list 중복 제거할 리스트
	 */
	public static void removeDistinct(List<Integer> list){
		list.stream().distinct().forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * 건너 뛰기와 limit 걸어서 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list skip과 limit 걸릴 리스트
	 * @param skip 앞 부분 몇 개를 건너뛸지
	 * @param limit 몇개까지 출력할지
	 */
	public static void skipAndLimit(List<Integer> list, int skip, int limit){
		list.stream().skip(skip).limit(limit).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
	/**
	 * list의 모든 수 누적 합산 결과 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list 누적 합을 보여줄 list
	 */
	public static void reduce(List<Integer> list){
		System.out.println(list.stream().reduce((a,b) -> a + b));
	}
	/**
	 * list의 수 중 최소값 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list 
	 */
	public static void min(List<Integer> list){
		System.out.println(list.stream().min(Integer::compare));
	}
	/**
	 * list 중 최대값 출력
	 * 2019. 10. 29., dhstoalfh9509@gmail.com
	 * @param list
	 */
	public static void max(List<Integer> list){
		System.out.println(list.stream().max(Integer::compare));
	}
	
	public static void main(String...args){
		List<String> text = Arrays.asList("fantastic", "nice", "awesome", "gorgeous");

		System.out.println("contain");
		containFilter(text, "a");
		System.out.println();
		
		containFilterAndCount(text, "a");
		System.out.println();
		
		System.out.println("length");
		lengthFilter(text, 6);
		System.out.println();
		
		System.out.println("sort");
		sort(text, Comparator.naturalOrder());
		sort(text, Comparator.reverseOrder());
		System.out.println();

		System.out.println("특정 문자 추가");
		map(text, " >>> ");
		System.out.println();
		
		List<Integer> num = Arrays.asList(1, 4, 5, 7, 3, 2, 1, 4, 9);
		
		System.out.println("중복제거");
		removeDistinct(num);
		System.out.println();
		
		System.out.println("skip and limit");
		skipAndLimit(num, 3, 5);
		System.out.println();
		
		reduce(num);
		min(num);
		max(num);
	}
}
