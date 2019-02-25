
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1974.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 스도쿠 검증 	
 * 
 */

public class SWEA1974 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int[][] sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] chk = new boolean[9 + 1];
			boolean flag = false; // true일 경우 오답

			// 행 검사
			for (int i = 0; i < 9; i++) {
				chk = new boolean[9 + 1]; // 초기화

				for (int j = 0; j < 9; j++) {
					if (chk[sudoku[i][j]]) {
						flag = true;
						break;
					} else {
						chk[sudoku[i][j]] = true;
					}
				}

				if (flag) {
					break;
				}
			}

			// 열 검사
			if (!flag) {
				for (int i = 0; i < 9; i++) {
					chk = new boolean[9 + 1]; // 초기화

					for (int j = 0; j < 9; j++) {
						if (chk[sudoku[j][i]]) {
							flag = true;
							break;
						} else {
							chk[sudoku[j][i]] = true;
						}
					}

					if (flag) {
						break;
					}
				}
			}

			// 3*3 검사
			Loop: if (!flag) {
				for (int i = 0; i < 9; i += 3) {
					for (int j = 0; j < 9; j += 3) {
						chk = new boolean[9 + 1]; // 초기화
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								if (chk[sudoku[i + k][j + l]]) {
									flag = true;
									break Loop;
								} else {
									chk[sudoku[i + k][j + l]] = true;
								}
							}
						}

					}
				}
			}

			int answer = flag ? 0 : 1;
			System.out.println("#" + testCase + " " + answer);
		}
	}
}
