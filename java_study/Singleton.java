package ch06.sec15;

public class Singleton {
	
	private static Singleton replacer = new Singleton(); // singleton 이라고 하는 변수를 선언하면서 그 변수 안에 싱글톤 클래스를 저장함.
	
	private Singleton() {} // private 생성자
	
	// 위의 2개는 클래스를 활용할 때 기본적으로 사용하는 변수 안에 클래스 저장과 생성자임. 근데 그 2가지를 private로 막아버려서 기본적인 접근 방식을 차단한 것.
	
	public static Singleton getInstance() {
		return replacer; // 그러면서 이미 싱글톤을 저장한 상태로 생성된, replacer를 대신 내보내서 딱 싱글톤의 기능을 가진 것은 replacer 하나만 쓸 수 있게 만드는 것.
		// 그러면 다른 싱글톤은 쓸 수 없으니, 모두가 replacer 하나를 돌려 쓰게 됨
	}

}

//Singleton ob1 = Singleton.getInstance();
//Singleton ob2 = Singleton.getInstance();
//
//if(ob1==ob2) {
//	System.out.println("같은 싱글톤 객체");
//}
//else {
//	System.out.println("다른 싱글톤 객체");
