package inputStream;

import java.io.IOException;

public class SystemInTest2 {

	public static void main(String[] args) throws IOException{
		System.out.println("알파벳 여러 개를 쓰고 [Enter]키를 누르세요.");
		
		int input;
		try {
			while((input = System.in.read()) != '\n') {
				System.out.print((char)input); // while문으로 1바이트씩 여러 번 읽음.
			} // char 표기로 Enter가 \n니까 입력된 게 엔터가 아닐 때까지 입력받고 읽겠다는 것
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
