package ch01;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 문제 :
 * N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
 * 1번째 줄에 숫자 N(1<= N <= 1,000,000)이 출력되고, 2번째 줄부터는 N개의 줄에 각각 숫자가 주어진다. 이 수는 절대값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 입력 예시 :
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 * 
 * 출력 예시 :
 * 1
 * 2
 * 3
 * 4
 * 5
 */

/*
 * 풀이 :
 * 1. 첫번재 줄에 입력되며 몇 개의 줄이 생성될 지 결정할 숫자, N을 난수로 생성한다.
 * 2. 해당 갯수에 맞는 배열을 준비한다.
 * 3. for문으로 배열에 값을 입력한다.
 * 3-1. 난수를 사용해서 1/2의 확률로 음수가 되도록 한다.
 * 4. 준비된 숫자들을 출력한다.
 * 4-1. 첫째 줄에 N을 출력한다.
 * 4-2. Arrays.stream()을 이용해서 배열 내에 저장된 숫자들을 출력한다.
 * 4-3. int로 sorted()를 사용할 수 있지만, 내림차순으로 출력된다. 오름차순으로 출력해야 하므로 sorted(Comparator.reverseOrder())를 사용해야 한다
 * 4-4. 하지만 int는 Comparator.reverseOrder()를 사용할 수 없다.
 * 4-5. boxed()를 사용함으로써 int를 Integer로 전환하여 sorted(Comparator.reverseOrder())를 사용할 수 있게 한다.
 * 4-6. forEach로 정렬된 배열 내의 요소를 출력한다.
 */

// 처음에는 난수 생성 > 배열 구성 > Arrays.stream.sorted로 쉽게 끝날 줄 알았는데,
// "오름차순"으로 정렬이 문제였음.
// boxed로 Integer 전환하여 Comparator.reverseOrder를 사용할 수 있게 하는 것이 핵심.

// 코딩테스트에서 1억번의 연산을 대략 1초로 보고, 이 테스트의 시간 제한은 2초니까 2억번의 연산 안에 결과가 나와야 함.
// 근데 스레드를 이용하지 않는 한 대부분의 계산은 거의 동시에 병렬 처리되니까, 단순히 반복문이 많은 것은 문제가 되지 않고, 반복문이 여러 개 중첩될수록 문제가 됨. 

public class SortNumbers {

	public static void main(String[] args) {
		
		int N = (int)(Math.random()*1000000)+1;
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			
			arr[i] = (int)(Math.random()*1000000)+1;
			
			if((Math.random()*2) >= 1) {
				arr[i] = arr[i]*(-1);
			}			
		}
		
		System.out.println(N);
		
		Arrays.stream(arr)
		.distinct()
		.boxed()
		.sorted(Comparator.reverseOrder())
		.forEach(n -> System.out.println(n));

	}

}
