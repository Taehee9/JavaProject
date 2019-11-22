/*
 * MailConst.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 22
 * Contact : dhstoalfh9509@gmail.com
 */
package module.mail;

/**
 * 메일 관리
 * @author Taehee Kwon, dhstoalfh9509@xtock.io, 2019
 * @since  2019. 11. 22.
 */
public class MailConst {
	/**
	 * SMTP 주소(메일 호스트)
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String HOST = "smtp.gmail.com";
	/**
	 * 메일 포트
	 * 465 = TLS / 587 = SSL0
	 * 이 포트에 따라 MailSender에서의 props 설정 내용이 바뀜
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String PORT = "465";
	/**
	 * 메일
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String EMAIL = "dhstoalfh9509@gmail.com";
	/**
	 * 메일 USER 아이디
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String USER = "taehee";
	/**
	 * 메일 비밀번호
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String PASSWORD = "password";
	/**
	 * 메일 타이틀
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 */
	public static final String EMAIL_TITLE = "TEST";
}
