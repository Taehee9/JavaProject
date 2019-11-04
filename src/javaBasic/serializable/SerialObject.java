/*
 * SerailObject.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 04
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic.serializable;

import java.io.Serializable;

/**
 * 객체 직렬화하기 위한 기본 조건(Serializable 이용)
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 4.
 */
public class SerialObject implements Serializable{
	// 직렬화를 위해 Serializable 인터페이스 상속
	
	/**
	 * serialVersionUID
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	private static final long serialVersionUID = 8250211508642787764L;
	
	private String name; // 이름
	private String age; // 나이
	private String nick; // 닉네임
	
	/**
	 * 생성자
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @param name, age, nick 이름, 나이, 닉네임
	 */
	public SerialObject(String name, String age, String nick){
		this.name = name;
		this.age = age;
		this.nick = nick;
		
	}
	/**
	 * string 반환
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @return 이름 : 나이 - 닉네임
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return name + " : " + age + " - " + nick;
	}
}
