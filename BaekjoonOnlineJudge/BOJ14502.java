import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14502.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 연구소, DFS, BFS
 * 
 */

public class BOJ14502 {
	static int dRow[] = { -1, 0, 1, 0 };
	static int dCol[] = { 0, -1, 0, 1 };

	static int N, M;
	static int[][] map;
	static ArrayList<Coordi> virus;
	static int safeZone;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<Coordi>();
		safeZone = 0;

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Coordi(i, j));
				else if (map[i][j] == 0)
					safeZone++;
			}
		}

		answer = 0;
		selectWall(0, 0, 0, 3);
		System.out.println(answer);

	}// main

	static void selectWall(int pRow, int pCol, int cnt, int goal) {
		if (cnt == goal) {
			// 바이러스 전파
			int[][] cpMap = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, cpMap[i], 0, map[i].length);

			Queue<Coordi> q = new LinkedList<>();
			for (Coordi c : virus)
				q.offer(c);

			int virusCnt = 0;
			Coordi now = null;
			while (!q.isEmpty()) {
				now = q.poll();

				if (visit[now.row][now.col])
					continue;
				visit[now.row][now.col] = true;
				virusCnt++;
				cpMap[now.row][now.col] = 2;

				int nRow = 0;
				int nCol = 0;
				for (int i = 0; i < 4; i++) {
					nRow = now.row + dRow[i];
					nCol = now.col + dCol[i];

					if (0 <= nRow && nRow < N && 0 <= nCol && nCol < M && cpMap[nRow][nCol] == 0
							&& !visit[nRow][nCol]) {
						q.offer(new Coordi(nRow, nCol));
					}
				}
			}

			if (answer < safeZone + virus.size() - 3 - virusCnt) // 기존 바이러스, 새로운 기둥 3개 제외
				answer = safeZone + virus.size() - 3 - virusCnt;

			return;
		}

		if (pRow == N)
			return;

		// 다음 pivot
		int nextRow = pRow;
		int nextCol = pCol + 1;
		if (nextCol >= M) {
			nextRow++;
			nextCol = 0;
		}

		// 벽 선택
		if (map[pRow][pCol] == 0) {
			map[pRow][pCol] = 1;
			selectWall(nextRow, nextCol, cnt + 1, goal);
			map[pRow][pCol] = 0;
		}

		// 벽 선택 X
		selectWall(nextRow, nextCol, cnt, goal);
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