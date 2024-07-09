package ch04;

import java.util.Scanner;

/*
 * 입력된 숫자들을 오름차순으로 정렬하고, 각 숫자들 사이의 차이의 합을 구하는 프로그램을 작성하시오.
 */

// 내 방법이 훨씬 간결하고 직관적이지 않나? 반복문 사용 횟수도 더 적을 것 같은데

public class InsertionSort2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] intArr = new int[N];

		
		for(int i=0; i<N; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for(int i=N-1; i>0; i--) {
			for(int j=i; j>0; j-- ) {
				if(intArr[j] >= intArr[j-1]) {
					continue;
				}
				else {
					int temp = intArr[j];
					intArr[j] = intArr[j-1];
					intArr[j-1] = temp;					
				}
			}
		}
		
		int total = 0;
		
		for(int i=0; i<N-1; i++) {
			total += (intArr[i+1]-intArr[i]);
		}
		
		System.out.println(total);
	}

}
