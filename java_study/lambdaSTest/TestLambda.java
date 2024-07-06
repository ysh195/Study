package lambdaSTest;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("hello1");
		showMyString(lambdaStr);
		
		PrintString reStr = returnString();
		reStr.showString("hello");
		
	}
	
	public static void showMyString(PrintString p) { // 인터페이스 클래스를 인수로 받아서 그 내부 메서드를 실행시키게 하는 메서드는 별로 놀랍지도 않음.
		p.showString("hello2"); // 당장 나도 구성해서 써봤으니까
	}
	
	public static PrintString returnString() { // 이미 있는 인터페이스의 메서드를 이런 식으로 따로 선언하는 것도 가능하네
		return s -> System.out.println(s+"world");
	}
}


