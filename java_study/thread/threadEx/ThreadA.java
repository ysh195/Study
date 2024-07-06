package ch14.sec06;

public class ThreadA extends Thread{
	private WorkObj workObj;

	public ThreadA(WorkObj workObj) {
		setName("ThreadA");
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.methodA();
		}
	}
	
	
	
}
