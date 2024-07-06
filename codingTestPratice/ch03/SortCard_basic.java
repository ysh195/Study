package one;

/*
* 코드실행 제한 시간 : 2초
* 
* 문제 :
* N장의 카드가 있다. 각각의 카드는 차례로 1에서 N까지의 번호가 붙어 있으며, 1번 카드가 가장 위, N번 카드가 가장 아래인 상태로 놓여 있다.
* 이제 다음과 같은 동작을 카드가 1장 남을 때까지 반복한다.
*  - 먼저 가장 위에 있는 카드를 제거한다. 제거된 카드는 다시 카드 뭉치에 추가되지 않는다.
*  - 그 다음 가장 위에 있는 카드를 가장 아래에 있는 카드 밑으로 옮긴다.
* 
* 예를 들어 N = 4일 때
* 카드는 가장 위에서부터 1, 2, 3, 4의 순서대로 놓여 있다.
* 1을 버리면 2, 3, 4가 남는다. 2를 가장 아래로 옮기면 순서가 3, 4, 2가 된다.
* 3을 버리면 4, 2가 남고, 4를 가장 아래로 옮기면 순서가 2, 4가 된다.
* 마지막으로 2를 버리면 4만 남는다.
* 
* 입력 :
* 1번째 줄에 정수 N이 주어진다. (1 <= N <= 500,000)
* 
* 출력 :
* 1번째 줄에 남는 카드의 번호를 출력한다.
* 
* 매우 쉽기 때문에 별도의 풀이는 없다.
*/

import java.util.LinkedList;
import java.util.Scanner;

public class SortCard_basic {

    public static void main(String[] args) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = Math.min(500000, Math.max(1, N));
		
		LinkedList<Integer> cards = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			cards.add(i);
		}
		
		while(cards.size() >= 2) {
			cards.removeFirst();
			int tempCard = cards.removeFirst();
			cards.addLast(tempCard);
			System.out.println("2번 : " + cards.getLast());
			}
		
		System.out.println(cards.getLast());
    }
}
