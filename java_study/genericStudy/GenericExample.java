package ch13.sec05;

public class GenericExample {

	public static void main(String[] args) {
		// 모두 가능 
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
		
		// 학생만 가능. Student 이하만 가능하기 때문에 Person과 Worker 제외
		// Course.registerCourse2(new Applicant<Person>(new Person()));
		// Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
		
		// 직장인만 가능. Worker 이상만 가능하기 때문에 Student, HighStudent, MiddleStudent 제외
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		// Course.registerCourse3(new Applicant<Student>(new Student()));
		// Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
		// Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
	}

}
