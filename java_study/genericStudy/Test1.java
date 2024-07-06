package ch13.ex01;

public class Test1 {

	public static void main(String[] args) {
		A<String, Integer, Character, Long> a1 = new A<>();
		a1.setA("A");
		a1.setB(1);
		a1.setC('a');
		a1.setD(1L);
		System.out.println(a1.getA() + ", " + a1.getB() + ", " + a1.getC() + ", " + a1.getD() );
		//A<String, Integer, Character, Long> a1 = new A<>("A",1,'a',1L);
		
		A<Long, Character, String, Integer> a2 = new A<>();
		a2.setA(1L);
		a2.setB('a');
		a2.setC("A");
		a2.setD(1);
		System.out.println(a2.getA() + ", " + a2.getB() + ", " + a2.getC() + ", " + a2.getD() );
		
		//A<Long, Character, String, Integer> a2 = new A<>(1L, 'a', "A", 1);

	}

}
