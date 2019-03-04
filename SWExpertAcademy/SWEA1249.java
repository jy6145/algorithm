import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1249.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description [S/W 문제해결 응용] 4일차 - 보급로, BFS, Comparable, 우선순위큐
 *
 */
public class SWEA1249 {
	static int n;
	static int[][] map;
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };
	static int minWork;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];

			String tmp = "";
			for (int i = 0; i < n; i++) {
				tmp = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}

			minWork = Integer.MAX_VALUE;
			boolean[][] visit = new boolean[n][n];
			PriorityQueue<Coordi> pq = new PriorityQueue<Coordi>();

			pq.offer(new Coordi(0, 0, 0));

			int row = 0;
			int col = 0;
			int work = 0;
			Coordi cTmp;
			int nextRow = 0;
			int nextCol = 0;
			while (!pq.isEmpty()) {
				cTmp = pq.poll();

				row = cTmp.row;
				col = cTmp.col;
				work = cTmp.work;
				visit[row][col] = true;

				if (row == n - 1 && col == n - 1) {
					if (minWork > work)
						minWork = work;

					break;
				}

				for (int i = 0; i < 4; i++) {
					nextRow = row + dRow[i];
					nextCol = col + dCol[i];

					if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && !visit[nextRow][nextCol]) {
						pq.offer(new Coordi(nextRow, nextCol, work + map[nextRow][nextCol]));
					}
				}

			}

			System.out.println("#" + testCase + " " + minWork);
		}
	}

	static class Coordi implements Comparable<Coordi> {
		int row;
		int col;
		int work;

		public Coordi(int row, int col, int work) {
			this.row = row;
			this.col = col;
			this.work = work;
		}

		@Override
		public int compareTo(Coordi o) {
			return work - o.work;
		}

	}
}