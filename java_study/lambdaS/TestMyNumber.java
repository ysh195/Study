package lambdaS;

public class TestMyNumber {

	public static void main(String[] args) {
		MyNumber max = (x,y) -> (x>=y)? x : y; // getMax 메서드를 선언해둔 MyNumber 클래스의 생성자 max. 그리고 그 맥스 내에서의 x, y에 관한 관계를 정립  
		System.out.println(max.getMax(10, 20)); // MyNumber 클래스의 생성자니까 당연히 내부에 getMax 메서드가 있고, getMax 메서드가 정립해둔 x, y에 따라 실행됨

	}

}
