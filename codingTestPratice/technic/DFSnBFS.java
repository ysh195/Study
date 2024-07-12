package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 :
 * 그래프를 DFS로 탐색한 결과아ㅘ BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
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

// 원래는 잘 이해가 안 되지만 꽤 간결한데?

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
	
	public static void DFS(int Node) {
		System.out.println(Node + " ");
		visited[Node] = true;
		for(int i : A[Node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();
			System.out.println(now_Node + " ");
			for(int i : A[now_Node]) {
				if(!visited[i]) {
					queue.add(i);
				}
			}
		}
	}

}
