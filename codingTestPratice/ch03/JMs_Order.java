package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 :
 * 대장장이가 갑옷을 만들 때 재료 2개가 들어가는데, 2가지 재료 각각의 고유 번호를 합쳐 M(1 <= M <= 10,000,000)이면 갑옷이 만들어진다.
 * 재료의 갯수 N과 숫자 M이 주어졌을 때, 완성되는 갑옷의 갯수를 구하는 프로그램을 만들어라.
 * 
 * 입력 :
 * 1번째 줄에 재료의 갯수 N(1 <= N <= 15,000)이,
 * 2번째 줄에는 갑옷을 만드는 데에 필요한 숫자 M(1 <= M <= 10,000,000)이 주어진다.
 * 3번째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 단, 고유번호는 1~100,000 사이의 자연수이다.
 * 
 * 출력 :
 * 1번째 줄에 완성되는 갑옷의 갯수를 출력한다.
 */

/*
 * 풀이 :
 * 1. 숫자 N과 M을 입력 받고, 제한 범위에 맞게 조정한다.
 * 2. N개의 재료들이 가진 각각의 고유 번호에 해당하는 숫자들을, 띄어쓰기로 구분하여 입력 받는다고 했으니, nextLine으로 입력 받는다.
 * 3. 띄어쓰기를 구분자 삼아 String을 split하여 배열로 전환하고, Arrays.stream을 사용한다.
 * 3-1. filter를 사용하여 띄어쓰기가 저장된 배열을 걸러낸다.
 * 3-2. mapToInt(Integer::parseInt)를 사용함으로써 오류 발생에 대비하며 숫자로 전환한다.
 * 3-3. 그렇게 추출한 숫자들이 제한 범위에 맞는지 확인하고, 범위를 벗어났다면 배제한다.
 * 3-4. 최종 결과값들을 List<Integer>에 저장해야 하므로, boxed()를 사용하여 Integer 타입으로 전환한다.
 * 3-5. List<Integer> intList에 모든 값을 저장한다.
 * 4. 완성되는 갑옷의 갯수를 저장할 count를 준비한다.
 * 5. for문을 사용한다.
 * 5-1. 입력에 오류가 있거나 범위에 알맞지 않는 숫자를 배제하는 과정이 있었고, 제한된 갯수를 초과하는 숫자의 입력이 있을 수도 있기 때문에
 * 		Math.min(intList.size(), N)를 통해 정상적인 계산이 가능한 범위로 for문의 반복 범위를 설정한다.
 * 5-2. 찾아야 할 숫자 int num을 준비한다. 두 개의 숫자를 더해서 M이 나와야 하는 조건이기 때문에
 	intList.get(i) + num = M
 	num = M - intList.get(i)
 * 5-3. 만약 num이 0이하의 숫자이면 이번 회차의 계산을 중단하고, 다음으로 넘어간다.
 * 5-4. intList.contains()를 사용함으로써 2중 for문을 사용하지 않고 num이 intList 내에 있는지 손쉽게 확인한다.
 * 5-5. 만약 num이 intList 존재한다면 갑옷을 만들 수 있으므로 count를 늘린다.
 * 6. 완성되는 갑옷의 갯수에 대한 count는 서로 다른 2개의 숫자를 사용하므로 항상 짝을 이루게 된다. 따라서 출력해야 하는 값은 count/2이다.
 */
public class JMs_Order {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(15000, Math.max(1, N));
		
		int M = sc2.nextInt();
		M = Math.min(10000000, Math.max(1, M));
		
		String inputStr = sc3.nextLine(); // 띄어쓰기가 필요하니까 next 쓰면 안 됨
		List<Integer> intList = Arrays.stream(inputStr.split(" "))
					.filter(s -> !s.equals(" "))
					.mapToInt(Integer::parseInt)
					.filter(n -> (1 <= n) && (n <= 100000))
					.boxed()
					.toList();
		
		int count = 0;
		
		for(int i=0; i<Math.min(intList.size(), N); i++) {
			int num = M - intList.get(i);
			
			if(num <= 0) {
				continue;
			}
			
			if(intList.contains(num)) { // 2중 for문 대신 contains 로 쉽게 찾으려고 일부러 list 사용함 
				count++;
			}		
		}
		
		System.out.println(count/2);
		
		
		
	}

}
