package ch18.sec02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test2.db");
			byte[] array = {10,20,30};
			
			os.write(array, 1, 3); // 뒤에 숫자 안 쓰면 전체, 쓰면 그 범위 내로만
			os.flush();
			os.close();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
