import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1953.java
 * @date 2019. 3. 14.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 탈주범 검거, BFS
 * 
 */
public class SWEA1953 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] tunnel = new int[N][M];
			boolean[][] visit = new boolean[N][M];

			int[] dRow = { -1, 1, 0, 0 };
			int[] dCol = { 0, 0, -1, 1 };
			int[][] chk = { {}, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 0, 1, 0, 1 },
					{ 0, 1, 1, 0 }, { 1, 0, 1, 0 } };

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tunnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Coordi> q = new LinkedList<Coordi>();
			q.offer(new Coordi(R, C, 1));

			Coordi now = null;
			int answer = 0;
			while (!q.isEmpty()) {
				now = q.poll();

				if (now.time > L)
					break;

				if (visit[now.row][now.col])
					continue;

				visit[now.row][now.col] = true;
				answer++;

				int nextRow = 0;
				int nextCol = 0;
				int opt = tunnel[now.row][now.col];
				for (int i = 0; i < 4; i++) {
					if (chk[opt][i] == 1) {
						nextRow = now.row + dRow[i];
						nextCol = now.col + dCol[i];

						if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M && !visit[nextRow][nextCol]) {
							if (i == 0) {
								switch (tunnel[nextRow][nextCol]) {
								case 1:
								case 2:
								case 5:
								case 6:
									q.offer(new Coordi(nextRow, nextCol, now.time + 1));
								}
							} else if (i == 1) {
								switch (tunnel[nextRow][nextCol]) {
								case 1:
								case 2:
								case 4:
								case 7:
									q.offer(new Coordi(nextRow, nextCol, now.time + 1));
								}
							} else if (i == 2) {
								switch (tunnel[nextRow][nextCol]) {
								case 1:
								case 3:
								case 4:
								case 5:
									q.offer(new Coordi(nextRow, nextCol, now.time + 1));
								}
							} else if (i == 3) {
								switch (tunnel[nextRow][nextCol]) {
								case 1:
								case 3:
								case 6:
								case 7:
									q.offer(new Coordi(nextRow, nextCol, now.time + 1));
								}
							}
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}

	}

	static void printV(boolean[][] visit) {
		System.out.println("==============");
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit.length; j++) {
				if (visit[i][j])
					System.out.print("O");
				else
					System.out.print("X");
			}
			System.out.println();
		}
	}

	static class Coordi {
		int row;
		int col;
		int time;

		public Coordi(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
}
