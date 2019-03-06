import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14503.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 로봇 청소기
 *
 */

public class BOJ14503 {
	final static int NORTH = 0;
	final static int EAST = 1;
	final static int SOUTH = 2;
	final static int WEST = 3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 0:북, 1:동, 2:남, 3:서
		int d = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				// 0:빈칸, 1:벽
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cleanCnt = 0; // 청소한 칸 개수
		int chkCnt = 0; // 4방향 모두 검사해서 청소하거나 벽이면(4이면) 후진
		boolean flag = false; // true면 정지
		while (true) {
			if (map[r][c] == 0) {
				map[r][c] = -1; // 청소하면 -1로 표기
				cleanCnt++;
			}

			int tmp = map[r][c];
			map[r][c] = 2;
			map[r][c] = tmp;

			chkCnt++; // 정검 횟수 추가
			switch (d) {
			case NORTH:
				d = WEST;
				if (c - 1 >= 1 && map[r][c - 1] == 0) {
					c--;
					chkCnt = 0;
				}
				break;
			case EAST:
				d = NORTH;
				if (r - 1 >= 1 && map[r - 1][c] == 0) {
					r--;
					chkCnt = 0;
				}
				break;
			case SOUTH:
				d = EAST;
				if (c + 1 <= M && map[r][c + 1] == 0) {
					c++;
					chkCnt = 0;
				}
				break;
			case WEST:
				d = SOUTH;
				if (r + 1 <= N && map[r + 1][c] == 0) {
					r++;
					chkCnt = 0;
				}
				break;
			}

			// 4방향 청소할 곳이 없을 경우
			if (chkCnt == 4) {
				flag = true;
				switch (d) {
				case NORTH:
					if (r + 1 <= N && map[r + 1][c] != 1) {
						flag = false;
						r++;
					}
					break;
				case EAST:
					if (c - 1 >= 1 && map[r][c - 1] != 1) {
						flag = false;
						c--;
					}
					break;
				case SOUTH:
					if (r - 1 >= 1 && map[r - 1][c] != 1) {
						flag = false;
						r--;
					}
					break;
				case WEST:
					if (c + 1 <= M && map[r][c + 1] != 1) {
						flag = false;
						c++;
					}
					break;
				}

				if (flag) // 로봇 종료
					break;

				chkCnt = 0;
			}
		}

		System.out.println(cleanCnt);
	}
}
