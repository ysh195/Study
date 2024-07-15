package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 트리의 지름은 트리를 구성하는 노드 중 노드 사이의 거리가 가장 긴 것을 말한다. 트리의 지름을 구하시오. (2 <= V 100,000)
 * 1번째 줄에서는 트리의 노드 개수 V, 2번째 줄부터는 V개의 줄에 걸쳐 에지의 정보가 주어진다.
 * 먼저 노드 번호가 주어지고, 그 다음으로 연결된 에지의 정보를 의미하는 정수가 2개씩(연결된 노드 번호, 거리)가 주어진다. 거리는 10,000 이하의 자연수이다. 
 * 
 * 예를 들어 2번째 줄에
 * 3 1 2
 * 4 3 -1
 * 이 주어질 때 노드 3은 노드 1과 거리가 2인 에지로 연결돼 있고, 노드 4는 거리가 3인 에지로 연결돼 있다는 뜻이다.
 * -1은 더이상 노드가 없으므로 종료한다는 의미다. 
 */
public class CalcTreeRadius {

	static boolean[] visited;
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<N; i++) {
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E == -1) {break;}
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(1);
		int Max = 1;
		for(int i=2; i<=N; i++) {
			if(distance[Max] < distance[i]) {
				Max = i;
			}
		}
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(Max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
		
	}
	
	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for(Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}
}

class Edge{
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
