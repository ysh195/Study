package ch16.ex;

public class Student {
	private String name;
	private int eng;
	private int math;
	
	public String getName() {
		return name;
	}

	public int getEng() {
		return eng;
	}
	

	public int getMath() {
		return math;
	}

	public Student(String name, int eng, int math) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
	}
	
}
