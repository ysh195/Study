package inputStream;

import java.io.IOException;

public class SystemInTest1 {

	public static void main(String[] args) throws IOException{
		System.out.println("알파벳 하나를 쓰고 [Enter]키를 누르세요.");
		
		int input;
		try {
			input = System.in.read(); // 1바이트만 읽음
			System.out.println(input);
			System.out.println((char)input);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
