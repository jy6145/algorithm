import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName BOJ01938.java
 * @date 2019. 3. 16.
 * @author Park JunYoung
 * @description 통나무 옮기기, BFS
 *
 */

public class BOJ01938 {
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static int n;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		boolean[][][] visit = new boolean[n][n][2]; // 가로, 세로 방문

		// 통나무
		ArrayList<Coordi> b = new ArrayList<Coordi>();
		// 도착 위치
		ArrayList<Coordi> e = new ArrayList<Coordi>();
		String line = "";
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);

				if (map[i][j] == 'B') {
					b.add(new Coordi(i, j, 0, 0));
				} else if (map[i][j] == 'E') {
					e.add(new Coordi(i, j, 0, 0));
				}
			}
		}

		// 가운데 기준 좌표
		// 통나무
		Coordi log;
		int rSum = 0;
		int cSum = 0;
		for (int i = 0; i < 3; i++) {
			rSum += b.get(i).row;
			cSum += b.get(i).col;
		}
		if (b.get(0).row == b.get(1).row)
			log = new Coordi(rSum / 3, cSum / 3, 0, 0); // 가로 상태
		else
			log = new Coordi(rSum / 3, cSum / 3, 0, 1); // 세로 상태

		// 목표지점
		Coordi goal;
		rSum = 0;
		cSum = 0;
		for (int i = 0; i < 3; i++) {
			rSum += e.get(i).row;
			cSum += e.get(i).col;
		}
		if (e.get(0).row == e.get(1).row)
			goal = new Coordi(rSum / 3, cSum / 3, 0, 0); // 가로 상태
		else
			goal = new Coordi(rSum / 3, cSum / 3, 0, 1); // 세로 상태

		int answer = 0;
		Queue<Coordi> q = new LinkedList<Coordi>();
		q.offer(log);

		Coordi now;
		while (!q.isEmpty()) {
			now = q.poll();

			if (visit[now.row][now.col][now.state])
				continue;
			visit[now.row][now.col][now.state] = true;

			if (now.row == goal.row && now.col == goal.col && now.state == goal.state) {
				answer = now.cnt;
				break;
			}

			int nextRow = 0;
			int nextCol = 0;

			for (int i = 0; i < 4; i++) {
				nextRow = now.row + dRow[i];
				nextCol = now.col + dCol[i];

				if (now.state == 0) { // 가로일때
					if (0 <= nextRow && nextRow < n && 0 <= nextCol - 1 && nextCol + 1 < n) {
						if (map[nextRow][nextCol - 1] != '1' && map[nextRow][nextCol] != '1'
								&& map[nextRow][nextCol + 1] != '1' && !visit[nextRow][nextCol][now.state]) {
							q.offer(new Coordi(nextRow, nextCol, now.cnt + 1, now.state));
						}
					}
				} else { // 세로일때
					if (0 <= nextRow - 1 && nextRow + 1 < n && 0 <= nextCol && nextCol < n) {
						if (map[nextRow - 1][nextCol] != '1' && map[nextRow][nextCol] != '1'
								&& map[nextRow + 1][nextCol] != '1' && !visit[nextRow][nextCol][now.state]) {
							q.offer(new Coordi(nextRow, nextCol, now.cnt + 1, now.state));
						}
					}
				}
			}

			// 회전
			if (chkRotation(now)) {
				q.offer(new Coordi(now.row, now.col, now.cnt + 1, (now.state == 0) ? 1 : 0));
			}
		}

		System.out.println(answer);
	}

	static boolean chkRotation(Coordi c) {
		int nRow = 0;
		int nCol = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				nRow = c.row + i;
				nCol = c.col + j;
				if (!(0 <= nRow && nRow < n && 0 <= nCol && nCol < n && map[nRow][nCol] != '1')) {
					return false;
				}
			}
		}

		return true;
	}

	static class Coordi {
		int row;
		int col;
		int cnt;
		int state; // 0: 가로, 1: 세로

		public Coordi(int row, int col, int cnt, int state) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.state = state;
		}
	}
}
