package ch16.ex;

public class Example {

	private static Student[] students = {
			new Student("홍길동",90,96),
			new Student("신용권",95,93)
	};
	
	static double avg(Function<Student> fuction) {
		// 이건 기능이 제대로 구현되지 않은 메서드가 있는데, 어떠한 메서드 자체를 인수로 받겠다. 그래서 인수로 받은 메서드를 사용하겠다
		// 그리고 () 안에 들어가는 s -> s.getEng() 자체가 인수로 받는 메서드고, 그렇게 되면 fuction.apply() 메서드가 s -> s.getEng() 로 수정됨

		double result = 0;
		
		for(Student stu : students) {
			result += fuction.apply(stu);
		}
		
		return result/students.length;
		
	}
	
	public static void main(String[] args) {
		
		double engAvg = avg(s -> s.getEng());
		System.out.println("영어 점수 평균 : " + engAvg);
		
		double mathAvg = avg(s -> s.getMath());
		System.out.println("수학 점수 평균 : " + mathAvg);

	}

}
