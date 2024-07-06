package ch18.sec03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyEx {

	public static void main(String[] args) throws Exception {
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";
		
		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
		is.transferTo(os); // 그냥 바로 보내버림
		
//		byte[] data = new byte[1024];
//		while(true) {
//			int num = is.read(data);
//			if(num == -1) {break;}
//			os.write(data, 0, num);
//		}
		
		os.flush();
		os.close();
		is.close();
		
		System.out.println("복사 종료");
	}

}
