package ch14.sec06;

public class User1Thread extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public User1Thread() {
		setName("User1Thread");
	}

	@Override
	public void run() {
		System.out.println("유저1 런");
		calculator.setMemory1(100);
	}
	
}
