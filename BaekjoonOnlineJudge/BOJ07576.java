import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ07576.java
 * @date 2019. 3. 6.
 * @author Park JunYoung
 * @description 토마토, BFS 	
 * 
 */

public class BOJ07576 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 열
		int m = Integer.parseInt(st.nextToken()); // 행

		int[][] farm = new int[m][n];
		boolean[][] visit = new boolean[m][n];

		int maxCnt = n * m; // 토마토의 총 개수
		int cnt = 0; // 토마토의 현재 개수
		Queue<Tomato> q = new LinkedList<Tomato>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());

				if (farm[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
				} else if (farm[i][j] == -1)
					maxCnt--;
			}
		}

		// BFS
		Tomato now;
		int nextRow;
		int nextCol;
		int maxDay = 0;
		while (!q.isEmpty()) {
			now = q.poll();

			if (visit[now.row][now.col])
				continue;

			visit[now.row][now.col] = true;
			farm[now.row][now.col] = 1;
			cnt++;
			printTomato(farm, cnt);

			if (maxDay < now.day)
				maxDay = now.day;

			for (int i = 0; i < 4; i++) {
				nextRow = now.row + dRow[i];
				nextCol = now.col + dCol[i];

				if (0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n && farm[nextRow][nextCol] == 0) {
					q.offer(new Tomato(nextRow, nextCol, now.day + 1));
				}
			}
		}

//		System.out.println(cnt + " " + maxCnt + " " + maxDay);
		if (cnt == maxCnt)
			System.out.println(maxDay);
		else
			System.out.println(-1);
	}

	static void printTomato(int[][] farm, int cnt) {
		System.out.println("=========================");
		for (int i = 0; i < farm.length; i++) {
			for (int j = 0; j < farm[i].length; j++) {
				System.out.print(farm[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(cnt);
	}

	static class Tomato {
		int row;
		int col;
		int day;

		public Tomato(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
}
