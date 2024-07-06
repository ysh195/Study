package lambdaS;

public class TestStringConcat {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "World";
		
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(s1, s2); // 굳이 메서드 하나 정의하려고 새로운 클래스 만들기 귀찮으니까 간단하게 하려는 게 람다식이네
		
		StringConcat concat2 = (s,v) -> System.out.println(s+","+v);
		// StringConcat concat2 = new StringConcat(s,v);를 
		// StringConcat concat2 = (s,v)로 간략하게 하고
		// 내부에 추상 메서드에 대한 오버라이드를 -> System.out.println(s+","+v);로 간략하게 함
		concat2.makeString(s1, s2);

	}

}
