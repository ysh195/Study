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
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs) {
				return (o1 > o2) ? 1 : -1;
			}
			else {
				return first_abs - second_abs;
			}
		});
		
		for(int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(MyQueue.isEmpty()) {
					System.out.println("0");
				}
				else {
					System.out.println(MyQueue.poll());
				}					
			}
			else {
				MyQueue.add(request);
			}
		}
	}

}
