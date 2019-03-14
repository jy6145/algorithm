import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1949.java
 * @date 2019. 3. 14.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 등산로 조성, DFS
 *
 */

public class SWEA1949 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };
	static int n;
	static int k;
	static int maxLength;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			int max = 0;
			int[][] map = new int[n][n];
			boolean[][] visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}

			ArrayList<Coordi> maxList = new ArrayList<Coordi>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max)
						maxList.add(new Coordi(i, j));
				}
			}

			maxLength = 0;
			for (Coordi x : maxList) {
				visit = new boolean[n][n];
				dfs(map, visit, x, 1, true); // true면 커트 가능
			}

			System.out.println("#" + testCase + " " + maxLength);
		}
	}

	static void dfs(int[][] map, boolean[][] visit, Coordi now, int length, boolean cut) {
		if (visit[now.row][now.col])
			return;
		visit[now.row][now.col] = true;

		if (length > maxLength)
			maxLength = length;

		int nextRow = 0;
		int nextCol = 0;
		int[][] mapCopy;
		boolean[][] visitCopy;

		for (int i = 0; i < 4; i++) {
			nextRow = now.row + dRow[i];
			nextCol = now.col + dCol[i];

			if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && !visit[nextRow][nextCol]) {
				if (map[nextRow][nextCol] < map[now.row][now.col]) { // 안깎아도 될때
					mapCopy = new int[n][n];
					visitCopy = new boolean[n][n];
					for (int j = 0; j < n; j++) {
						System.arraycopy(map[j], 0, mapCopy[j], 0, n);
						System.arraycopy(visit[j], 0, visitCopy[j], 0, n);
					}
					dfs(mapCopy, visitCopy, new Coordi(nextRow, nextCol), length + 1, cut);

				} else if (map[nextRow][nextCol] - k < map[now.row][now.col] && cut) { // 깎으면 될때
					mapCopy = new int[n][n];
					visitCopy = new boolean[n][n];
					for (int j = 0; j < n; j++) {
						System.arraycopy(map[j], 0, mapCopy[j], 0, n);
						System.arraycopy(visit[j], 0, visitCopy[j], 0, n);
					}

					mapCopy[nextRow][nextCol] = map[now.row][now.col] - 1;
					dfs(mapCopy, visitCopy, new Coordi(nextRow, nextCol), length + 1, false);
				}
			}
		}
	}

	static class Coordi {
		int row;
		int col;

		public Coordi(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
