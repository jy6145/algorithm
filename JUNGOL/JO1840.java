import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName JO1840.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 치즈, BFS
 * 
 */

public class JO1840 {
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visit;
	static int cheese;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[1 + n + 1][1 + m + 1];
		visit = new boolean[1 + n + 1][1 + m + 1];
		cheese = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}

		int hour = 0;
		int preCheese = cheese; // 녹기전 치즈
		int nextRow = 0;
		int nextCol = 0;
		Queue<Coordi> q = new LinkedList<Coordi>();
		while (cheese != 0) {
			preCheese = cheese; // 녹기전 치즈값 저장
			// bfs
			Coordi now;
			q.add(new Coordi(0, 0));
			visit = new boolean[1 + n + 1][1 + m + 1];
			while (!q.isEmpty()) {
				now = q.poll();

				if (visit[now.row][now.col])
					continue;
				visit[now.row][now.col] = true;

				delCheese(now, hour + 1);

//				int tmp = map[now.row][now.col];
//				map[now.row][now.col] = -9; //현재 위치 임시로 9 지정
//				System.out.println(cheese);
//				map[now.row][now.col] = tmp;

				for (int k = 0; k < 4; k++) {
					nextRow = now.row + dRow[k];
					nextCol = now.col + dCol[k];

					if (0 <= nextRow && nextRow <= n + 1 && 0 <= nextCol && nextCol <= m + 1
							&& map[nextRow][nextCol] >= (-1) * hour)
						q.offer(new Coordi(nextRow, nextCol));
				}
			}
			hour++;
		}

		System.out.println(hour);
		System.out.println(preCheese);
	}

	static void printMap(int[][] map) {
		System.out.println("===============================================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
	}

	static void delCheese(Coordi coordi, int hour) {
		int nRow = 0;
		int nCol = 0;
		for (int i = 0; i < 4; i++) {
			nRow = coordi.row + dRow[i];
			nCol = coordi.col + dCol[i];
			if (0 <= nRow && nRow <= n + 1 && 0 <= nCol && nCol <= m + 1 && map[nRow][nCol] == 1) {
				map[nRow][nCol] = (-1) * hour;
				cheese--;
			}
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
