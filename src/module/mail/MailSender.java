/*
 * MailSender.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 04
 * Contact : dhstoalfh9509@gmail.com
 */
package module.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 메일 보내기
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 4.
 */
public class MailSender {
	/**
	 * 메일 세션 속성 설정하기
	 * 2019. 11. 4., dhstoalfh9509@gmail.com
	 * @return Mail Session
	 */
	private static Session getMailSession(){
		Properties props = new Properties();
		props.put("mail.smtp.host", MailConst.HOST);
		props.put("mail.const.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		return Session.getDefaultInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(MailConst.USER, MailConst.PASSWORD);
			}
		});
	}
	/**
	 * 메일 발송
	 * 2019. 11. 22., dhstoalfh9509@xtock.io
	 * @param toMail 보내는 사람
	 * @param title 제목
	 * @param content 내용
	 * @return 성공 여부
	 */
	public static boolean sendMail(String toMail, String title, String content){
		boolean result = false;
		Session session = getMailSession();
		
		MimeMessage msg = new MimeMessage(session);
		try {
			// 보내는 사람 설정
			msg.setFrom(new InternetAddress(MailConst.EMAIL));
			// 받는 사람 설정
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
			// 제목
			msg.setSubject(title);
			// 내용
			msg.setContent(content, "text/html; charset=utf-8");
			// 메일 발송
			Transport.send(msg);
			result = true;
		} catch (MessagingException e){
			// 메일 발송 실패
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String...args){
		boolean result = sendMail("dhstoalfh9509@naver.com", "test", "testtest");
		System.out.println(result);
	}
}
