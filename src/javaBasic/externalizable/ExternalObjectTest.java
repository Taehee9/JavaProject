package javaBasic.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalObjectTest {
	public static void main(String...args){
		ExternalObject eo1 = new ExternalObject("권태희", 25, 165.8);
		ExternalObject eo2 = new ExternalObject("탱희", 16, 153.1);
		ExternalObject eo3 = new ExternalObject("태히", 32, 171.5);
		
		try {
			FileOutputStream fos = new FileOutputStream("c:/externalObjTxt.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(eo1);
			oos.writeObject(eo2);
			oos.writeObject(eo3);
			
			// 스트림 닫기
			if(fos != null){
				fos.close();
			}
			if(oos != null){
				oos.close();
			}
			
			FileInputStream fis = new FileInputStream("c:/externalObjTxt.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.println(((ExternalObject)ois.readObject()).toString());
			System.out.println(((ExternalObject)ois.readObject()).toString());
			System.out.println(((ExternalObject)ois.readObject()).toString());
			
			// 스트림 닫기
			if(fis != null){
				fis.close();
			}
			if(ois != null){
				ois.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
