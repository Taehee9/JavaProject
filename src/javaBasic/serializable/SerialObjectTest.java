/*
 * SerailObjectTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 04
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 객체 직렬화, 역직렬화 테스트
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 4.
 */
public class SerialObjectTest {
	public static void main(String...args) throws Exception {
		// serialObjTxt 라는 이름의 파일을 하나 생성
		FileOutputStream fos = new FileOutputStream("c:/serialObjTxt.txt");
		// serailObjTxt의 내용을 바이트의 덩어리로 만들어 스트림에 보낼 수 있는 형태로 변환하기 위한 객체 생성
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 직렬화 가능한 객체 생성
		SerialObject so1 = new SerialObject("권태희", "25", "태희");
		SerialObject so2 = new SerialObject("권탱희", "16", "탱희");
		SerialObject so3 = new SerialObject("권태히", "32", "태히");
		
		// 3개의 객체를 파일로 출력
		oos.writeObject(so1);
		oos.writeObject(so2);
		oos.writeObject(so3);
		
		// 스트림 닫기
		if(fos != null){
			fos.close();
		}
		if(oos != null){
			oos.close();
		}
		System.out.println("완료");

		// 파일로 출력되어 있는 객체 입력받기 위한 파일 스트림 생성
		FileInputStream fis = new FileInputStream("c:/serialObjTxt.txt");
		// 객체 입력받기 위한 객체 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 객체를 입력받아 역 직렬화한 후 출력
		System.out.println((SerialObject)ois.readObject());
		System.out.println((SerialObject)ois.readObject());
		System.out.println((SerialObject)ois.readObject());
		
		// 스트림 닫기
		if(fis != null){
			fis.close();
		}
		if(ois != null){
			ois.close();
		}
	}
}
