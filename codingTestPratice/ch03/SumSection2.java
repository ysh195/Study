package ch03;

import java.util.Scanner;

/*
 * 문제 :
 * N * N개의 수가 N * N 크기의 표에 채워져 있다. 표 안의 수 중(X1, Y1)에서 (X2, Y2)까지의 합을 구하려 한다. X는 행, Y는 열을 의미한다.
 * 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때 이를 처리하는 프로그램을 작성하시오.
 * 
 * 입력 :
 * 1번째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 <= N <= 1020, 1<= M <= 100,000)
 * 2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
 * 다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며, (X1, Y1)에서 (X2, Y2)의 합을 구해 출력해야 한다. (X1 <= X2, Y1 <= Y2)
 * 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다.
 */

/*
 * 풀이 :
 * 1. N, M을 입력 받으면서 각각의 제한에 맞게 조정한다.
 * 2. N * N 크기의 2차원 배열 arr와 total을 준비한다.
 * 3. 2중 for문으로 arr[][]에 알맞은 값을 집어 넣는다
 * 4. total[y][x] = total[y][x-1] + arr[y][x]로 해야 하나, 2중 for문이기 때문에 x=0일 때가 문제가 된다
 * 4-1. x는 0이상이기 때문에 -1은 존재할 수 없으니, x=0일 때 for문 내 x의 최대값인 N-1로 하고, y = y - 1 로 한다.
 * 5. for문으로 한 번에 4개의 값을 입력받아서 2차원 배열 좌표 2개를 얻는다
 * 6. x2는 항상 x1보다 크거나 같고, y2는 항상 y1보다 크거나 같다. 따라서 좌표2는 항상 좌표1보다 오른쪽 아래에 있다.
 * 배열 위에 좌표1을 좌측 위, 좌표2를 우측 아래의 꼭지점으로 삼는 직사각형을 그린다고 했을 때, 해당 직사각형 범위 내에 있는 숫자들의 합을 구한다.
 * 6-1. total[y2][x2] - total[y1][x2-1] = 좌표1부터 좌표2까지의 모든 값의 합이다.
 * 6-2. 여기서 직사각형 범위를 벗어나는 모든 값을 빼면 직사각형 범위 내에 있는 숫자들의 합을 구할 수 있다. y2와 y1의 차이만큼 아래를 반복하여 빼야 할 값을 구한다.
 * 6-2-1. x2는 항상 x1보다 크거나 같으므로, 직사각형의 우측에 위치해 있다. 따라서 직사각형의 범위를 벗어나는, 범위는 x2 초과, x1 미만이다.
 * 6-2-2. 그러니 total[각 y+1][x1-1] - total[각 y][x2+1]을 계산해서 모두 더하면 빼야 할 값이다. 
 * 6-2-3. 그런데 0 <= x <= N-1 이므로, 그 값을 벗어나지 않도록 보정해준다.
 * 7. 마지막으로 [좌표1부터 좌표2까지의 모든 값의 합] - [빼야 할 모든 값의 합]을 계산한다.
 */

// 이건 코딩 능력보다는 수학 능력에 가까워 보이는데?

public class SumSection2 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);
		Scanner sc6 = new Scanner(System.in);
		
		int N = sc1.nextInt();
		N = Math.min(1024, Math.max(1, N));
		
		int M = sc2.nextInt();
		M = Math.min(100000, Math.max(1, M));
		
		int[][] arr = new int[N][N];
		int[][] total = new int[N][N];
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				arr[y][x] = (int)(Math.random()*1000)+1;
				int b = (x == 0) ? (y-1) : y;
				int a = (x == 0) ? (N-1) : x;
				total[y][x] = total[b][a] + arr[y][x];
			}
		}
		
		for(int i=0; i<M; i++) {
			int x1 = sc3.nextInt();
			x1 = Math.min(N-1, Math.max(0, x1));
			int y1 = sc4.nextInt();
			y1 = Math.min(N-1, Math.max(0, y1));
			int x2 = sc5.nextInt();
			x2 = Math.min(N-1, Math.max(x1, x2));
			int y2 = sc6.nextInt();
			y2 = Math.min(N-1, Math.max(y1, y2));
			// 조건 때문에 항상 x2와 y2가 더 크다
			int sum = total[y2][x2] - total[y1][Math.max(0, x1-1)];
			int minus = 0;
			for(int j=y1; j<y2; j++) {
				minus += (total[j+1][Math.max(0, x1-1)] - total[j][Math.min(N-1, x2+1)]);
			}
			
			System.out.println(sum-minus);
		}

	}

}
