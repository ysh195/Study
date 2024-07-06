package ch12.sec12;

public class Service {
	@PrintAnnotation // @하고 컨트롤+스페이스바 하면 나옴
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("*") // 어노테이션에서 정의한 첫번째 필드값 value에 "*"를 입력.
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value = "#", number = 20) // 한 번에 여러 개 입력하려면 이렇게 어떤 값에 뭘 넣는지 알려줘야 함.
	public void method3() { // 어노테이션에서 정의한 필드값 value에 "#"를 입력하고, number에 20을 입력
		System.out.println("실행 내용3");
	}

}
