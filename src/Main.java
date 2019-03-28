import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = { 0, 1, 1, 1 };
	static int[] dCol = { 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] checkerboard = new int[19 + 2][19 + 2];

		boolean blackWin = false;
		boolean whiteWin = false;

		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				checkerboard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= 20; i++) { // 모서리 처리
			checkerboard[0][i] = -1;
			checkerboard[i][0] = -1;
			checkerboard[20][i] = -1;
			checkerboard[i][20] = -1;
		}

		// 오목 시 좌표
		int[] black = new int[2];
		int[] white = new int[2];

		int cnt = 0; // 연속된 돌 수
		int row = 0;
		int col = 0;
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (!blackWin && checkerboard[i][j] == 1) { // 검은돌일 경우
					// -> , \, |, / 순으로
					for (int k = 0; k < 4; k++) {
						cnt = 0;
						row = i;
						col = j;

						// 돌기전 값이 연속되있으면 검사 X
						if (checkerboard[row - dRow[k]][col - dCol[k]] == 1)
							continue;

						while (checkerboard[row][col] == 1) {
							cnt++;

							if (cnt == 5) { // 오목 발견 시
								blackWin = true;
								if (k == 3) {
									black[0] = row;
									black[1] = col;
								} else {
									black[0] = i;
									black[1] = j;
								}
							}

							if (cnt >= 6) {// 육목으로 되면 오목 취소
								blackWin = false;
								break;
							}

							row += dRow[k];
							col += dCol[k];
						}
					}
				} else if (!whiteWin && checkerboard[i][j] == 2) { // 흰돌일 경우
					// -> , \, |, / 순으로
					for (int k = 0; k < 4; k++) {
						cnt = 0;
						row = i;
						col = j;

						// 돌기전 값이 연속되있으면 검사 X
						if (checkerboard[row - dRow[k]][col - dCol[k]] == 2)
							continue;

						while (checkerboard[row][col] == 2) {
							cnt++;

							if (cnt == 5) { // 오목 발견 시
								whiteWin = true;
								if (k == 3) {
									white[0] = row;
									white[1] = col;
								} else {
									white[0] = i;
									white[1] = j;
								}
							}

							if (cnt >= 6) {// 육목으로 되면 오목 취소
								whiteWin = false;
								break;
							}

							row += dRow[k];
							col += dCol[k];
						}
					}
				}
			}
		}

		if (blackWin) {
			System.out.println(1);
			System.out.println(black[0] + " " + black[1]);
		} else if (whiteWin) {
			System.out.println(2);
			System.out.println(white[0] + " " + white[1]);
		} else {
			System.out.println(0);
		}
	}
}
