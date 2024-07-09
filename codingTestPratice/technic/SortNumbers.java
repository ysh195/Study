package ch04;

import java.util.Scanner;

/*
 * 문제 :
 * N개의 수가 주어졌을 때 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입력 :
 * 1번째 줄에 수의 개수 N이, (1 <= N <= 1000)
 * 2번째 줄부터 N개의 줄에 숫자가 주어진다.
 * 이 수는 절대값이 1000보다 작거나 같은 정수이다. (-1000 <= x <= 1000)
 * 
 */

public class SortNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N-1; i++) { // for문을 2중으로 돌려서 매 칸마다 교체되도록
			for(int j=0; j<N-1-i; j++) { // 반복 횟수에서 현재의 i값을 빼서 너무 뒤로 가지 않도록 함
				if(A[j] > A[j+1]) { // 앞에 있는 배열의 값보다 바로 오른쪽에 있는 배열의 값이 더 작으면 바로 바꾸기.
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}

	}

}
