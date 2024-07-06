package ch08.sec07;

public interface Service { // 인터페이스 메서드에 default, private 등이 들어가거나 static이 붙으면 {} 설정 가능.
	
	default void defaultMethod1() {
		System.out.println("default1Method1 종속 코드");
		defaultCommon();
	}
	
	default void defaultMethod2() {
		System.out.println("default1Method2 종속 코드");
		defaultCommon();
	}
	
	private void defaultCommon() { // private 메서드 > default 메서드
		System.out.println("default1Method1 중복 A");
		System.out.println("default1Method1 중복 B");
	}
	
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}
	
	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}
	
	private static void staticCommon() { // private static 메서드 > default 메서드, static 메서드 
		System.out.println("staticMethod 중복 코드 C"); // 그냥 private > default고,
		System.out.println("staticMethod 중복 코드 D"); // static > static 정도로 생각하면 될 듯
	}

}
