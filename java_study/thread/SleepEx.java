package ch14.sec05;

public class SleepEx {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			System.out.println("삡");
			try {
				Thread.sleep(1000); // 슬립은 시간 기준
			}
			catch(InterruptedException e) {}
		}

	}

}
