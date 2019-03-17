import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName BOJ11559.java
 * @date 2019. 3. 16.
 * @author Park JunYoung
 * @description Puyo Puyo, DFS, 시뮬레이션
 *
 */

public class BOJ11559 {
	static char[][] game;
	static boolean[][] visit;
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };
	static Queue<Coordi> q;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		game = new char[12][6];

		String line = "";
		for (int i = 0; i < 12; i++) {
			line = br.readLine();
			for (int j = 0; j < 6; j++) {
				game[i][j] = line.charAt(j);
			}
		}

		int chine = 0;
		boolean flag = true;
		Coordi tmp;

		while (true) {
			visit = new boolean[12][6];

			flag = false; // true이면 뿌요뿌요 제거한 상태
			// 뿌요뿌요 제거
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (game[i][j] != '.' && !visit[i][j]) {
						q = new LinkedList<Coordi>();
						dfs(i, j, game[i][j]);

						if (q.size() >= 4) {
							flag = true;

							while (!q.isEmpty()) {
								tmp = q.poll();
								game[tmp.row][tmp.col] = '.';
							}
						}
					}
				}
			}

			// 제거되면 체인 카운트
			if (!flag)
				break;
			chine++;

			// 중력 적용
			int stIdx = 0;
			for (int j = 0; j < 6; j++) {
				stIdx = 11;
				for (int i = 11; i >= 0; i--) {
					if (game[i][j] != '.')
						game[stIdx--][j] = game[i][j];
				}

				for (int i = stIdx; i >= 0; i--)
					game[i][j] = '.';
			}
		}

		System.out.println(chine);
	}

	static void dfs(int row, int col, char c) {
		visit[row][col] = true;
		q.add(new Coordi(row, col));

		int nextRow = 0;
		int nextCol = 0;

		for (int i = 0; i < 4; i++) {
			nextRow = row + dRow[i];
			nextCol = col + dCol[i];

			if (0 <= nextRow && nextRow < 12 && 0 <= nextCol && nextCol < 6 && !visit[nextRow][nextCol]
					&& game[nextRow][nextCol] == c)
				dfs(nextRow, nextCol, c);
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
