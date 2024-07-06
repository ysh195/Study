package exceptionEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArrayExceptionHandling3 {

	public static void main(String[] args) {
		FileInputStream fis = null; // 아예 안에서 생성해야 하는 줄 알았는데, 그러면 다른 catch나 finally로 전달이 안 되네.
		
		try{ // 그냥 파일을 오픈하는 이벤트만 try문 안에서 발생하면 되는 듯 
			fis = new FileInputStream("a.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
			return;
		}
		finally { // 파이널리는 리턴도 무시하고 일단 수행됨.
			if(fis != null) {
				try {
					fis.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			System.out.println("무조건 수행");
		}
		System.out.println("리턴 없으면 항상 수행"); // 하지만 리턴으로 인해 파이널 끝나면 그 뒤는 얄짤 없음
	}
}
