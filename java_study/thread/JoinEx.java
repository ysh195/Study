package ch14.sec05;

public class JoinEx {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join(); // 조인은 자기 스레드 진행 중에 다른 스레드의 조인을 가져와서 실행시키는 것. 조인이 실행되면 조인 스레드를 가져온 다른 스레드의 작업이 끝날 때까지 자신을 멈춤 
		} // 서로 상속관계면 누가 멈추나
		catch(InterruptedException e) {}
		System.out.println(sumThread.getSum());

	}

}
