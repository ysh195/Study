package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제 :
 * N명의 사람들에게 0번부터 N-1의 번호가 매겨져 있고, 일부 사람들은 친구들이다.
 * 다음과 같은 친구관계가 존재하는지 확인하는 프로그램을 작성하시오.
 * - A와 B는 친구다.
 * - B와 C는 친구다.
 * - C와 D는 친구다.
 * - D와 E는 친구다.
 * (= 나로서는 잘 이해가 안 되는 개념이지만, 심도 5 이상의 그래프가 존재하는지 찾는 것이라고 함)
 *
 * 입력 :
 * 1번째 줄에는 사람의 수 N과 친구 관계의 수 M이 주어진다. (5 <= N <= 2,000), (1 <= M <= 2,000)
 * 2번째 줄부터 M개의 줄에 정수 a와 b가 주어지며, 해당 번호를 가진 사람들끼리 친구임을 의미한다.
 * 단, 같은 친구 관계는 2번 이상 주어지지 않는다.
 * 
 * 출력 :
 * 5명 이상이 포함된 친구 그룹이 존재하면 1, 존재하지 않으면 0을 출력한다.
 * 
 * 풀이 :
 * 1. 숫자 입력에 사용할 BufferedReader를 준비한다.
 * 2. 띄어쓰기로 구분된 숫자 2개를 문자열로 입력 받고, 바로 " "를 기준으로 구분해 배열로 저장한다.
 * 3. 배열의 값을 숫자로 변환해서 첫번째 값은 N에 저장하고, 두번째 값은 M에 저장한다. 두 값을 제한 범위에 맞처 조정한다.
 * 4. 최종적으로 출력할 숫자 tf(true / false)를 준비한다. 그리고 그룹의 크기는 곧 연속 이동 횟수이므로, 그 이동 횟수를 카운트할 movecount를 준비한다.
 * 5. 각 숫자들의 관계를 저장할 list의 배열 arr를 준비한다.
 *   그리고 선언만 한 상태에서 그 배열에 저장된 것은 list가 아니라 null이므로,
 *   for문을 사용해서 각 배열에 new list를 넣어준다.  
 *   각 숫자들의 관계를 단순하게 list 내의 요소로서 표현하고자 한다.
 *   예를 들어 arr[1]에 저장된 list가 [2, 3, 4]를 요소로 가지고 있다면, [1과 2], [1과 3], [1과 4]가 서로 연결되어 있음을 의미한다.
 * 6. 각 관계에 해당하는 숫자들을 2번과 같이 입력 받고 저장한다.
 *    이것들도 오차 범위나 중복 여부를 체크하고 싶지만 그러면 실행횟수 소모가 너무 커서 그냥 넘어간다.
 * 7. 처음 시작 숫자들을 저장할 initials를 준비한다.
 * 	  친구가 아예 없어서 size = 0인 애들은 저장하지 않는다.
 *    index값이 곧 그 숫자이므로 arr[i]가 아니라 i를 저장해야 한다.
 * 8. for문을 다음과 같이 진행한다. 그리고 내부의 다른 for문 진행 중에도 신속하게 정지시킬 수 있도록 process : 를 붙인다. 
 * 8-1. initials에 저장된 숫자들을 불러와서 사용하므로, initials의 사이즈만큼 반복한다.
 * 8-2. 탐색 중인 숫자들을 저장할 exploringN와 그 숫자들의 index를 저장할 exploringI를 준비한다. 그리고 요소를 후입선출해야 하므로 Stack으로 구현한다.
 * 8-3. 현재 진행 중인 숫자를 저장할 next를 준비하고, next에 탐색을 시작할 숫자 initials.get(i)를 입력한다.
 * 8-4. exploringN에 현재 탐색 중인 값인 next를, exploringI에 그 index값인 i를 저장한다.
 * 8-5. 초기값은 이동하는 것이 확정이므로, movecount를 늘린다.
 * 8-6. 다음과 같이 for문을 실행한다.
 * 8-6-1. arr[next] 안에 있는 값으로 반복을 모두 돌리고 난 다음의 절차를 위해 반복의 범위를 arr[next].size()+1로 설정한다.
 * 8-6-2. 중간에 문제가 없다면 항상 이 반복문이 시작은 한다. 그러니 movecount가 5 이상인지 시작 시점에서 체크한다.
 *        만약 5이상이면, tf = 1로 하고 즉시 모든 절차를 중지한다.
 * 8-6-3. 만약 j값이 arr[next].size()에 도달한다면?
 *        뒤의 내용에서 확인할 수 있지만, 이동할 수 있는 값을 찾으면
 *        그 즉시 next를 수정하고 j=0으로 바꿔서 같은 for문이지만 사실상 새롭게 for문을 시작하는 것이나 다름이 없게 된다.
 *        근데 모든 값을 다 둘러보고도 새롭게 시작하는 것이 하나도 없어서 끝에 도달했다? 그럼 여기서는 더 이상 볼 게 없는 것이다.
 *        따라서 뒤로 다시 돌아가야 한다.
 * 8-6-3-1. 현재 진행 중인 숫자와 index를 버리고, next와 j에는 이전의 값을 입력한다.
 *          뒤로 돌아가므로 movecount를 줄인다.
 *         이 상태로 continue를 하면 이전에 진행 중이던 시점으로 다시 돌아간다. continue로 돌아가면서 j++ 되니까 딱 이전의 시점의 직후부터 이어서 하게 된다.
 * 8-6-3-2. 그런데 여기서 오류가 발생할 수도 있다.
 *          exploringN와 exploringI에서 값을 2번 제거하기 때문에 상황에 따라서는 제거할 값이 없어서 오류가 발생할 수도 있다.
 *          이러한 오류 발생은 더이상 반복을 진행할 수 없을 만큼 아무것도 찾지 못한 경우에 발생하기 때문에, break로 이번 회차를 종료한다.
 * 8-6-4. 만약 현재 진행 중인 값 arr[next].get(j)가 exploringN에 포함된 값이라면 더 이상 진행하지 않고 다음으로 넘어간다.
 * 8-6-5. 위의 모든 조건들을 무사히 통과했다면, 현재 진행 중인 숫자 arr[next].get(j)는 이동할 수 있는 새로운 번호이다.
 * 8-6-6. next에 현재 진행 중인 숫자 arr[next].get(j)을 저장해서 다음 회차에서는 새로운 숫자와 연관된 숫자를 찾도록 한다.
 * 8-6-7. exploringN에 next를 저장하고, exploringI에 현재의 j값을 저장해서 어느 번호에서 어디까지 진행했는지를 기록한다.
 * 8-6-8. movecount를 늘린다.
 * 8-6-9. 그리고 j = -1 로 한다. 회차가 넘어감에 따라 j++가 되면 j=0이 된다.
 *       next에 따라 탐색 범위가 완전히 달라지는데, next에 새로운 값을 덮어씌웠고 j=0이므로,
 *       다음 회차는 아예 다른 숫자에 대해서 탐색하게 된다.
 *       같은 for문이지만 아예 새로운 값을 대상으로 for문을 사용한 것과 같아진다.
 * 9. 결과를 출력한다.
 * 
 */

