package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제 :
 * N명의 사람들에게 0번부터 N-1의 번호가 매겨져 있고, 일부 사람들은 친구들이다.
 * 서로 직간접적으로 친구관계에 있는 친구들을 친구 그룹이라고 할 때,
 * 5명 이상이 포함된 친구 그룹이 존재하는지 여부를 구하는 프로그램을 작성하시오.
 * 
 * 입력 :
 * 1번째 줄에는 사람의 수 N과 친구 관계의 수 M이 주어진다. (5 <= N <= 2,000), (1 <= M <= 2,000)
 * 2번째 줄부터 M개의 줄에 정수 a와 b가 주어지며, 해당 번호를 가진 사람들끼리 친구임을 의미한다.
 * 단, 같은 친구 관계는 2번 이상 주어지지 않는다.
 * 
 * 출력 :
 * 5명 이상이 포함된 친구 그룹이 존재하면 1, 존재하지 않으면 0을 출력한다.
 */

// 이미 탐색한 부분을 어떻게 배제하거나 풀어줄 지에 대한 고민이 더 필요함.

import java.util.LinkedList;

public class ResearchRelationship {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int tf = 0;
		
		int N = Integer.parseInt(input[0]);
		N = Math.min(2000, Math.max(5, N));
		
		int M = Integer.parseInt(input[1]);
		M = Math.min(2000, Math.max(1, M));
		
		LinkedList<Integer>[] arr = new LinkedList[N];
		for(int i=0; i<N; i++) {
			arr[i] = new LinkedList<Integer>();
		}
				
		LinkedList<Integer> nexttarget = new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arr[a].add(b);
			arr[b].add(a);
								
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i].size() != 0) {
				nexttarget.add(i);
			}
		}
		process : for(int s : nexttarget) {
			LinkedList<Integer> exploring = new LinkedList<>(); // 미리 선언하면 나중에 귀찮게 초기화 해야 하니까 여기서 선언
			int movecount = 0; // 마찬가지
			int next = nexttarget.peekFirst();
			// 이 숫자로 여러 번 순환할 수도 있으니 poll이 아니라 peek
			// 그렇게 반복하다가 진짜 이쪽 루트 개척 다 끝나면 마지막 순환은 시작하자마자 다 끝나서 이 값이 explored에 저장됨. 그러면 그 다음 순환에 삭제됨

			exploring.add(next);
			movecount++;
			/*
			 * 2중 반복문을 만들고, 맨 안쪽의 반복문이 끝나면 뭔가 교체가 일어나도록 구성해야 하나?
			 */
			for(int j=0; j<arr[next].size(); j++) {
				if(exploring.contains(arr[next].get(j))) { // 넥스트가 함부러 갱신되면 계산 다 꼬이니까 미리 커트
					continue;
				}
				// 안전한 애니까
				int temp = next;
				next = arr[next].get(j); // 넥스트 갱신하고
				exploring.add(next); // 현재 진행중인 것에 추가하고
				movecount++; // 움직였다고 카운트 늘리고
				
				if(movecount >= 5) { // 만약 모두 발견되면
					tf = 1; // 출력할 카운트 수정하고
					break process; // 모든 프로세스 종료
				}
				
				if(j == arr[next].size()-1) {
					next = temp;
				}
			}

		}
		
		System.out.println(tf);

	}

}
