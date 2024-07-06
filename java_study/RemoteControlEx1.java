package ch08.sec02;

public class RemoteControlEx1 {

	public static void main(String[] args) {
		
		RemoteControl rc = new Television(); 
		rc.turnOn();
		
		RemoteControl ad = new Audio();
		ad.turnOn();
		
		rc = new Audio();
		rc.turnOn();
		
		// 생성자가 다른 것들보다 훨씬 간략함
		// 인터페이스 하나 불러오면 거기에 연결된 다른 클래스도 연결 가능.
		// 클래스 타입 자동 변환
		// 클래스 대입 및 전환도 자유로움

	}

}
