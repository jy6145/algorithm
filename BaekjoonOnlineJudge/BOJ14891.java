import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14891.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 톱니바퀴
 *
 */
public class BOJ14891 {
	static int[][] wheel;
	static int[] dirList;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		wheel = new int[4 + 1][8]; // 톱니바퀴 번호, 정보

		String str = "";
		for (int i = 1; i <= 4; i++) {
			str = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}

		int n = 0; // 톱니바퀴 번호
		int dir = 0; // 방향
		int k = Integer.parseInt(br.readLine());
		boolean flag = false; // true면 정지
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());

			dirList = new int[4 + 1]; // 바퀴들의 회전 정보
			// 회전 결정
			dirList[n] = dir;
			if (n == 1) {
				// 오른쪽으로
				for (int j = 0; j < 3; j++) {
					if (wheel[n + j][2] != wheel[n + 1 + j][6]) {
						dirList[n + 1 + j] = (-1) * dirList[n + j];
					} else {
						break;
					}
				}
			} else if (n == 2) {
				// 왼쪽으로
				for (int j = 0; j < 1; j++) {
					if (wheel[n - j][6] != wheel[n - 1 - j][2]) {
						dirList[n - 1 - j] = (-1) * dirList[n - j];
					} else {
						break;
					}
				}

				// 오른쪽으로
				for (int j = 0; j < 2; j++) {
					if (wheel[n + j][2] != wheel[n + 1 + j][6]) {
						dirList[n + 1 + j] = (-1) * dirList[n + j];
					} else {
						break;
					}
				}
			} else if (n == 3) {
				// 왼쪽으로
				for (int j = 0; j < 2; j++) {
					if (wheel[n - j][6] != wheel[n - 1 - j][2]) {
						dirList[n - 1 - j] = (-1) * dirList[n - j];
					} else {
						break;
					}
				}

				// 오른쪽으로
				for (int j = 0; j < 1; j++) {
					if (wheel[n + j][2] != wheel[n + 1 + j][6]) {
						dirList[n + 1 + j] = (-1) * dirList[n + j];
					} else {
						break;
					}
				}
			} else if (n == 4) {
				// 왼쪽으로
				for (int j = 0; j < 3; j++) {
					if (wheel[n - j][6] != wheel[n - 1 - j][2]) {
						dirList[n - 1 - j] = (-1) * dirList[n - j];
					} else {
						break;
					}
				}
			}

			// 회전시키기
			for (int j = 1; j <= 4; j++) {
				if (dirList[j] == 1)
					clockMove(j);
				else if (dirList[j] == -1)
					clockRevMove(j);
			}
		}

		int answer = 0;
		for (int i = 1; i <= 4; i++) {
			if (wheel[i][0] == 1)
				answer += Math.pow(2, i - 1);
		}

		System.out.println(answer);
	}

	static void clockMove(int n) {
		int tmp = wheel[n][7];
		for (int i = 7; i >= 1; i--)
			wheel[n][i] = wheel[n][i - 1];

		wheel[n][0] = tmp;
	}

	static void clockRevMove(int n) {
		int tmp = wheel[n][0];
		for (int i = 0; i < 7; i++)
			wheel[n][i] = wheel[n][i + 1];

		wheel[n][7] = tmp;
	}
}
