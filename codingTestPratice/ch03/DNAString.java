package one;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 코드실행 제한 시간 : 2초
 * 
 * 문제 :
 * "A", "C", "G", "T"만을 사용하여 문자열을 구성한다.
 * 이 문자열의 일부를 비밀번호로 사용한다.
 * 이때, 비밀번호로 사용해야 하는 문자열의 일부에는 A, C, G, T가 각각 최소 x1, x2, x3, x4개만큼 포함되어야 한다.
 * 입력된 문자열 내에서 해당 조건을 만족하는 비밀번호 조합이 몇 개인지 계산하는 프로그램을 만들어라.
 * 
 * 입력 :
 * 1번째 줄에는 문자열의 길이 |S|와 비밀번호로 사용할 부분 문자열의 길이 |P|가 주어진다. (1 <= |P| <= |S| <= 1000000)
 * 2번째 줄에는 "A", "C", "G", "T"만이 사용된 문자열이 주어진다.
 * 3번째 줄에는 A, C, G, T의 최소 갯수인 x1, x2, x3, x4가 각각 공백을 사이에 두고 주어진다.
 * (단, 각각의 x1 ~ x4는 S보다 작거나 같은 음수가 아닌 정수이며, x1 ~ x4의 합계는 S보다 작거나 같다.)
 * 
 * 출력 :
 * 입력된 문자열 내에서 해당 조건을 만족하는 비밀번호 조합의 갯수를 출력한다.
 */

/*
 * 풀이 :
 * 1. 숫자 S와 P를 입력 받고 각각 범위에 맞게 조절한다.
 * 2. 전체 문자열 inputStr을 입력 받는다. 그리고 현재 문자열의 길이가 문자열의 길이의 제한인 S에 비해 부족하거나 넘치지 않도록 조절한다.
 * 3. inputStr 내의 A > 2, C > 3, G > 5, T > 7로 교체한다.
 * 4. inputStr 내의 숫자들을 모두 분리해서 double[] inputNumbers에 저장한다.
 * 5. inputNumbers보다 1칸 더 큰 double[] multipleArr를 준비한다.
 * 6. multipleArr[0] = 1로 설정하고, P-1 범위의 for문을 사용해서 multipleArr에 inputNumbers의 구간별 전체 곱을 저장한다.
 * 	  multipleArr[i+1] = inputNumbers[i] * multipleArr[i];
 * 	  원래는 끝까지 다 계산해도 상관없지만 코드 실행 횟수가 아까우니 중간에 끊고 나중에 이어서 한다.
 * 7. 각 문자의 최소 갯수를 저장할 int[] X_mins와 그에 대응하여 계산에 사용할 int[] X_minNum를 준비한다.
 * 8. for문을 다음과 같이 진행한다.
 * 8-1. A, C, G, T의 최소 갯수들을 띄어쓰기를 사이에 두고 입력 받아야 하므로, String - sc.next()로 입력 받는다.
 * 8-2. 입력 받은 문자열을 숫자열로 전환한다. 그리고 제한 범위에 맞게 조절한다.
 * 8-2-1. 만약 지금까지 입력된 값들의 합(total)과 현재의 값이 S를 초과한다면,
 * 		- 현재 값 X_mins[i]에는 S와 지금까지 입력된 값들의 합의 차이(S - total)를 저장하고,
 * 			total에 추가한다.
 * 8-2-2. 아니라면,
 * 		현재 값은 그대로 두고, total에 추가한다.
 * 8-3. 만약 오류가 발생한다면 현재 값은 0으로 한다.
 * 8-4. 계산에 사용할 숫자 n을 준비한다.
 * 8-5. switch문을 사용해 n에 적절한 값을 저장한다.
 * 8-6. X_minNum[i]에 n의 X_mins[i] 제곱값을 저장한다. X_minNum[i] = n ^ X_mins[i]
 * 9. 만약 total이 P를 초과한다면 계산이 불가능하므로 count = 0을 출력하고, 프로그램을 종료한다.
 * 10. for문을 다음과 같이 실행한다.
 * 10-1. S 크기의 문자열 내에서 P크기의 조합을 판단하므로, S 크기를 모두 조사할 필요는 없고, (S-P+1)만큼 반복하면 족하다.
 * 10-2. 중간에 끊었던 multipleArr[i+1] = inputNumbers[i] * multipleArr[i] 계산을 다시 진행한다.
 * 10-3. multipleArr[i+P]는 [i+P]까지의 inputNumbers 숫자들의 전체 곱이고, multipleArr[i]는 [i]까지의 inputNumbers 숫자들의 전체 곱이다.
 * 10-4. 따라서 그 multipleArr[i+P] / multipleArr[i]를 계산하면 P구간 사이에 있는 숫자들의 곱만 남는다.
 * 10-5. 그리고 그 숫자들의 곱을 X_minNum[]으로 나눠서 소숫점이 없는 자연수가 나오는지 판단한다.
 * 10-5-1. 앞서 A > 2, C > 3, G > 5, T > 7로 전환하였다. 각 숫자들은 각 문자에 대응한다. 
 * 10-5-2. 2,3,5,7은 각각 1과 자기 자신 외에는 나누어 떨어지지 않는 소수이며, X_minNum[]은 각 숫자들을 최소 숫자만큼 제곱한 수이다.
 * 10-5-3. 따라서 대응하는 문자들을 최소 숫자이상으로 포함하고 있었더라면 multipleArr[]는 X_minNum[]로 딱 나눠 떨어져야 한다.
 * 10-5-4. Math.floor()로 소숫점을 버린 상태와 원 상태가 서로 동일한 것으로 소숫점 없이 딱 나눠 떨어졌음을 판단하고,
 * 			모든 X_minNum[]가 그러하다면 조건을 충족한 것이다.
 * 10-5-5. 이때 count를 늘린다.
 * 11. count를 출력한다.
 */

