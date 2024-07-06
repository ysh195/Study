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
 * 1. 첫번재 줄에 입력되며 몇 개의 숫자가 생성될 지 결정할 숫자, N을 난수로 생성한다.
 * 2. 해당 갯수에 맞는 배열을 준비한다.
 * 2-1. 단, 숫자 타입의 배열일 경우, 0은 제대로 표기되지 않으므로 반드시 String 타입으로 한다
 * 3. for문으로 배열에 값을 입력한다.
 * 3-1. char 유니코드를 사용해서 숫자를 생성한 다음, String 타입으로 변환하여 배열에 저장한다.
 * 3-2. 해당 숫자를 int로 변환해서 total에 더한다.
 * 3-3. 정해진 숫자가 2번째 줄에 한 줄로 입력되도록 print로 출력한다.
 * 4. 서로 값이 섞이지 않도록 띄워준 후, 마지막 결과값을 출력한다.
 */

// "한 줄로 입력한다" 그 한 문장 때문에 숫자를 String타입으로 생성해야 했고, 유니코드 char를 이용해야 했음

public class SumNumbers1 {

	public static void main(String[] args) {
		
		int N = (int)(Math.random()*10)+1;
		String[] arr = new String[N];
		int total = 0;
		
		System.out.println(N);
		
		for(int i=0; i<N; i++) {
			arr[i] = String.valueOf((char)(Math.random()*9+48));
			total += Integer.parseInt(arr[i]);
			System.out.print(arr[i]);
		}
		
		System.out.println();
		System.out.println(total);

	}

}
