package ch14.sec06;

public class WorkObj {
	public synchronized void methodA() { // 동기화메소드
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + "의 methodA 실행");
		notify(); // 근데 wait으로 멈춘 애만 실행대기 상태로 만듦. 그리고 기껏 깨워줬지만 이게 싱크로 메서드라 어차피 이거 끝날 때까지 그건 실행 안 함
		try {
			System.out.println("이어지나?");
			wait(); // 자신을 일시정지 상태로 만듦
			System.out.println("이건 나오나?"); // 밑에 저게 나오는 거 보니 wait으로 멈추면 그 시점에서 일을 끝내고, 나중에 다시 이어서 진행함
		}
		catch(InterruptedException e) {}
	}

	public synchronized void methodB() { // 동기화메소드		
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + "의 methodB 실행");
		System.out.println("이게 메소드B와 이건 나오나 사이에 나오면 중간에 멈췄다가 다시 하는 거임");
		notify(); // 다른 스레드를 실행대기 상태로 만듦
		try {
			wait(); // 자신을 일시정지 상태로 만듦
		}
		catch(InterruptedException e) {}
	}

}
