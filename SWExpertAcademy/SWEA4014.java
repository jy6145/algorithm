
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4014.java
 * @date 2019. 2. 22.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 활주로 건설
 *
 */

public class SWEA4014 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // 지형의 길이
			int x = Integer.parseInt(st.nextToken()); // 경사로 길이

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int pre = 0; // 이전 높이
			int preCnt = 0; // 이전 높이 연속된 횟수
			int now = 0; // 현재 높이
			boolean flag = false; // true면 성공
			int cnt = 0; // 성공한 행 개수
			int diff = 0;

			// 가로 확인
			for (int i = 0; i < n; i++) {
				pre = map[i][0];
				flag = true;
				preCnt = 1;
				Loop1: for (int j = 1; j < n; j++) {
					pre = map[i][j - 1];
					now = map[i][j];
					diff = pre - now; // 이전값 - 현재값

					if (Math.abs(diff) > 1) { // 경사 차이가 2이상인 경우
						flag = false;
						break;
					} else if (diff == 1) { // 내려가는 경우
						if (n - j < x) { // 맵 공간이 부족해서 경사를 못 놓을 경우
							flag = false;
							break;
						}
						for (int k = j; k < j + x; k++) {
							if (map[i][k] != now) {
								flag = false;
								break Loop1;
							}
						}

						j += (x - 1); // x 만큼 경사로를 만듦
						preCnt = 0;
					} else if (diff == -1) { // 올라가는 경우
						if (preCnt < x) {
							flag = false;
							break;
						}
						preCnt = 1;
					} else if (diff == 0) { // 평평할 경우
						preCnt++;
					}
				}

				if (flag) {
					cnt++;
				}
			}

			// 세로 확인
			for (int i = 0; i < n; i++) {
				pre = map[0][i];
				flag = true;
				preCnt = 1;
				Loop1: for (int j = 1; j < n; j++) {
					pre = map[j - 1][i];
					now = map[j][i];
					diff = pre - now; // 이전값 - 현재값

					if (Math.abs(diff) > 1) { // 경사 차이가 2이상인 경우
						flag = false;
						break;
					} else if (diff == 1) { // 내려가는 경우
						if (n - j < x) { // 맵 공간이 부족해서 경사를 못 놓을 경우
							flag = false;
							break;
						}
						for (int k = j; k < j + x; k++) {
							if (map[k][i] != now) {
								flag = false;
								break Loop1;
							}
						}

						j += (x - 1); // x 만큼 경사로를 만듦
						preCnt = 0;
					} else if (diff == -1) { // 올라가는 경우
						if (preCnt < x) {
							flag = false;
							break;
						}
						preCnt = 1;
					} else if (diff == 0) { // 평평할 경우
						preCnt++;
					}
				}

				if (flag) {
					cnt++;
				}
			}

			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
