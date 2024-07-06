package ch13.ex01;

public class Test {

	public static void main(String[] args) {
		
		A<String, Integer, Character, Long> a1 = new A<>("A",1,'a',1L);
		
		A<Long, Character, String, Integer> a2 = new A<>(1L, 'a', "A", 1);

	}

}
/* 이렇게 하면 <T> Box<T> 중 앞에 있는 <T>는 반환타입을 의미하고, 반환타입이 아직 안 정해졌다는 거임
public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}
*/
