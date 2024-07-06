package ch13.sec05;

public class Applicant<T> { // <T>를 붙이는 것은 이 클래스 내부의 필드들이 사용할 클래스 타입을 따로 지정해주겠다는 것.
	// 이 Applicant 클래스의 타입과는 별개임.
	public T kind;

	public Applicant(T kind) {
		this.kind = kind;
	}

}
