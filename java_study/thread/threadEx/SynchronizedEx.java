package ch14.sec06;

public class SynchronizedEx {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
		
		// 각기 다른 스레드가 실행한 동기화 메서드와 동기화 블록 중에는 다른 스레드가 작업을 진행하지 못함.
		// 따라서 user2thread가 실행되긴 했지만,
		// user1thread의 setmemory1 메서드 실행 중에는 작업을 할 수가 없어서 sleep조차 진행하지 못하였고,
		// 결과적으로 4초 뒤에나 user2thread의 문구가 출력됨
	}
}

/*
 *  user1Thread |            동기화 메서드 { (슬립 2초) -> 메시지 출력 }                   | (작업 끝) 
 * 	user2Thread | 동기화 메서드 중에는 동기화 블럭 메서드 사용 불가. 작업 진행 못하고 기다리는 중    | 동기화 블럭 { (슬립 2초) -> 메시지 출력 }
 */

/*

calc를 따로 내부에서 익명 개체로 만들어서 쓰면 통일성이 없어서 다른 상황이 됨
같이 실행했는데 서로를 방해할 수 없어서 서로 2초씩 기다려주고 한 번에 출력됨

유저1 런
메모리1 실행
유저2 런
메모리2 실행
User2Thread : 100
User1Thread : 100

 */