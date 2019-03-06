import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ04963.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 섬의 개수, DFS
 *
 */

public class BOJ04963 {
	static int w;
	static int h;
	static int[][] map;
	static int[] dRow = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dCol = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) // 종료
				break;

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						answer++;
						dfs(i, j);
					}
				}
			}

			System.out.println(answer);
		}
	}

	static void dfs(int row, int col) {
		map[row][col] = 0; // 방문한 곳은 바다(0)으로 변경

		int nRow = 0;
		int nCol = 0;
		for (int i = 0; i < 8; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];

			if (0 <= nRow && nRow < h && 0 <= nCol && nCol < w && map[nRow][nCol] == 1) {
				dfs(nRow, nCol);
			}
		}
	}
}
