package one;

import java.util.Scanner;

/*
 * 문제:
 * 세준이는 자신의 시험 점수를 조작하기로 결심하였다. 자신의 시험 점수 중 최댓값을 고르고, 그 최댓값을 M이라 할 때 모든 점수를 점수/M * 100으로 고쳤다.
 * 이때, 세준이의 시험 성적의 평균을 구하는 프로그램을 작성하라
 * 
 * 입력:
 * 1번째 줄에 시험을 본 과목의 개수 N이 주어진다. (N <= 1000)
 * 2번째 줄에 세준이의 현재 성적이 주어진다. 해당 값은 100보다 작거나 같은, 음이 아닌 정수이고, 적어도 1개의 값은 0보다 크다.
 * (0 <= score <= 100), (1 <= totalScore) // 그럼 과목은 1개 이상 존재한다는 것인데, 1의 범위를 보정해야 하나?
 * 
 * 출력:
 * 1번째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대 오차 또는 상대 오차 0.01까지 정답으로 인정한다.
 */

/*
 * 풀이:
 * 1. 과목의 개수 N을 입력하고, 제한된 범위에 알맞게 조정한다.
 * 2. 합계를 저장할 숫자 total과 각 입력 받은 점수를 저장할 배열, 그리고 최댓값을 저장할 M을 준비한다. 
 * 3. for문으로 N번만큼 아래의 작업을 반복한다.
 * 3-1. 점수를 입력 받으면서 숫자를 보정한다.
 * 3-2. 그 중에서 값을 비교하면서 최댓값을 저장한다.
 * 3-3. 그리고 total에 값을 더한다.
 * 3-4. 여기서 x1 * d + x2 * d + x3 * d + x4 * d... = d * (x1 + x2 + x3 + x4...) 이므로 나중에 한 번에 계산한다.
 * 4. 입력 조건에 따라 total은 최소 1이기 때문에, 1미만이 나오지 않도록 보정한다.
 * 5. total을 최대값으로 나누고 100을 곱해서 성적이 변형됨을 반영한다.
 * 6. 그리고 N으로 나눠서 평균을 낸다.
 */

// 이건 별로 어렵지 않았음 문제를 푸는 것보다 이걸 최대한 간략하게 코드를 정리하는 게 더 오래 걸림 

public class Average {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(1000, Math.max(N, 1));
		
		float total = 0;
		
		float[] inputN = new float[N];
		float M = 0;
		
		for(int i=0; i<N; i++) {
			inputN[i] = sc2.nextInt();
			inputN[i] = Math.min(100, Math.max(inputN[i], 0));
			M = Math.max(M, inputN[i]);
			total += inputN[i];
		}
		
		total = (Math.max(total, 1)/M)*100;
		
		System.out.println(total/N);
		
	}

}
