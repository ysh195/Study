package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 문제 :
 * 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 입력 :
 * 1번째 줄에 노드의 개수 N과 에지의 개수 M이 주어진다. (1 <= N <= 1,000), (0 <= M <= N * (N-1)/2)
 * 2번째 줄부터는 M개의 줄에 에지의 양끝 점 u와 v가 주어진다. (1 <= u, v <= N), (u != v)
 * 
 * 출력 :
 * 1번째 줄에 연결 요소의 개수를 출력한다.
 */

/*
 * 문제에 대해 추가 설명.
 * 일단 이건 수학의 그래프와는 아무런 관련이 없으니 그걸로 이해하는 건 포기해야 함.
 * 각 숫자 하나하나가 일종의 점이고, 2번째 줄부터 나타나는 것은 그 점끼리의 연결을 의미함.
 * 
 * 예를 들어,
 * 1 2 가 주어졌다면
 * 이는 점 1과 점 2가 서로 연결되어 있음을 의미한다.
 * 
 * 여기서
 * 2 5 가 주어졌다면
 * 이는 점 1과 점 2가 서로 연결되어 있음을 의미하면서, 이전에 선언된 점들 사이의 연결 관계는 여전히 유효하므로
 * 점 2는 두 개의 점(점 1과 점 5)와 모두 연결되어 있으며, 점 1과 점 5는 서로 점 2를 통해 간접적으로 연결되어 있는 상태가 된다.
 * 
 * 그리고 연결 요소의 갯수란, 탐색이 완료된 횟수를 의미한다.
 * 여기서 말하는 탐색 완료란, 연결 관계에 있는 점들을 끝까지 탐색한 횟수로서,
 * 간단하게 생각하면
 * 서로 직간접적으로 연결된 점들을 하나의 그룹으로 보고, 연결점이 전혀 없는 점들을 별개의 그룹이라고 보았을 때
 * 서로 연결점이 없는 그룹들의 갯수이다.
 */
public class ConnectedComponent {
	
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);

	}
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}

}
