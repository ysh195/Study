package ch08.sec05;

public class RemoteControlEx {

	public static void main(String[] args) {
		
		RemoteControl rc;
		// System.out.println(rc.MAX_VOLUME + "" + RemoteControl.MAX_VOLUME); 여기서는 아직 클래스와 변수명만 정했고, 내용물이 없는 시점. 그래서 rc.을 쓸 수 없음
		// 하지만 RemoteControl.MAX_VOLUME은 가능
		
		rc = new Television();
		// System.out.println(rc.MAX_VOLUME + "" + RemoteControl.MAX_VOLUME); 이제 내용물이 채워졌으니 rc. 사용 가능
		rc.turnOn();
		rc.setVolume(70);
		rc.setMute();
		rc.setMute();
		rc.turnOff();
		
		System.out.println("=====================");
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute();
		rc.turnOff();
		
		System.out.println("=====================");
		
		RemoteControl.changeBattery();
		
		rc.setMute();

	}

}
