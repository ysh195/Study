package ch03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 :
 * 주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다. N개의 수 중 좋은 수가 총 몇 개인지 출력하시오.
 * 
 * 입력 :
 * 1번째 줄에 수의 개수 N(1 <= N <= 2000)이,
 * 2번째 줄에 N개의 수의 값(Ai)이 주어진다. (Ai는 |Ai| <= 1000000000인 정수)
 * 
 * 출력 : 
 * 좋은 수의 개수를 출력한다.
 */

/*
 * 풀이 :
 * 시간 제한 2초에 N이 2000 이하이기 때문에 2중 for문까지는 가능하다.
 * 1. 숫자 N을 입력 받고 제한 범위에 맞게 조정한다.
 * 2. 숫자들을 N번 만큼 입력 받고, 각각을 제한 범위에 맞게 조정한다.
 * 3. 입력 받은 숫자들을 내림차순으로 정렬하고, List<Long> longList에 저장한다.
 * 4. 좋은 수의 갯수를 저장할 count를 준비한다.
 * 5. for문을 다음과 같이 진행한다.
 * 5-1. longList.size()만큼 반복한다. 자연수만 있었다면 최대값을 다른 것과 더할 경우 무조건 입력된 다른 숫자가 될 수 없으나, 입력된 숫자에는 음수도 포함되어 있다.
 * 5-2. 내부에 for문을 하나 더 만들고, 반복 범위를 j < i로 제한한다. 이로써 중복 계산을 피하고, 불필요한 반복 횟수를 줄인다.
 * 5-3. 찾아야 할 값 Long num = longList.get(i) + longList.get(j)을 준비한다.
 * 5-4. list의 기능인 contains를 사용함으로써 간결하게 num이 존재하는지 파악한다.
 * 5-5. num이 존재할 경우 count를 늘린다.
 * 6. count를 출력한다. 
 */

// contains를 쓰면 for문 없이 간결하게 되는 줄 알았는데, contains 내부에 for문이 있어서 결국 for이네

public class FindGoodNumber {

	public static void main(String[] args) { // 시간 제한 2초에 N이 2000 이하이기 때문에 2중 for문까지는 가능.
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(2000, Math.max(1, N));
		
		long[] longArr = new long[N];
		for(int i=0; i<N; i++) {
			longArr[i] = sc2.nextLong();
			longArr[i] = (longArr[i] >= 0) ? Math.max(1000000000, longArr[i]) : Math.min(-1000000000, longArr[i]);
		}
		
		List<Long> longList = Arrays.stream(longArr)
							.boxed()
							.toList();
		
		int count = 0;
		
		for(int i=0; i<longList.size(); i++) {
			for(int j=0; j<i; j++) {
				Long num = longList.get(i) + longList.get(j);				
				if(longList.contains(num)) {
					count++;
				}			
			}
		}
		
		System.out.println(count);
		
	}

}
