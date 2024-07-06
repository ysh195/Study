package ch13.ex01;

public class A<A,B,C,D> {
	
	A a;
	B b;
	C c;
	D d;
	
	
	public A(A a, B b, C c, D d) {	
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	

	// 첫번째 객체 생성시 제너릭 타입파라미터의 순서는 String, Integer, Char, long
	// 두번째 객체 생성시에는 long, char, String, Integer
	@Override
	public String toString() {
		return "A a = " + a + "B b = " + b + "C c = " + c + "D d = " + d;
	}
	
}
