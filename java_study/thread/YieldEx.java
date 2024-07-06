package ch14.sec05;

public class YieldEx {

	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();
		
		try {
			Thread.sleep(5000); // 익명 클래스로 불러와서 슬립만 사용함으로써 일종의 타이머 같이 활용
		}
		catch(InterruptedException e) {}
		workThreadA.work = false; // 타이머로 설정해둔 시간이 되면 A가 멈춤. 정확히는 yield로 자기는 일 안 하고 B만 하게 내버려 둠
		
		try {
			Thread.sleep(10000);
		}
		catch(InterruptedException e) {}
		workThreadA.work = true; // 이번엔 반대로 타이머 설정해놓고 시간되면 멈춰 있던 A가 움직임
	}

}
/*
 * 스레드 A   | ------------ |                              | ---------------------------- ....
 * 스레드 B   | ------------ | ---------------------------- | ---------------------------- ....
 * 익명 스레드 | (슬립 5초)     | (A.work = false) (슬립 10초)  | (A.work = true)  
 */
