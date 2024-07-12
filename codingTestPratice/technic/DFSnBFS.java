package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 :
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 노드가 여러 개일 경우에는 노드 번호가 작은 것을 먼저 방문하고 더 이상 방문할 수 있는 노드가 없을 때 종료한다.
 * 노드 번호는 1에서 N까지다. 
 * 
 * 입력 :
 * 1번째 줄에는 노드의 개수 N, 에지의 개수 M, 탐색을 시작할 노드의 번호 V가 주어진다. (1 <= N <= 1,000), (1 <= M <= 10,000)
 * 그 다음 M개의 줄에는 에지가 연결하는 두 노드의 번호가 주어진다.
 * 어떤 두 노드 사이에 여러 개의 에지가 있을 수 있다. 입력으로 주어지는 에지는 양방향이다.
 * 
 * 출력 :
 * 1번째 줄에는 DFS를 수행한 결과, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 * V부터 방문된 점을 순서대로 출력하면 된다.
 * 
 */

// 꽤 간결한데?

public class DFSnBFS {
	
	static boolean visited[];
	static ArrayList<Integer>[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		A = new ArrayList[N+1];
		for(int i=0; i<M; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for(int i=0; i<M; i++) {
			Collections.sort(A[i]); // 이러면 각 리스트의 사이즈 크기에 따라 정렬
		}
		
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
		System.out.println();
	}
	
	public static void DFS(int Node) { // 던전 탐색에서 길 하나를 끝까지 탐색하고 돌아 나오는 방식
		System.out.println(Node + " ");
		visited[Node] = true;
		for(int i : A[Node]) { // i 자체가 A의 요소고, 그 요소는 숫자니까 계속 파고 들어감.
			if(!visited[i]) { // visited가 false, 그러니까 아직 안 와본 곳이면 들어감.
				DFS(i);
			}
		} // 와본 곳이면 그냥 지나감.
	} // 이거 자체가 내부에 무수히 많은 for문이 있는 것이나 마찬가지니까 들어갈 곳이 없으면 다 지나가는 거고, 해당 for문이 끝나는 거임.
	// 그리고 내부의 for문이 끝나면 밖에 있는 for문이 이어서 진행될 뿐.
	// 자기 자신을 내부에 담고 있는데다, for문을 무수히 내부에 반복하니까 거부감이 있긴 한데 확실히 쉽고 간결하다.
	
	public static void BFS(int Node) { // 던전 탐색에서 초반-중반-종반 등 앞에서 뒤로 각 구간을 완벽히 탐색하는 방식
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node); // 큐에 추가하고
		visited[Node] = true; // 왔다고 표시
		
		while(!queue.isEmpty()) { // 큐에 내용물이 없어질 때까지 반복
			int now_Node = queue.poll(); // 큐는 poll 하면 앞에서부터 제거 및 출력
			System.out.println(now_Node + " ");
			for(int i : A[now_Node]) { // 그리고 출력된 것을 A에 집어넣어서 그 요소를 살펴봄
				if(!visited[i]) { // 안 가본 곳이면
					visited[i] = true; // 왔다고 표시
					queue.add(i); // 그리고 큐에 추가.
				}
			} // 내용물이 다 떨어질 때까지 안 가본 곳을 집어넣고 다시 출력하기를 반복
		}
	}

}
