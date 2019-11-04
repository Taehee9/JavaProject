/*
 * ExternalObject.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 04
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 객체 직렬화를 위한 기본 조건(Externalizable 이용)
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 4.
 */
public class ExternalObject implements Externalizable{
	private String name; // 이름
	private int age; // 나이
	private double height; // 키
	
	/**
	 * 매개변수 없는 default 생성자 꼭 필수
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public ExternalObject(){}
	/**
	 * 생성자
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @param name, age, height 이름, 나이, 키
	 */
	public ExternalObject(String name, int age, double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	/**
	 * Externalizable 인터페이스 구현 시 필수 메소드(입력)
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @param obj
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput obj) { 
		try {
			System.out.println("readExternal");
			name = (String) obj.readObject();
			age = obj.readInt();
			height = obj.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	/**
	 * Externalizable 인터페이스 구현 시 필수 메소드(출력)
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @param obj 
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput obj){
		try {
			System.out.println("writeExternal");
			obj.writeObject(name);
			obj.writeInt(age);
			obj.writeDouble(height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * string 반환
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @return 이름 : 나이 - 키
	 */
	public String toString(){
		return name + " : " + age + " - " + height;
	}
}
