import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3376.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 파도반 수열, 배열 작을때 고려하기!
 *
 */

public class SWEA3376 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			long[] P = new long[n + 1];
			P[0] = -1; // 0번째부터 배열은 사용 안함

			long answer = 0;
			if (n <= 3)
				answer = 1;
			else if (n <= 5)
				answer = 2;
			else {
				P[1] = 1;
				P[2] = 1;
				P[3] = 1;
				P[4] = 2;
				P[5] = 2;

				for (int i = 6; i <= n; i++) {
					P[i] = P[i - 5] + P[i - 1];
				}
				answer = P[n];
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}