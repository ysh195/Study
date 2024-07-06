package ch03;

/*
 * 문제 :
 * 1번째 줄에 숫자의 갯수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
 * 2번째 줄에 주어진 숫자들을 모두 합해 출력하는 프로그램을 작성하시오.
 * 
 * 입력 : 
 * 5
 * 54321
 * 
 * 출력 :
 * 15
 */

/*
 * 풀이 : 
 * 1. 입력을 2번 받아야 하니 스캐너 2개 준비. 근데 입력 받는 건 출력 안 해도 되는 건가?
 * 2. 첫번재 줄에 입력되며 몇 개의 숫자가 생성될 지 결정할 숫자, N을 입력 받고, N이 정해진 범위를 벗어나지 않도록 조절한다.
 * 3. 두번째 줄에 입력되며 값이 더해질 숫자들을 String 타입으로 입력받는다.
 * 3-1. 해당 값이 정상적으로 입력되지 않을 경우를 대비해, null일 경우 ""로 저장하고, 그렇지 않으면 그대로 저장한다. 
 * 4. for문을 사용하면서 입력 받은 문자열의 길이가 N을 초과하는 상황을 대비해 Math.min(N, str.length()로 for의 반복 횟수를 제한한다.
 * 4-1. str에 숫자가 아닌 문자가 섞여 있을 가능성을 고려하여 try-catch로 대비한다.
 * 5. 합계를 출력한다.
 */

import java.util.Scanner;

public class SumNumbers2 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(100, Math.max(1, N));
		
		String str = sc2.nextLine();
		str = (str == null) ? "" : str;

		
		int total = 0;
		
		for(int i=0; i<Math.min(N, str.length()); i++) {
			String temp = str.substring(i, i+1);
			
			try {
			total += Integer.parseInt(temp);
			}catch(Exception e) {}			
		}

		System.out.println(total);
		

	}

}
