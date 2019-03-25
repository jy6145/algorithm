import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		// 0:북, 1:동, 2:남, 3:서
		int dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cleanCnt = 0;

		while (true) {
			// 1. 현재 위치를 청소
			if (map[row][col] == 0) {
				map[row][col] = -1; // 청소한 영역 : -1
				cleanCnt++;
			}

			// 2. 위치에서 4방향 탐색
			// 2-1. 왼쪽부터 청소 공간이 존재한다면 전진하고 청소
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				dir--;
				if (dir < 0)
					dir = 3;

				switch (dir) {
				case 0: // 북
					if (map[row - 1][col] == 0) {
						row--;
						flag = true;
					}
					break;
				case 1: // 동
					if (map[row][col + 1] == 0) {
						col++;
						flag = true;
					}
					break;
				case 2: // 남
					if (map[row + 1][col] == 0) {
						row++;
						flag = true;
					}
					break;
				case 3:// 서
					if (map[row][col - 1] == 0) {
						col--;
						flag = true;
					}
					break;
				}

				if (flag)
					break;
			}

			if (flag)
				continue;

			// 2-3. 후진
			boolean endFlag = false;
			switch (dir) {
			case 0: // 북
				if (map[row + 1][col] != 1) {
					row++;
					continue;
				}
				break;
			case 1: // 동
				if (col - 1 >= 0 && map[row][col - 1] != 1) {
					col--;
					continue;
				}
				break;
			case 2: // 남
				if (map[row - 1][col] != 1) {
					row--;
					continue;
				}
				break;
			case 3:// 서
				if (col + 1 < M && map[row][col + 1] != 1) {
					col++;
					continue;
				}
				break;
			}

			// 2-4. 작동 정지 확인
			break;
		}

		System.out.println(cleanCnt);
	}
}