package inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// in/out 스트림은 다른 파일이 안 열려서 포기

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("C:\\Users\\bscom\\eclipse-workspace\\ch15\\input.text")){
			int i;
			while((i = fis.read()) != -1) { // fis.read 값을 i에 넣어봤는데, 그게 -1이 아니면 진행
				System.out.println((char)i);
			}
			System.out.println("end");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
