import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14500.java
 * @date 2019. 3. 31.
 * @author Park JunYoung
 * @description 테트로미노, DFS
 *
 */

public class BOJ14500 {
	static int N, M;
	static int[][] map;
	static int max;

	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		int nRow = 0;
		int nCol = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;

				for (int k = 0; k < 4; k++) { // 2칸 선택후 남은 2칸 DFS
					nRow = i + dRow[k];
					nCol = j + dCol[k];
					if (0 <= nRow && nRow < N && 0 <= nCol && nCol < M) {
						visit[nRow][nCol] = true;
						dfs(i, j, 2, map[i][j] + map[nRow][nCol], visit);
						visit[nRow][nCol] = false;
					}
				}

				chkT(i, j); // T모양에서 최대값 확인
			}
		}

		System.out.println(max);
	}

	static void chkT(int row, int col) {
		boolean flag = false;

		int sum = 0;
		int nRow = 0;
		int nCol = 0;
		for (int i = 0; i < 4; i++) {
			sum = map[row][col];
			flag = false;

			for (int j = 0; j < 3; j++) {
				nRow = row + dRow[(i + j) % 4];
				nCol = col + dCol[(i + j) % 4];
				if (!(0 <= nRow && nRow < N && 0 <= nCol && nCol < M)) {
					flag = true;
					break;
				}
				sum += map[nRow][nCol];
			}

			if (!flag && max < sum)
				max = sum;
		}
	}

	static void dfs(int row, int col, int cnt, int sum, boolean[][] visit) {
		if (cnt == 4) {
			if (max < sum)
				max = sum;

			return;
		}

		int nRow = 0;
		int nCol = 0;
		for (int i = 0; i < 4; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];

			if (0 <= nRow && nRow < N && 0 <= nCol && nCol < M && !visit[nRow][nCol]) {
				visit[nRow][nCol] = true;
				dfs(nRow, nCol, cnt + 1, sum + map[nRow][nCol], visit);
				visit[nRow][nCol] = false;
			}
		}
	}
}