package ch11.classEx;

import java.lang.reflect.*;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException{
		
		Class strClass = Class.forName("java.lang.String");
		
		Constructor[] cons = strClass.getConstructors(); // 모든 생성자 가져오기;
		// 생성자를 이렇게 가져올 수도 있고, 생성자의 배열로 만들어서 여러 생성자를 한 번에 저장할 수도 있구나
		
		for(Constructor c : cons) {
			System.out.println(c);
		}
		
		System.out.println();
		
		Field[] fields = strClass.getFields(); // 필드와 메서드까지? 이러면 import하고 비슷한 기능을 하려나
		
		for(Field f : fields) {
			System.out.println(f);
		}
		
		System.out.println();
		
		Method[] methods = strClass.getMethods();
		
		for(Method m : methods) {
			System.out.println(m);
		}
		

	}

}
