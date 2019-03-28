import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2105.java
 * @date 2019. 3. 28.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 디저트 카페, BFS
 * 
 */

public class SWEA2105 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, -1, 0, 1 };
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] seaCnt = new int[N][M]; // 주위 바다 개수

		int ice = 0; // 빙산의 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					ice++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					seaCnt[i][j] = calcMelt(i, j);
			}
		}

		int year = 1;
		boolean split = false;

		int[][] mapCp;
		int[][] seaCntCp;
		while (true) {
			// 녹는거 계산
			mapCp = new int[N][M];
			seaCntCp = new int[N][M];

			boolean bfsFlag = false;
			Coordi start = null; // BFS 시작 지점
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						if (map[i][j] != 0)
							mapCp[i][j] = Math.max(map[i][j] - seaCnt[i][j], 0);

						if (map[i][j] != 0 && mapCp[i][j] == 0) { // 녹아서 0이 되면
							ice--;

							seaCntCp[i - 1][j] = seaCnt[i - 1][j] + 1;
							seaCntCp[i + 1][j] = seaCnt[i + 1][j] + 1;
							seaCntCp[i][j - 1] = seaCnt[i][j - 1] + 1;
							seaCntCp[i][j + 1] = seaCnt[i][j + 1] + 1;

							bfsFlag = true; // 얼음이 녹으면 BFS를 통해 쪼개지는거 확인
						} else if (mapCp[i][j] > 0 && start == null)
							start = new Coordi(i, j);
					}
				}
			}

			map = mapCp;
			seaCnt = seaCntCp;

			// BFS 돌렸을 때, 얼음 개수가 맞지 않으면 빙하가 쪼개짐
			if (bfsFlag) {
				Queue<Coordi> q = new LinkedList<Coordi>();
				visit = new boolean[N][M];
				if (start != null) {
					q.offer(start);
					visit[start.row][start.col] = true;
				}

				Coordi now = null;
				int tmp = 0; // BFS로 빙하개수 세기
				int nRow = 0;
				int nCol = 0;
				while (!q.isEmpty()) {
					now = q.poll();
					tmp++;

					for (int i = 0; i < 4; i++) {
						nRow = now.row + dRow[i];
						nCol = now.col + dCol[i];

						if (map[nRow][nCol] != 0 && !visit[nRow][nCol]) {
							visit[nRow][nCol] = true;
							q.offer(new Coordi(nRow, nCol));
						}
					}
				}

				if (ice != tmp) {
					split = true;
					break;
				}
			}

			year++;
		}

		if (split)
			System.out.println(year);
		else
			System.out.println(0);
	}

	static int calcMelt(int row, int col) {
		int nRow = 0;
		int nCol = 0;
		int cnt = 0; // 바다 개수
		for (int i = 0; i < 4; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];

			if (map[nRow][nCol] == 0) {
				cnt++;
			}
		}

		return cnt;
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
