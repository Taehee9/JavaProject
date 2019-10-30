/*
 * NaverSearchCrawling.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 29
 * Contact : dhstoalfh9509@gmail.com
 */
package crawling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpURLConnection 이용한 네이버 실시간 검색어 크롤링 방법
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 30.
 */
public class NaverSearchCrawling {

	public static void main(String...args){
		try {
			// 절대 경로로 url 객체 생성
			URL url = new URL("https://www.naver.com/");
			// HttpURLConnection(URL 요청 후 응답 받기) 구하기
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String rankTemp;
			int rank = 0;
			// 한 줄을 읽어서 temp에 저장
			while((rankTemp = br.readLine()) != null){
				// 실검의 내용이 ah_k 라는 class에 들어가 있음 && 랭킹 20개까지(지정 안하면 40위까지 보여짐)
				if(rankTemp.contains("class=\"ah_k\"") && rank < 20){
					System.out.println(++rank + "위 : " + rankTemp.split(">")[1].split("<")[0]);
				}
			}
			// 접속 해제
			conn.disconnect();
			// bufferedReader 닫기
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
