package ch14.sec06;

public class ThreadB extends Thread{
	private WorkObj workObj;

	public ThreadB(WorkObj workObj) {
		setName("ThreadB");
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.methodB();
		}
	}
	
	
	
}
