import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ10026.java
 * @date 2019. 2. 17.
 * @author Park JunYoung
 * @description 적록색약, DFS
 *
 */

public class BOJ10026 {
	static int cnt, cnt2;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		char[][] map2 = new char[n][n];

		String tmp;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = st.nextToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp.charAt(j);

				if (tmp.charAt(j) == 'G') {
					map2[i][j] = 'R';
				} else {
					map2[i][j] = tmp.charAt(j);
				}
			}
		}

		boolean[][] visit = new boolean[n][n];
		boolean[][] visit2 = new boolean[n][n];

		cnt = 0;
		cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs(map[i][j], map, visit, i, j);
					cnt++;
				}

				if (!visit2[i][j]) {
					dfs(map2[i][j], map2, visit2, i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt + " " + cnt2);
	}

	static void dfs(char color, char[][] map, boolean[][] visit, int row, int col) {
		visit[row][col] = true;

		int n = visit.length;
		int nextRow = 0;
		int nextCol = 0;
		char nextColor;
		for (int i = 0; i < 4; i++) {
			nextRow = row + dy[i];
			nextCol = col + dx[i];

			if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && !visit[nextRow][nextCol]) {
				nextColor = map[nextRow][nextCol];
				if (color == nextColor) { // 같은 색이면 dfs
					dfs(color, map, visit, nextRow, nextCol);
				}
			}
		}
	}

}
