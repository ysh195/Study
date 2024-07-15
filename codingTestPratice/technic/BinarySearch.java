package one;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 이진탐색 : 크기 순으로 정렬된 숫자의 배열에서 중앙값을 기준으로 찾는 값의 위치를 반으로 줄여나가는 방식
 * 
 * N개의 정수 A[1], A[2], ..., A[N]이 주어졌을 때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 
 * 1번째 줄에는 자연수 N(1 <= N <= 100,000),
 * 그 다음 줄에는 N개의 정수 A[1], A[2], ..., A[N]이 주어진다.
 * 그 다음 줄에는 M(1 <= M <= 100,000),
 * 그 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A 안에 존재하는지 알아내면 된다. 모든 정수의 범위는 ((-2)^31 이상 ~ 2^31 이하)이다.
 * 
 * M개의 줄에 답을 출력한다. 존재하면 1, 존재하지 않으면 0을 출력한다.
 */

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		
		int M =sc.nextInt();
		for(int i=0; i<M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			int start = 0;
			int end = A.length -1;
			
			while(start <= end) {
				int midi = (start + end) / 2;
				int midV = A[midi];
				
				if(midV > target) {
					end = midi - 1;
				}
				else if(midV < target) {
					start = midi +1;
				}
				else {
					find = true;
					break;
				}
			}
			
			if(find) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}

}
