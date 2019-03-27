import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ07562.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 나이트의 이동, BFS
 * 
 */

public class BOJ07562 {
	static int dRow[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int dCol[] = { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			boolean[][] visit = new boolean[n][n];

			Queue<Coordi> q = new LinkedList<Coordi>();

			st = new StringTokenizer(br.readLine());
			q.offer(new Coordi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));

			st = new StringTokenizer(br.readLine());
			int goalRow = Integer.parseInt(st.nextToken());
			int goalCol = Integer.parseInt(st.nextToken());

			int nRow = 0;
			int nCol = 0;
			int answer = 0;

			Coordi now = null;
			while (!q.isEmpty()) {
				now = q.poll();
				if (visit[now.row][now.col])
					continue;

				if (now.row == goalRow && now.col == goalCol) {
					answer = now.move;
					break;
				}

				visit[now.row][now.col] = true;

				for (int i = 0; i < 8; i++) {
					nRow = now.row + dRow[i];
					nCol = now.col + dCol[i];

					if (0 <= nRow && nRow < n && 0 <= nCol && nCol < n && !visit[nRow][nCol])
						q.offer(new Coordi(nRow, nCol, now.move + 1));
				}
			}

			System.out.println(answer);
		}
	}

	static class Coordi {
		int row;
		int col;
		int move;

		public Coordi(int row, int col, int move) {
			this.row = row;
			this.col = col;
			this.move = move;
		}
	}
}