package ch14.sec06;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory1(int memory) { // 동기화 메서드
		System.out.println("메모리1 실행");
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+ " : " + this.memory);
		// Thread.currentThread()는 그 자체로 무슨 스레드가 아니라,
		// 지금 실행 중인 스레드의 이름 출력용으로 가져온 듯.
		// 그러면 이 메서드를 포함하거나 사용하는 스레드의 이름과 무관한 스레드의 이름 출력.
	}
	
	public void setMemory2(int memory) {
		synchronized(this){ // 동기화 블록
			System.out.println("메모리2 실행");
			this.memory = memory;
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+ " : " + this.memory);	
		}		
	}
}
