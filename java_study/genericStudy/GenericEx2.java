package ch13.sec04;

public class GenericEx2 {
	
	public static <T extends Number> boolean compare(T t1, T t2) {
		// Number는 int, long, float, double의 부모 클래스이고, Number면 그 하위 클래스로 전환도 가능해짐
		// T extends Number를 하면 사실상 T에 Number를 덮어씌우는 것이고, T의 클래스 타입이 Number 및 그 하위 클래스로 제한됨.
		// 그리고 t1, t2가 입력됨과 동시에 타입이 자동으로 결정되고, 그것이 모두 하나로 통일될 필요는 없음.
		System.out.println("compare("+ t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return (v1 == v2);
		
	}

	public static void main(String[] args) {
		
		boolean result1 = compare(10,20);
		System.out.println(result1);
		System.out.println();
		
		boolean result2 = compare(4.5,4.5);
		System.out.println(result2);
		
		Number x = 10;
	}

}
