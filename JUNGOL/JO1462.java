import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName JO1462.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description 보물섬, BFS
 * 
 */

public class JO1462 {
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];

		String str = "";
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		Queue<Cordi> q;
		boolean[][] visit;
		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					q = new LinkedList<Cordi>();
					visit = new boolean[R][C];
					q.offer(new Cordi(i, j, 1));

					while (!q.isEmpty()) {
						Cordi now = q.poll();
						int nowRow = now.row;
						int nowCol = now.col;

						if (visit[nowRow][nowCol])
							continue;

						visit[nowRow][nowCol] = true;
						int nowDepth = now.depth;

						if (max < nowDepth)
							max = nowDepth;

						int nextRow = 0;
						int nextCol = 0;
						for (int k = 0; k < 4; k++) {
							nextRow = nowRow + dRow[k];
							nextCol = nowCol + dCol[k];

							if (0 <= nextRow && nextRow < R && 0 <= nextCol && nextCol < C
									&& map[nextRow][nextCol] == 'L' && !visit[nextRow][nextCol]) {
								q.offer(new Cordi(nextRow, nextCol, nowDepth + 1));
							}
						}
					}
				}
			}
		}

		System.out.println(max - 1);
	}

	static class Cordi {
		int row;
		int col;
		int depth;

		public Cordi(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
}
