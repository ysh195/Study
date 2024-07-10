package one;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 코드 실행 제한시간 : 2초
 * 
 * 문제 :
 * 1의 자리, 1~10의 자리, 1~100의 자리, ..., 1~가장 큰 자릿수까지 모든 숫자가 소수인 숫자를 "신기한 숫자"라고 한다.
 * 예를 들어, 숫자 17이 있다면
 * 1의 자리 7은 소수에 해당하고, 1~10의 자리 17도 소수에 해당하므로, 17은 신기한 숫자에 해당한다.
 * 숫자 N이 주어졌을 때, 숫자 N자리까지의 모든 숫자 중의 신기한 숫자를 구하라.
 * 
 * 입력 :
 * 첫째 줄에 숫자 N이 주어진다. (1 <= N <= 8)
 * 
 * 출력 :
 * 첫째 줄부터 아래로 신기한 숫자들이 오름차순으로 출력된다.
 * 
 * 풀이 :
 * 
 * 지금 찾는 것은 신기한 숫자임을 명심해야 한다.
 * 따라서 1의 자리 숫자부터 소수여야 하고, 1의 자리이면서 소수인 숫자는 2, 3, 5, 7뿐이다.
 * N이 1이라면 2, 3, 5, 7에서 끝나겠으나, 그렇지 않을 경우 남는 숫자는 3과 7뿐이다.
 * 끝자리가 2 또는 5로 끝난다면 각각 2와 5로 나눌 수 있어 소수가 아니기 때문이다.
 * N값에 따라 1의 자리를 고정시키고 나머지는 정상적으로 소수를 구한다.
 * 또, 소수를 구할 때 나눌 숫자는 2 ~ sqrt(해당 숫자)이면 족하다.
 * 곱셈이 가능한 숫자를 찾는 것이므로 자기 자신의 루트값을 곱하는 것이 최대 숫자일 수밖에 없다.
 * 
 * 1. 숫자 N을 입력받고, 제한된 범위에 맞춰 조절한다.
 * 2. 만약 N = 1이라면 더이상 계산을 진행하지 않고, 바로 결과를 출력한다.
 *    뒤의 계산식으로는 10의 자리 이상부터 계산이 가능하기 때문이다. 
 * 3. 3으로 끝나는 숫자들을 저장할 list3과 7로 끝나는 숫자들을 저장할 list7을 준비한다.
 *    그리고 첫 계산을 위해 각각 3과 7을 넣어준다.
 * 4. 다음과 같이 for문을 실행한다.
 * 4-1. 10의 8승은 9자리이니, 1~(N-1)만큼 반복한다.
 * 4-2. 10의 (현재 i)승인 숫자 unit1을 준비한다.
 * 4-3. 계산 중간 결과를 저장할 temp3과 temp7을 준비한다.
 * 4-4. 다음과 같이 for문을 실행한다.
 * 4-4-1. 현재 자릿수의 1~9를 계산해야 하므로, 1~9만큼 반복한다.
 * 4-4-2. 현재의 10의 i승에 j를 곱해서 현재 자릿수 1~9를 준비한다.
 * 4-4-3. 다음과 같이 for문을 실행하면서 끝자리가 3인 경우와 7인 경우를 동시에 따로 진행한다.
 * 4-4-3-1. 각 리스트의 사이즈만큼 반복한다. 리스트에 저장되어 있는 값을 인덱스로 불러와서 순서대로 반복한다.
 * 4-4-3-2. 준비된 자릿수 + 리스트에 저장되어 있는 값을 더해서 현재 계산할 값을 설정한다.
 * 4-4-3-3. 현재 계산할 값이 나눌 수 있는지 여부를 판단할 possible_todiv를 준비한다.
 * 4-4-3-4. 다음과 같이 for문을 실행한다.
 * 4-4-3-4-1. 숫자 2 ~ sqrt(현재 숫자)만큼 반복한다.
 * 4-4-3-4-2. 숫자 1로는 뭐든 나눌 수 있으니 제외하고, sqrt(현재 숫자)의 제곱은 자기 자신이므로,
 *            어떠한 숫자를 나눌 수 있는 숫자를 중복없이 구하고자 한다면 sqrt(현재 숫자)까지면 족하다.
 * 4-4-3-4-3. 만약 중간에 현재의 숫자를 나눌 수 있는 숫자가 있다면 즉시 반복을 종료하고, possible_todiv = true 이다.
 * 4-4-3-5. 만약 이번 반복문이 끝나도록 한 번도 나눌 수 있는 숫자를 찾지 못했다면
 *          이것은 소수이므로 temp3 혹은 temp7에 추가한다.
 * 4-4-3-6. 이것을 3과 7 모두 동시에 진행한다.
 * 4-5. 이번 자릿수의 숫자로 1~9의 모든 계산이 끝났다면
 *      temp3과 temp7에 저장된 것들을 각각 list3와 list7에 덮어씌우고,
 *      다음 회차로 넘어간다.
 * 5. while문을 다음과 같이 실행한다.
 * 5-1. list3과 list7 내에 저장된 요소가 모두 없어질 때까지 반복한다.
 * 5-2. list3과 list7의 저장된 요소 중 첫번째 요소를 꺼내서 확인한다.
 *      만약 그 값이 null이면 100000000(9자리 숫자. 최대 8자리 숫자인 요소들보다 무조건 큼)로 하고, 아니면 그대로 저장한다.
 * 5-3. 만약 num3 >= num7이면 list7의 첫번째 요소를 출력한다.
 * 		아니라면 list3의 첫번째 요소를 출력한다.
 * 5-4. 이와 같이 계속해서 출력해서 list3과 list7 내에 저장된 요소가 모두 없어질 때까지 list 내의 요소를 줄여나간다.
 *      문제의 조건 중 "오름차순으로 출력" 이라는 문구가 있는데, 이렇게 하면 정렬과정 없이 바로 출력됨.       
 */
