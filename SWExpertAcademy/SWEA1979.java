
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1979.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 어디에 단어가 들어갈 수 있을까, 비효율
 * 
 */

public class SWEA1979 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String answer = "";

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] puzzle = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken()); // 흰색 : 1, 검정 : 0
				}
			}

			int cnt = 0; // k 길이의 단어 개수
			boolean flag = false; // 단어 시작일때 true
			int nowLength = 0;

			// 가로 검사
			for (int i = 0; i < n; i++) {
				flag = false;

				for (int j = 0; j < n; j++) {
					if (!flag) {// 단어 시작부분 찾기
						if (puzzle[i][j] == 1) {
							nowLength = 1;
							flag = true;
						}

					} else {// 단어 진입해서 처리
						if (puzzle[i][j] == 0 || j == n - 1) { // 단어가 끝나는 지점
							if (puzzle[i][j] == 1)
								nowLength++;

							if (k == nowLength) {
								cnt++;
							}
							flag = false;
						} else {
							nowLength++;
						}
					}
				}
			}

			// 세로 검사
			for (int j = 0; j < n; j++) {
				flag = false;

				for (int i = 0; i < n; i++) {
					if (!flag) {// 단어 시작부분 찾기
						if (puzzle[i][j] == 1) {
							nowLength = 1;
							flag = true;
						}

					} else {// 단어 진입해서 처리
						if (puzzle[i][j] == 0 || i == n - 1) { // 단어가 끝나는 지점
							if (puzzle[i][j] == 1)
								nowLength++;

							if (k == nowLength) {
								cnt++;
							}
							flag = false;
						} else {
							nowLength++;
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
