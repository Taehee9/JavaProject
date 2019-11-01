/*
 * Bank.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 31
 * Contact : dhstoalfh9509@gmail.com
 */
package multiThreadEx;

/**
 * MultiThread를 이용한 예제
 * Bank에 관한 class로 원금보다 찾아가려는 금액이 크지 않도록 처리
 * 
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 31.
 */
public class Bank extends Thread{
	
	static Account ac = new Account();
	public Bank(){}
	public Bank(String name){
		super(name);
	}
	
	public void run(){
		while(true){
			synchronized(ac){
				// Math.random() * MAX + MIN 
				long withdrawAmount = (long)(Math.random() * 5 + 1) * 1000;
				if(ac.balance == 0){
					System.out.println("잔액이 없습니다.");
					break;
				} else{
					System.out.println(getName() + " - 출금 물량 : " + withdrawAmount);
					if(ac.balance >= withdrawAmount){
						ac.withdraw(withdrawAmount);
						System.out.println(getName() + " - 잔액 : " + ac.balance);
					} else{
						System.out.println("잔액부족");
						break;
					}
				}
			}
		}
	}
}
