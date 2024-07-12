package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 문제 :
 * 다음과 같은 기능을 가진 힙 구현.
 * 배열에 정수 x를 넣으면, 배열에서 절대값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다. (단, x != 0)
 * 절대값이 가장 작은 값이 여러 개일 경우에는 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 처음에는 비어 있는 배열로 시작할 것.
 */

public class AbsHeap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> { // 큐를 선언하면서 입력 및 저장 방식을 커스텀
			int first_abs = Math.abs(o1); // 숫자 2개를 절대값으로 저장
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs) { // 만약 절대값이 같으면 
				return (o1 > o2) ? 1 : -1; 그냥 값의 대소 비교
			}
			else {
				return first_abs - second_abs; // 절대값이 같지 않으면 절대값으로 비교
			}
			// 이런 방식으로 크기를 비교해서 compare에 적용함
		});
		
		for(int i=0; i<N; i++) { 
			int request = Integer.parseInt(br.readLine()); // 입력 받자마자 바로 인트로 변환해서 저장
			if(request == 0) { // 만약 0을 입력 받았으면
				if(MyQueue.isEmpty()) { // 그리고 큐가 현재 비어 있으면
					System.out.println("0"); // 0을 출력
				}
				else {
					System.out.println(MyQueue.poll()); // 아니면 첫번째 내용물 출력. 큐니까 앞에서부터 나옴
				}					
			}
			else {
				MyQueue.add(request); // 입력 받은 게 0이 아니면 해당 값을 저장
			}
		}
	}

}
