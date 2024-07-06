package one;

import java.util.Scanner;
import java.util.TreeSet;

/*
 * 코드실행 제한 시간 : 2.4초
 * 
 * 문제 :
 * N개의 수 A1, A2, A3, ..., AN과 L이 주어진다.
 * A(i-L+1) ~ Ai 중 사이의 최솟값을 D라고 할 때 D에 저장된 수를 출력하는 프로그램을 작성하시오.
 * i <= 0일 경우, Ai를 무시하고 D값을 출력하시오.
 * 
 * 입력 : 
 * 1번째 줄에 N과 L (1 <= L <= N <= 5,000,000)이 주어진다.
 * 2번째 줄에 N개의 수 Ai가 주어진다. (-1,000,000,000 <= Ai <= 1,000,000,000)
 * 
 * 출력 :
 * 1번째 줄에 Di를 공백으로 구분해 출력하시오.
 */

/*
 * 풀이 :
 * 1. 숫자 N과 L을 입력 받고, 범위에 맞게 조절한다.
 * 2. N개의 수를 입력 받기 위한 long[] inputL을 준비한다.
 * 3. for문으로 숫자를 입력 받으면서 범위에 맞게 조절한다. 오류 발생 시 0을 입력한다.
 * 4. 숫자들을 입력하고 최솟값을 간단하게 출력하기 위한 treeSet을 준비한다.
 * 5. 다음과 같이 for문을 실행한다.
 * 5-1. "i <= 0일 경우, Ai를 무시하고 D값을 출력하시오."라는 단서가 있었으니, i <= 0인 경우가 존재한다는 것이다.
 * 		따라서 {0 ~ N}이 아니라, {-L ~ (N - L)}으로 반복한다.
 * 5-2. 만약 i <= 0일 경우
 * 		- treeSet.add(inputL[i+L])로 맨 뒤부터 숫자를 추가해준다.
 * 5-3. 아니라면
 * 		- treeSet.remove(inputL[i-1])로 맨 앞부터 숫자를 제거하고,
 *		- treeSet.add(inputL[i+L])로 맨 뒤부터 숫자를 추가한다.
 * 5-4. treeSet.first()로 treeSet에 저장된 최솟값을 출력하면서, "공백으로 구분해 출력"이라고 했으니, treeSet.first() + " "을 출력한다.
 */

// treeSet에 값의 입력과 제거는 배열을 기준으로 하고, 최솟값 출력만 treeSet으로 처리 
// first() 메서드의 반복 여부는 잘 모르겠는데, 일단 대충 내부 코드를 확인해 본 바로는 반복이 아닌 것 같음. first가 반복 없이 바로 출력이라면 횟수제한도 문제 없음

public class FindMin {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(5000000, Math.max(1, N));
		
		int L = sc2.nextInt();
		L = Math.min(N, Math.max(1, L));
		
		long[] inputL = new long[N];
		for(int i=0; i<N; i++) {
			String str = sc3.next();
			try {
				inputL[i] = Long.parseLong(str);
				if(inputL[i] >= 0) {
					inputL[i] = Math.min(inputL[i], 1000000000);					
				}
				else {
					inputL[i] = Math.max(inputL[i], -1000000000);
				}				
			}
			catch(Exception e) {
				inputL[i] = 0;
			}
		}

		TreeSet<Long> treeSet = new TreeSet<>();
		
		for(int i=-L; i<(N-L); i++) {
			if(i <= 0) {
				treeSet.add(inputL[i+L]);
			}
			else {
				treeSet.remove(inputL[i-1]);
				treeSet.add(inputL[i+L]);
			}
			
			System.out.println(treeSet.first() + " ");
		}
	}

}
