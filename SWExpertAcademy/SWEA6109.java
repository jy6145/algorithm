import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6109.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 추억의 2048게임
 * 
 */

public class SWEA6109 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String cmd = st.nextToken();

			int[][] arr = new int[n][n];
			int[][] result = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Integer> q = new LinkedList<Integer>();
			int pre = -1; // 이전 값
			int idx = 0;
			int start = 0;
			if (cmd.equals("up")) {
				// 0 아닌 지점부터 시작
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[j][i] != 0) {
							start = j;
							break;
						}
					}
					idx = 0;
					pre = arr[start][i];
					for (int j = start + 1; j < n; j++) {
						if (arr[j][i] == 0)
							continue;

						if (arr[j][i] == pre) { // 이전값이랑 같을 경우
							result[idx++][i] = pre * 2;
							pre = -1;
						} else {
							if (pre == -1) // 이전에 숫자가 합쳐져서 합칠 숫자가 없을 경우
								pre = arr[j][i];
							else {
								result[idx++][i] = pre;
								pre = arr[j][i];
							}
						}
					}
					if (pre != -1)
						result[idx++][i] = pre;
				}
			} else if (cmd.equals("down")) {
				// 0 아닌 지점부터 시작
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						if (arr[j][i] != 0) {
							start = j;
							break;
						}
					}
					idx = n - 1;
					pre = arr[start][i];
					for (int j = start - 1; j >= 0; j--) {
						if (arr[j][i] == 0)
							continue;

						if (arr[j][i] == pre) { // 이전값이랑 같을 경우
							result[idx--][i] = pre * 2;
							pre = -1;
						} else {
							if (pre == -1) // 이전에 숫자가 합쳐져서 합칠 숫자가 없을 경우
								pre = arr[j][i];
							else {
								result[idx--][i] = pre;
								pre = arr[j][i];
							}
						}
					}
					if (pre != -1)
						result[idx--][i] = pre;
				}
			} else if (cmd.equals("left")) {
				// 0 아닌 지점부터 시작
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[i][j] != 0) {
							start = j;
							break;
						}
					}
					idx = 0;
					pre = arr[i][start];
					for (int j = start + 1; j < n; j++) {
						if (arr[i][j] == 0)
							continue;

						if (arr[i][j] == pre) { // 이전값이랑 같을 경우
							result[i][idx++] = pre * 2;
							pre = -1;
						} else {
							if (pre == -1) // 이전에 숫자가 합쳐져서 합칠 숫자가 없을 경우
								pre = arr[i][j];
							else {
								result[i][idx++] = pre;
								pre = arr[i][j];
							}
						}
					}
					if (pre != -1)
						result[i][idx++] = pre;
				}

			} else if (cmd.equals("right")) {
				// 0 아닌 지점부터 시작
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						if (arr[i][j] != 0) {
							start = j;
							break;
						}
					}
					idx = n - 1;
					pre = arr[i][start];
					for (int j = start - 1; j >= 0; j--) {
						if (arr[i][j] == 0)
							continue;

						if (arr[i][j] == pre) { // 이전값이랑 같을 경우
							result[i][idx--] = pre * 2;
							pre = -1;
						} else {
							if (pre == -1) // 이전에 숫자가 합쳐져서 합칠 숫자가 없을 경우
								pre = arr[i][j];
							else {
								result[i][idx--] = pre;
								pre = arr[i][j];
							}
						}
					}
					if (pre != -1)
						result[i][idx--] = pre;
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer.append(result[i][j] + " ");
				}
				answer.append("\n");
			}

			System.out.print(answer.toString());
		}
	}
}