import java.util.LinkedList;
import java.util.Stack;

public class ResearchRelationship {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		N = Math.min(2000, Math.max(5, N));
		M = Math.min(2000, Math.max(1, M));
		
		int tf = 0;
		int movecount = 0;
	
		LinkedList<Integer>[] arr = new LinkedList[N];
		for(int i=0; i<N; i++) {
			arr[i] = new LinkedList<Integer>();
		}

		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr[a].add(b);
			arr[b].add(a);
								
		}
				
		LinkedList<Integer> initials = new LinkedList<>();
		
		for(int i=0; i<N; i++) { // 겹치는 거 중복 입력 막으려고 최초로 검색할 숫자 저장
			if(arr[i].size() != 0) {
				initials.add(i);
			}
		}
		
		process : for(int i=0; i<initials.size(); i++) {
			Stack<Integer> exploringN = new Stack<>();
			Stack<Integer> exploringI = new Stack<>();
			int next = initials.get(i);
			// 여기서는 어차피 인덱스로 돌아가니까 중복 체크 없이 감. 그리고 위에서 저렇게 저장해서 중복 같은 거 없음
			exploringN.add(next);
			exploringI.add(i);
			movecount++;
					
			
			for(int j=0; j<arr[next].size()+1; j++) { // 일부러 size+1로 해서 최대값을 size로 하고
				
				if(movecount >= 5) {
					tf = 1;
					break process;
				}
				
				if(j == arr[next].size()) { // j값이 size에 도달하면 어차피 더이상 인덱스가 존재하지도 않고 끝이니까 여기까지 오면 이전 값으로 돌아가도록.
					try {
						exploringN.pop();
						exploringI.pop();
						next = exploringN.pop();			
						j = exploringI.pop();
						movecount--;
						
						continue;	
					}
					catch(Exception e) {
						break;
					}
					
				}
				
				if(exploringN.contains(arr[next].get(j))) { // 양쪽 모두에 값을 넣어줬으니 서로 연결됐다면 get이 불가능할 일은 없음
					continue;
				}
				
				next = arr[next].get(j);
				exploringN.add(next);
				exploringI.add(j);
				movecount++;
				j=-1; // j를 0부터 다시 시작시켜야 하는데, 다음 회차로 넘어가면서 j++ 되니까
				
			}
		}
		
		System.out.println(tf);

	}

}
