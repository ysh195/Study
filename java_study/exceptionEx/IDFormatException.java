package exceptionEx;

public class IDFormatException extends Exception { // Exception도 클래스였구나. 그리고 Exception을 상속해서 커스터마이징한 예외처리가 가능

	public IDFormatException(String message) { // 근데 커스터마이징한 만큼 이게 뭐하는 예외처리인지 다른 사람으로서는 알 수 없으니 주석을 잘 달아야 함
		super(message);

	}
	

}
