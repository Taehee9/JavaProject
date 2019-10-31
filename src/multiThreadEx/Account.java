/*
 * Account.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 31
 * Contact : dhstoalfh9509@gmail.com
 */
package multiThreadEx;

/**
 * MultiThread를 이용한 예제
 * 계좌(입출금)
 * 
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 31.
 */
public class Account {
	// 계좌에 들어있는 총액
	long balance = 10000;
	public void withdraw(long withdrawAmount){
		if(balance >= withdrawAmount){
			try {
				Thread.sleep(1000);
				balance -= withdrawAmount;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