public class WonderNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = Math.min(8, Math.max(1, N));
		
		if(N == 1) {
			System.out.println(2);
			System.out.println(3);
			System.out.println(5);
			System.out.println(7);
			return;
		}
		
		LinkedList<Double> list3 = new LinkedList<>();
		LinkedList<Double> list7 = new LinkedList<>();

		list3.add((double) 3);
		list7.add((double) 7);
		
		for(int i=1; i<=N-1; i++) { // N단위
			double unit1 = Math.pow(10, i);
			
			LinkedList<Double> temp3 = new LinkedList<>();
			LinkedList<Double> temp7 = new LinkedList<>();
			
			for(int j=1; j<=9; j++) { // 1~9까지
				double unit2 = unit1 * j;
				for(int k=0; k<list3.size(); k++) { // list 내 요소들마다
					double targetN = list3.get(k) + unit2;
					boolean possible_todiv = false;
					for(int l=2; l<Math.sqrt(targetN); l++) { // 숫자 1이 아니라 영어 L(소문자)이다.
						if(targetN/l == Math.floor(targetN/l)) {
							possible_todiv = true;
							break;
						}
					}
					if(!possible_todiv) {
						temp3.add(targetN);
					}
				}
				
				for(int k=0; k<list7.size(); k++) { // list 내 요소들마다
					double targetN = list7.get(k) + unit2;
					boolean possible_todiv = false;
					for(int l=2; l<Math.sqrt(targetN); l++) {
						if(targetN/l == Math.floor(targetN/l)) {
							possible_todiv = true;
							break;
						}
					}
					if(!possible_todiv) {
						temp7.add(targetN);
					}
				}
			}
			
			list3 = temp3;
			list7 = temp7;
		}
		
		while(list3.size() + list7.size() > 0) { // 애초에 매번 덮어씌워서 이전의 작은 값들은 있지도 않음
			double num3 = (list3.peekFirst() == null) ? 100000000 : list3.peekFirst();
			double num7 = (list7.peekFirst() == null) ? 100000000 : list7.peekFirst();
			
			if(num3 >= num7) {
				System.out.println(list7.pollFirst());
			}
			else {
				System.out.println(list3.pollFirst());
			}
		}
	}
}
