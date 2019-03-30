import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName BOJ15683.java
 * @date 2019. 3. 30.
 * @author Park JunYoung
 * @description 감시, DFS
 *
 */

public class BOJ15683 {
	static int N, M;
	static List<Coordi> cam;
	static int min;

	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		cam = new ArrayList<Coordi>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5)
					cam.add(new Coordi(i, j));
			}
		}

		min = Integer.MAX_VALUE;
		dfs(map, 0);

		System.out.println(min);
	}

	static void dfs(int[][] map, int select) {
		if (select == cam.size()) {
			int blindSpot = calcSpot(map); // 사각지대 검사
			if (blindSpot < min)
				min = blindSpot;

			return;
		}

		Coordi now = cam.get(select);
		int[][] cpMap = new int[N][M];

		switch (map[now.row][now.col]) {
		case 1:
			for (int i = 0; i < 4; i++) {
				copyArr(map, cpMap);
				chkSight(cpMap, now.row, now.col, i);
				dfs(cpMap, select + 1);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				copyArr(map, cpMap);
				chkSight(cpMap, now.row, now.col, i);
				chkSight(cpMap, now.row, now.col, i + 2);
				dfs(cpMap, select + 1);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				copyArr(map, cpMap);
				chkSight(cpMap, now.row, now.col, i % 4);
				chkSight(cpMap, now.row, now.col, (i + 1) % 4);
				dfs(cpMap, select + 1);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				copyArr(map, cpMap);
				chkSight(cpMap, now.row, now.col, i % 4);
				chkSight(cpMap, now.row, now.col, (i + 1) % 4);
				chkSight(cpMap, now.row, now.col, (i + 2) % 4);
				dfs(cpMap, select + 1);
			}
			break;
		case 5:
			copyArr(map, cpMap);
			for (int i = 0; i < 4; i++)
				chkSight(cpMap, now.row, now.col, i);
			dfs(cpMap, select + 1);
			break;
		}
	}

	static int calcSpot(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0)
					cnt++;

		return cnt;
	}

	static void chkSight(int[][] map, int row, int col, int dir) {
		row += dRow[dir];
		col += dCol[dir];

		while (0 <= row && row < N && 0 <= col && col < M) {
			if (map[row][col] == 6)
				break;
			else if (!(1 <= map[row][col] && map[row][col] <= 5)) // CCTV가 아니라면 표기
				map[row][col] = 9;

			row += dRow[dir];
			col += dCol[dir];
		}
	}

	static void copyArr(int[][] map, int[][] cpMap) {
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, cpMap[i], 0, map[i].length);
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
