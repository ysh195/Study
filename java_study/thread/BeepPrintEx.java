package ch14.sec03;

import java.awt.Toolkit;

public class BeepPrintEx {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					System.out.println("띠링~!");
					try {
						Thread.sleep(500);
					}catch(Exception e) {}
				}
			}
			
		});
		
		thread.start();
		// thread 실행 중에는 thread 내부의 인스턴스들이 유효한 것으로 보네. 그래서 소리와 메시지를 스레드 안과 밖에 각각 둬도 상관이 없음. 동시 실행임
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			System.out.print("소리가 출력됩니다.");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
		
	}

}
