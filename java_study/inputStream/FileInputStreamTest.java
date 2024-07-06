package inputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("input.txt"); // 이런 파일은 존재하지 않아서 무조건 문제 생김
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
		}
		catch(IOException e) {
			System.out.println(e);
		}
		finally{
			try {
				fis.close(); // 존재는 하는데, 닫을 때 오류 생기는 경우라면 그냥 finally 안에 close 쓰면 되는데,
							// 애초에 존재하지 않아서 열린 적도 없으니 다시 한 번 오류 처리가 필요함.
			}
			catch(IOException e) {
				System.out.println(e);
			}
			catch(NullPointerException e) {
				System.out.println(e);
			}
		}
		System.out.println("end");

	}

}
