package inputStream;

import java.io.Console;

public class ConsoleTest { // 가장 쓰레기 같은 기능

	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.println("이름 : ");
		String name = console.readLine();
		System.out.println("나이 : ");
		char[] age = console.readPassword();
		
		System.out.println(name + ", " + age);

	}

}
