package ch12.sec11;

import java.awt.print.Printable;
import java.lang.reflect.*;

public class GetClassEx1 {

	public static void main(String[] args) throws Exception{
		
		Class clazz = Car1.class;
		System.out.println("[생성자 정보]");
		
		Constructor[] constructor = clazz.getDeclaredConstructors();
		
		for(Constructor e : constructor) {
			System.out.print(e.getName() + "("); // 생성자 이름(
			Class[] parameters = e.getParameterTypes(); // 매개 변수 종류 출력
			printParameters(parameters); // 매개 변수 목록을 모두 나열
			System.out.println(")"); // )
		}
		System.out.println();
		
		System.out.println("[생성자 정보]");
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field e : fields) {
			System.out.println(e.getType() + " " + e.getName());
		}
		System.out.println();
		
		System.out.println("[메소드 정보]");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method e : methods) {
			System.out.print(e.getName() + "("); // 메서드 이름(
			Class[] parameters = e.getParameterTypes();
			// 매개 변수(메서드에 입력하는 인수) 종류 출력.
			// 인수인 String, int 등의 참조타입은 클래스의 한 종류이고, 여러 개일 수도 있으니 배열로 받음.
			printParameters(parameters);
			System.out.println(")");
		}
	}

	private static void printParameters(Class[] parameters) { // 참조 타입의 클래스에 대한 정보를 전달 받으면 그걸 텍스트로 출력하는 메서드
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(i<(parameters.length-1)) { // 출력하는 배열의 마지막이 아니면 계속 ", " 찍어라 
				System.out.println(", ");
			}
		}
	}

}
