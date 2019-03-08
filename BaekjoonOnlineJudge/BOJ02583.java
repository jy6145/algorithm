import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02583.java
 * @date 2019. 3. 8.
 * @author Park JunYoung
 * @description 영역 구하기, DFS
 *
 */

public class BOJ02583 {
	static int n;
	static int m;
	static int k;
	static int cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];

		int x1, y1, x2, y2;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k] = 1;
				}
			}
		}

		cnt = 0;
		int areaCnt = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] == 0) {
					areaCnt++;
					cnt = 0;
					dfs(i, j);
					answer.add(cnt);
				}
			}
		}

		Collections.sort(answer);

		StringBuilder sb = new StringBuilder(areaCnt + "\n");
		for (Integer x : answer)
			sb.append(x + " ");

		System.out.println(sb.toString());
	}

	static void dfs(int row, int col) {
		visit[row][col] = true;
		cnt++;

		int nRow = 0;
		int nCol = 0;

		for (int i = 0; i < 4; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];

			if (0 <= nRow && nRow < n && 0 <= nCol && nCol < m && !visit[nRow][nCol] && map[nRow][nCol] == 0) {
				dfs(nRow, nCol);
			}
		}
	}
}
