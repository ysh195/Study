package ch04;

import java.util.Scanner;

/*
 * 입력된 숫자들을 오름차순으로 정렬하고, 각 숫자들 사이의 차이의 합을 구하는 프로그램을 작성하시오.
 */

public class InsertionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			int insert_point = i;
			int insert_value = A[i];
			
			for(int j=i-1; j>=0; j--) {
				if(A[j] < A[i]) {
					insert_point = j+1;
					break;
				}
				if(j==0) {
					insert_point = 0;
				}
				
			}
			
			
			
			for(int j=i; j>insert_point; j--) {
				A[j] = A[j-1];
			}
			
			A[insert_point] = insert_value;
		}
		
		S[0] = A[0];
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += S[i];
		}
		
		System.out.println(sum);

	}

}
