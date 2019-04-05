import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5650.java
 * @date 2019. 4. 6.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 핀볼 게임, 시뮬레이션
 *
 */

public class SWEA5650 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	static int n;
	static int[][] map;
	static int dir;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine().trim());
			map = new int[n + 2][n + 2];
			int[][][] wormHole = new int[5][2][2]; // 웜홀 번호, 2쌍, 행/열

			for (int i = 0; i <= n + 1; i++) {
				map[i][0] = 5;
				map[0][i] = 5;
				map[n + 1][i] = 5;
				map[i][n + 1] = 5;
			}

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (6 <= map[i][j] && map[i][j] <= 10) {
						if (wormHole[map[i][j] - 6][0][0] == 0) {
							wormHole[map[i][j] - 6][0][0] = i;
							wormHole[map[i][j] - 6][0][1] = j;
						} else {
							wormHole[map[i][j] - 6][1][0] = i;
							wormHole[map[i][j] - 6][1][1] = j;
						}
					}
				}
			}

			dir = 0; // 0:상, 1:우, 2:하, 3:좌
			int row, col;
			int now = 0;
			int score = 0;
			int maxScore = 0;
			int preDir = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							row = i;
							col = j;
							dir = k;
							score = 0;

							while (true) {
								row += dRow[dir];
								col += dCol[dir];
								now = map[row][col];

								if (now == -1 || (row == i && col == j)) { // 블랙홀이거나 처음 장소이면
									break;
								}

								if (1 <= now && now <= 5) { // 벽이면
									score++;
									preDir = dir;
									chkDir(now);
									if ((preDir + 2) % 4 == dir) { // 180도 전환이면 기존에 왔던길을 반복
										score = score * 2 - 1;
										break;
									}
								} else if (6 <= now && now <= 10) { // 웜홀이면
									if (row == wormHole[now - 6][0][0] && col == wormHole[now - 6][0][1]) {
										row = wormHole[now - 6][1][0];
										col = wormHole[now - 6][1][1];
									} else {
										row = wormHole[now - 6][0][0];
										col = wormHole[now - 6][0][1];
									}
								}

							}

							maxScore = Math.max(score, maxScore);
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + maxScore);
		}
	}

	static void chkDir(int now) {
		switch (now) {
		case 1:
			switch (dir) {
			case 0:
			case 1:
				dir = (dir + 2) % 4;
				break;
			case 2:
				dir = 1;
				break;
			case 3:
				dir = 0;
				break;
			}
			break;
		case 2:
			switch (dir) {
			case 1:
			case 2:
				dir = (dir + 2) % 4;
				break;
			case 0:
				dir = 1;
				break;
			case 3:
				dir = 2;
				break;
			}
			break;
		case 3:
			switch (dir) {
			case 2:
			case 3:
				dir = (dir + 2) % 4;
				break;
			case 0:
				dir = 3;
				break;
			case 1:
				dir = 2;
				break;
			}
			break;
		case 4:
			switch (dir) {
			case 0:
			case 3:
				dir = (dir + 2) % 4;
				break;
			case 1:
				dir = 0;
				break;
			case 2:
				dir = 3;
				break;
			}
			break;
		case 5:
			dir = (dir + 2) % 4;
			break;
		}
	}
}
