/*
 * NaverMusicCrawling.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 30
 * Contact : dhstoalfh9509@gmail.com
 */
package crawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoup 이용한 네이버 뮤직 크롤링 방법
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 30.
 */
public class NaverMusicCrawling {
	public static void main(String...args){
		try {
			// URL 가져오기
			String url = "https://music.naver.com/";
			// URL 통해서 페이지의 전체소스 Document에 저장
			// doc.toString() = doc.html()은 html을 string 형식으로 나옴 
			// doc.text()는 그 안에 text들을 출력함(네이버 뮤직 메인메뉴 바로가기 이런식)
			Document doc = Jsoup.connect(url).get();
			// select을 이용해 일간 top 100 리스트 선택(첫 번째가 일간)
			Element element = doc.select("table.home_top100").first();
			
			System.out.println("==============================================================================================================");
			
			// iterator 사용해서 랭크 숫자, 곡명, 아티스트명, 앨범명 하나씩 가져오기
			Iterator<Element> rank = element.select(".ranking .num").iterator();
			Iterator<Element> songName = element.select(".name a").iterator();
			Iterator<Element> artist = element.select(".artist a").iterator();
			Iterator<Element> album = element.select(".album a").iterator();
			
			// iterator.hasNext() 다음 항목이 있으면 true / 없으면 false
			while(rank.hasNext()){
				System.out.println(rank.next().text() + "위\t" + songName.next().text() + "\t" + artist.next().text() + "\t" + album.next().text());
			}
			
			System.out.println("==============================================================================================================");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
