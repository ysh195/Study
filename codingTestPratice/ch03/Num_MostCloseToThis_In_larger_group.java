package one;

/*
 * 문제 : 
 * 크기가 N인 수열 A = [A1, A2, A3, ..., AN]이 있다.
 * 수열의 각 원소 Ai보다 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수(오큰수)를 구하고자 한다. 단, 이러한 수가 없을 때의 오큰수는 -1이다.
 * 예를 들어, A = [3,5,2,7]일 때 첫번째 오큰수 = 5, 두번째 오큰수 = 7, 세번째 오큰수 = 7, 네번째 오큰수 = -1이다.
 * 
 * 입력 : 
 * 1번째 줄에는 수열 A의 크기인 N(1 <= N <= 1,000,000),
 * 2번째 줄에는 수열 A의 원소 A1, A2, ..., AN이 주어진다. (1 <= Ai <= 1,000,000)
 * 
 * 출력 :
 * 총 N개의 수(첫번째 오큰수, 두번째 오큰수, ..., N번째 오큰수)를 공백으로 구분해 출력한다.
 *  
 */

// 이번에는 문제 보자마자 풀이가 생각나긴 했는데, 계속 '이게 맞나?' 싶어서 코드를 엄청 바꾸는 등 머릿속이 복잡하고 정리가 안 됨.
// '이렇게 하면 될 것 같다' 싶은 방향으로 가다가도 갑자기 생각이 꼬여서 아닌 것 같아짐.
// 솔직히 이게 정답인지 아닌지도 잘 모르겠고, 스스로도 풀이를 설명하기 어려움.
// 지금까지는 그냥 머릿속에 떠오르는대로 적당히 쳐서 풀었는데 이제 간략한 코드 흐름과 구성을 글로 적으면서 정리하고 쳐야겠음

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.TreeSet;

public class Num_MostCloseToThis_In_larger_group {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] inputArr = bf.readLine().split(" ");
		bf.close();
		int[] numbers = new int[N];

		int[] result = new int[N];
		TreeSet<Integer> treeSet = new TreeSet<>();
		LinkedList<Integer> list = new LinkedList<>();

		for(int i=0; i<N; i++) {
			try {
				numbers[i] = Integer.parseInt(inputArr[i]);
			}
			catch(Exception e) {
				numbers[i] = 0; 
			}
		}
		
		int nowMax = numbers[N-1];
		list.add(numbers[N-1]);
		result[N-1] = -1; 
		
		for(int i=(N-2); i>=0; i--) {
			
			if(nowMax < numbers[i]) { // 지금 이 숫자가 가장 크면
				
				nowMax = numbers[i]; // 최대값 수정
				list = new LinkedList<>(); // 이전 값들 필요 없으니 아예 초기화				
			}
			else { // 저장된 값들 중에서 이것보다 큰 게 있으면
				LinkedList<Integer> copylist = list; // 현재 리스트 복사. 왜냐하면 이번 값 계산 때문에 막 빼버렸다간 다음 회차에 계산이 불가능하니까
				while(copylist.size() > 0) {
					if(copylist.getLast() > numbers[i]) { // 가장 최근 값이 현재값보다 크면
						result[i] = copylist.getLast(); // 결과값만 입력하고 끝
						break;
					}
					else {
						copylist.removeLast(); // 가장 최근값 삭제. 저장된 값들 중에서 이것보다 큰 게 있다고 했으니 계속 돌리다보면 나옴.
					}
				}				
			}
			
			list.add(numbers[i]); // 어떻게 쓰일 지 모르니 어쨌든 이번 값 추가			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i : result) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();

	}

}
