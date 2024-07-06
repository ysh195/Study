package lambdaS;

@FunctionalInterface // 이걸 쓰면 메서드 하나만 넣게 락이 걸리는 듯
public interface MyNumber {
	
	int getMax(int num1, int num2); // 람다식 쓸 때 함수가 여러 개면 뭘 재정의하는지 애매해져서 한 번에 하나만 씀
	int add(int num1, int num2);
}
