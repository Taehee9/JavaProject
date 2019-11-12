/*
 * FileTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 08
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.jsoup.helper.StringUtil;

/**
 * 파일 생성 및 읽고 쓰는 예제
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 8.
 */
public class FileTest {
	/**
	 * byte 방식으로 파일에 입력하기
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param fileName 파일명
	 * @param content 파일내용
	 */
	public void writeByte(String fileName, String content){
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileName);
			byte[] bytes = content.getBytes();
			outputStream.write(bytes);
			outputStream.close();
		} catch (FileNotFoundException e) {
			// FileOutputStream 생성할 때 발생할 수 있는 exception
			e.printStackTrace();
		} catch (IOException e) {
			//outputStream이 write 할 때 발생할 수 있는 exception
			e.printStackTrace();
		}
	}
	/**
	 * string 방식으로 파일에 입력하기
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param fileName 파일명
	 * @param content 파일내용
	 * @param continueContent true - 파일명에 파일내용 추가
	 * 						  false - 새로 쓰기
	 */
	public static void writeString(String fileName, String content, boolean continueContent) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName, continueContent));
			pw.println(content);
			pw.close();
		} catch (IOException e) {
			// FileWrieter 를 생성하고 write 할 때 발생할 수 있는 exception
			e.printStackTrace();
		}
	}
	/**
	 * char 방식으로 파일 내용 읽기
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param fileName 파일명
	 * @param charNum 몇 글자 읽어올건지
	 */
	public void readChar(String fileName, int charNum){
		char[] readContent = new char[charNum];
		FileReader reader;
		try {
			reader = new FileReader(fileName);
			reader.read(readContent);
			reader.close();
			System.out.println(readContent);
		} catch (FileNotFoundException e) {
			// FileReader 생성할 때 발생할 수 있는 exception
			e.printStackTrace();
		} catch (IOException e) {
			// FileReader 가 read 할 때 발생할 수 있는 exception
			e.printStackTrace();
		}
	}
	/**
	 * string 방식으로 파일 내용 읽기
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param fileName 파일명
	 */
	public static void readString(String fileName){
		BufferedReader fileReader;
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String readContentString;
			while((readContentString = fileReader.readLine()) != null){
				System.out.println(readContentString.toString());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// FileReader 생성할 때 발생할 수 있는 exception
			e.printStackTrace();
		} catch (IOException e) {
			// FileReader 가 읽을 때 발생할 수 있는 exception
			e.printStackTrace();
		}
		
	}
	/**
	 * 파일 삭제
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param file 파일
	 * @return 파일 삭제 성공 여부
	 */
	public boolean deleteFile(File file){
		return file.delete();
	}
	/**
	 * 파일 생성
	 * 2019. 11. 8., dhstoalfh9509@gmail.com
	 * @param file 파일
	 * @return 파일 생성 성공 여부
	 */
	public boolean createFile(File file) throws IOException{
		return file.createNewFile();
	}
	
	public static void main(String...args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 파일명
		String fileName;
		// 파일 내용
		String content = null;

		System.out.println("파일 테스트");
		while(true){
			System.out.println("========================");
			System.out.println("1 : 파일 생성");
			System.out.println("2 : 파일 삭제");
			System.out.println("3 : 파일 읽기");
			System.out.println("4 : 파일 쓰기");
			System.out.println("5 : 종료");
			
			String temp = null;
			// 숫자가 아니면 다시 입력
			while(!StringUtil.isNumeric(temp = br.readLine())){
				System.out.println("숫자만 입력해주세요.");
			}
			// 숫자일 때
			int num = Integer.parseInt(temp);
			
			// 종료일 때
			if(num == 5){
				System.out.println("종료합니다.");
				break;
			} else{
			//종료가 아닐 때
				System.out.println("파일 이름을 입력하세요");
				// 파일 이름
				fileName = br.readLine();
				File file = new File(fileName);
				
				if(num == 1){
					// 파일 생성
					boolean created = file.createNewFile();
					System.out.println("파일 생성 " + created);
					// 파일이 이미 존재할 때
					if(!created){
						System.out.println("파일이 이미 존재합니다.");
					}
				} else if(num == 2){
					// 파일 삭제
					boolean deleted = file.delete();
					System.out.println("파일 삭제 " + deleted);
				} else if(num == 3){
					// 파일 읽기
					if(file.exists()){
					// 파일명으로 된 파일이 있을 때
						readString(fileName);
					} else{
					// 파일명으로 된 파일이 없을 때
						System.out.println("파일이 없습니다.");
					}
				} else if(num == 4){
					// 파일 쓰기
					if(file.exists()){
					// 파일명으로 된 파일이 있을 때
						System.out.println("파일 안에 입력될 내용을 입력해주세요.");
						content = br.readLine();
						writeString(fileName, content, true);
					} else{
					// 파일명으로 된 파일이 없을 때
						//파일 생성
						boolean created = file.createNewFile();
						System.out.println("파일 생성 " + created);
						// 내용 입력
						System.out.println("파일 안에 입력될 내용을 입력해주세요.");
						content = br.readLine();
						writeString(fileName, content, false);
					}
				}
			}
			
		}
		
		
	}
}
