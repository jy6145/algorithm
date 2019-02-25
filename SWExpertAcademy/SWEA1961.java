
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1961.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 숫자 배열 회전
 * 
 */

public class SWEA1961 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer.append(arr[n - 1 - j][i]);
				}
				answer.append(" ");

				for (int j = 0; j < n; j++) {
					answer.append(arr[n - 1 - i][n - 1 - j]);
				}
				answer.append(" ");

				for (int j = 0; j < n; j++) {
					answer.append(arr[j][n - 1 - i]);
				}

				if (i != n - 1) {
					answer.append("\n");
				}
			}

			System.out.println(answer.toString());
		}
	}
}
