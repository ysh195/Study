package ch11.classEx;

public class NewInstanceTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Person person1 = new Person(); // 생성자로 만들기
		System.out.println(person1);
		
		Class pClass = Class.forName("ch11.classEx.Person"); // Person 클래스를 pClass에 저장
		Person person2 = (Person)pClass.newInstance(); // Class 클래스에 포함된 newInstance() 메소드로 생성하기
		// Person 같이 내가 만든 클래스에는 없고 딱 Class 클래스에만 newInstance() 메서드가 있어서
		// 저거 쓰려면 반드시 Class 클래스를 하나 생성하고, 그거에 내가 인스턴스로 만들고자 하는 클래스를 저장해야 함.
		// 저장 방법은 클래스명.getClass(), 클래스명.Class, 클래스명.forName("클래스명")
		// 이 방법을 사용하면 텍스트 구성만으로 자신이 무슨 클래스를 만들 것인지 자유롭게 설정 가능.
		// 다만 클래스명 입력이 조금이라도 잘못되면 바로 오류 뜨니까 주의
		System.out.println(person2);

	}

}
