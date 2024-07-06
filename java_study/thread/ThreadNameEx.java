package ch14.sec04;

public class ThreadNameEx {

	public static void main(String[] args) {
		
		Thread mainThread1 = new Thread(){ // 그리고 선언한 순서대로 넘버링이 붙음
			@Override
			public void run() {
			}
		};
		System.out.println(mainThread1.getName() + "실행1");
		
		Thread Thread1 = new Thread(){ // 
			@Override
			public void run() {
			}
		};
		System.out.println(Thread1.getName() + "실행2");
		Thread Thread2 = new Thread(){ // 
			@Override
			public void run() {
			}
		};
		System.out.println(Thread2.getName() + "실행3");
		Thread Thread3 = new Thread(){ // 
			@Override
			public void run() {
			}
		};
		System.out.println(Thread3.getName() + "실행4");
	
		Thread mainThread2 = Thread.currentThread(); // currentThread()를 붙이면 무조건 main이네.
		System.out.println(mainThread2.getName() + "실행5");
		
		for(int i=0; i<3; i++) {
			Thread threadA = new Thread() {

				@Override
				public void run() {
					System.out.println(getName() + "실행6");
				}
				
			};
			threadA.start();
		}
		
		Thread chatThread = new Thread() {

			@Override
			public void run() {
				System.out.println(getName() + "실행7");
			}
			
		};
		chatThread.setName("chat-thread");
		chatThread.start();

	}

}
