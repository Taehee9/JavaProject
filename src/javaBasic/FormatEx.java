/*
 * FormatEx.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 15
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class FormatEx {
	/**
	 * 선택 format
	 * # 포함 
	 * < 불포함
	 * 2019. 11. 15., dhstoalfh9509@xtock.io
	 */
	public static void choiceFormat(){
		// 점수
		int[] score = {55, 70, 80, 68, 47, 92, 96, 88, 60, 58};
		// 0~60 불합격 / 61~ 합격
		String pattern = "0#불합격|60<합격";
		
		ChoiceFormat cf = new ChoiceFormat(pattern);
		
		for(int i = 0; i< score.length; i++){
			System.out.println((i + 1) + ". \t" + score[i] + " : " + cf.format(score[i]));
		}
	}
	/**
	 * 메시지 format
	 * 2019. 11. 15., dhstoalfh9509@xtock.io
	 */
	public static void messageFormat(){
		// 패턴
		String pattern = "가수 : {0}\t제목 : {1}\t앨범 : {2}";
		
		// 안에 들어갈 내용
		String[] source1 = {"악뮤", "FREEDOM", "항해"};
		String[] source2 = {"마마무", "HIP", "reality in BLACK"};
		String[] source3 = {"폴킴", "New Day", "마음, 하나"};
		String[] source4 = {"태연", "불티", "Purpose"};
		
		MessageFormat mf = new MessageFormat(pattern);
		
		System.out.println(mf.format(source1));
		System.out.println(mf.format(source2));
		System.out.println(mf.format(source3));
		System.out.println(mf.format(source4));
	}
	
	public static void main(String...args){
		choiceFormat();
		System.out.println("##########################################################");
		messageFormat();
	}
}
