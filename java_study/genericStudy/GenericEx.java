package ch13.sec03;

public class GenericEx {
	
	public static <T> Box<T> boxing(T t){ // Box 클래스는 이미 생성되어 있고, 이건 Box 클래스 생성자를 포함한 메서드임;
		// 여기서 맨 앞의 <T> 는 이 메서드의 내부에서 사용할 특수한 부정형의 클래스 타입을 선언한 것인지, 아니면 리턴 타입에 관련된 것인지 애매함
		// 그리고 반환 타입으로는 Box<T> 클래스 선언, boxing(T t)는 저장될 변수 및 인수
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}

	public static void main(String[] args) {
		Box<Integer> box1 = boxing(100);
		int intValue = box1.getT();
		System.out.println(intValue);
		
		Box<String> box2 = boxing("홍길동");
		String strValue = box2.getT();
		System.out.println(strValue);

	}

}
