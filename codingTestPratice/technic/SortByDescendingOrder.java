package one;

import java.util.Scanner;

public class SortByDescendingOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] A = str.toCharArray();
		
		for(int i=0; i<str.length(); i++) {
			int max = i;
			for(int j = i+1; j<str.length(); j++) {
				if(A[j] > A[max]) {
					max = j;
				}
			}
			if(A[i]<A[max]) {
				int temp = A[i];
				A[i] = A[max];
				A[max] = (char)temp;
			}
		}
		for(int i=0; i<str.length(); i++) {
			System.out.println(A[i]);
		}

	}

}
