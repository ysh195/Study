package ch13.sec05;

public class Course {
	
	public static void registerCourse1(Applicant<?> applicant) {
		// Applicant 클래스를 생성하지만, 그 내부에서 사용될 필드의 클래스 타입을 아무거나(?)로 설정함.
		// 그리고 applicant 생성자 생성함. 
		// 이 메서드의 인수를 생성된 Applicant<?> applicant으로 받겠다는 것
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
	}
	
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		// 아무거나(?) 중에서도 Student를 상속한 애들만 받겠다고 제한
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함");
	}
	
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		// 아무거나(?) 중에서도 Worker를 상속한 애들만 받겠다고 제한
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함");
	}
	
}
