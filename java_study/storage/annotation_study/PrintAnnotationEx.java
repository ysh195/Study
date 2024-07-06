package ch12.sec12;

import java.lang.reflect.*;

public class PrintAnnotationEx {

	public static void main(String[] args) throws Exception{
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		// Service 클래스에서 선언된 메서드 정보들을 다 declaredMethods에 저장
		for(Method method : declaredMethods) { // 메소드 정보가 있으면 반복
			
			System.out.println(method);
			PrintAnnotation printAnnotation = method.getDeclaredAnnotation(PrintAnnotation.class);
			// PrintAnnotation 클래스에 선언된 메서드를 printAnnotation로 옮김. 근데 메서드를 순서대로 주는 게 아니라 무작위로 줌
			// getDeclaredAnnotation은 @~~ 그 자체(Ex : @PrintAnnotation("*"))를 넘겨줌.
			// 그렇게 해서 오리지널인 printAnnotation에 덮어씌우는데, 넘겨준 @에 값이 설정되어 있으면 그걸 우선하고, 없으면 오리지널의 디폴트를 우선함.
			// 그렇게 해서 오리지널인 printAnnotation에 덮어씌우는데, 넘겨준 @에 값이 설정되어 있으면 그걸 우선하고, 없으면 오리지널의 디폴트를 우선함.
			// 어노테이션 그 자체가 하나의 값인데, 어노테이션 관련 메서드를 통해서 그 값을 사용하지 않으면 어노테이션이 존재하지 않는 것과 같음
			
			System.out.println(printAnnotation.toString());
			// 코드를 살펴보니 괄호 안에 PrintAnnotation.class 들어가는 건 어떤 의미가 있는 게 아니라, 그냥 규칙임.
			// 어노테이션 클래스를 입력하면 그 안에 입력된 어노테이션을 가져옴.
			
			printLine(printAnnotation);
			// printAnnotation에 저장된 메서드를 printLine의 흐름에 따라 실행
			
			method.invoke(new Service());
			// invoke는 getDeclaredMethods로 받아온 메서드를 실행시키기 위한 함수.
			
			printLine(printAnnotation);
			// printAnnotation에 저장된 Service의 메서드를 printLine의 흐름에 따라 실행
		}
	}
	
	public static void printLine(PrintAnnotation printAnnotation) {
		if(printAnnotation != null) {
			int number = printAnnotation.number(); // 어노테이션에서 number의 디폴트값인 15를 가져옴
			for(int i=0; i<number; i++) { // 15번 반복
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
		
	}

}
