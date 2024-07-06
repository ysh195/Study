package ch14.sec06;

public class User2Thread extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public User2Thread() {
		System.out.println("유저2 런");
		setName("User2Thread");
	}

	@Override
	public void run() {
		calculator.setMemory2(100);
	}
	
}