// 이 방법은 문제를 보자마자 생각났지만, 코딩이 아니라 수학으로 푸는 것 같아서 안 쓰려 했는데 도저히 안 풀려서 그냥 이렇게 함
// 아니면 N x 4 사이즈의 2차원 배열을 만들고, 배열에 각 시점에 각 문자가 몇 개씩 있었는지 체크하게 하면 됐으려나?

public class DNAString {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		int S = sc1.nextInt();
		S = Math.min(1000000, Math.max(1, S));
		
		int P = sc2.nextInt();
		P = Math.min(S, Math.max(1, P));
		
		String inputStr = sc3.nextLine();
		inputStr = inputStr.substring(0, Math.min(S, inputStr.length()));
		
		inputStr = inputStr.replace('A', '2');
		inputStr = inputStr.replace('C', '3');
		inputStr = inputStr.replace('G', '5');
		inputStr = inputStr.replace('T', '7');
		
		double[] inputNumbers = Arrays.stream(inputStr.split("")).mapToDouble(Double::parseDouble).toArray();
		double[] multipleArr = new double[inputNumbers.length+1];
		multipleArr[0] = 1;
		for(int i=0; i<P-1; i++) {
			multipleArr[i+1] = inputNumbers[i] * multipleArr[i];
		}
		
		int[] X_mins = new int[4];
		int[] X_minNum = new int[4];
		int count = 0, total = 0;
		
		for(int i=0; i<4; i++) {
			String input = sc4.next();
			try {
				X_mins[i] = Integer.parseInt(input);
				X_mins[i] = Math.min(S, Math.max(0, X_mins[i]));
				if((total+X_mins[i]) > S) {
					X_mins[i] = S - total;
					total += X_mins[i];
				}
				else {
					total += X_mins[i];
				}
			}
			catch(Exception e) {
				X_mins[i] = 0;
			}
			int n=0;
			switch(i) {
				case 0:	n = 2; break;
				case 1: n = 3; break;
				case 2: n = 5; break;
				case 3: n = 7; break;
				default: break;
			}
			X_minNum[i] = (int) Math.pow(n, X_mins[i]);
		}

		if(total > P) {
			System.out.println(count);
			return;
		}
		
		for(int i=0; i<(S-P+1); i++) {
			multipleArr[i+P] = inputNumbers[i+P-1] * multipleArr[i+P-1];
			double num = multipleArr[i+P] / multipleArr[i];
			boolean b1 = (num/X_minNum[0] == Math.floor(num/X_minNum[0])) ? true : false;
			boolean b2 = (num/X_minNum[1] == Math.floor(num/X_minNum[1])) ? true : false;
			boolean b3 = (num/X_minNum[2] == Math.floor(num/X_minNum[2])) ? true : false;
			boolean b4 = (num/X_minNum[3] == Math.floor(num/X_minNum[3])) ? true : false;
			
			if(b1 && b2 && b3 && b4) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
