package one;
/*
 * 문제 : 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
 * 
 * 입력 :
 * 1번째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. (단, 1 <= N, M <= 100000)
 * 2번째 줄에는 N개의 숫자가 주어진다.
 * 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
 * 
 * 예시)
 * 5	3
 * 5	4	3	2	1
 * 1	3
 * 2	4
 * 5	5
 * 
 * 출력 :
 * 총 M개의 줄에 입력으로 주어진 i번째 수에서 j번째 수까지의 합을 출력한다.
 * 
 * 예시)
 * 12
 * 9
 * 1
 */

/*
 * 풀이 :
 * 1. N과 M을 입력 받고, 각각 값을 보정한다.
 * 2. 각각의 숫자를 입력받을 배열을 N개만큼 준비하고, 그 숫자들의 각 구간 사이의 합계를 저장할 배열을 (N+1)개만큼 준비한다.
 * 3. 각각의 숫자를 입력 받으면서, total[i]은 이전까지의 배열의 합을 저장하고 있는 값이므로, total[i]+numN[i] = 현재 구간까지의 총 합계이다. 이것을 N만큼 반복한다.
 * 4. 다음을 반복한다
 * 4-1. 구간 i와 j를 입력 받으면서 각각 값을 보정한다. j가 i보다 작으면 구간의 합이라고 할 수 없으므로, j가 항상 (i+1)보다 같거나 크도록 설정한다.
 * 4-2. 구간 i와 j 사이의 값을 출력한다.
 * 4-3. 근데 이렇게 하면 입력과 출력이 반복되지 않나? 출력끼리만 깔끔하게 뽑지 않아도 되나?
 */

import java.util.Scanner;

public class SumSection {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(100000, Math.max(1, N));
		
		int M = sc1.nextInt();
		M = Math.min(100000, Math.max(1, M));
		
		int[] numN = new int[N];
		long[] total = new long[N+1]; 
		
		for(int i=0; i<N; i++) {
			numN[i] = sc2.nextInt();
			total[i+1] = total[i] + numN[i];
		}
		
		for(int a=0; a<M; a++) {
			int i = sc3.nextInt();
			i = Math.max(i, 0);
			int j = sc4.nextInt();
			j = Math.max(j, i+1);
			
			System.out.println(total[j] - total[i]);
			
		}
	}

}
