import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4301.java
 * @date 2019. 3. 15.
 * @author Park JunYoung
 * @description 콩 많이 심기
 * 
 */

public class SWEA4301 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int answer = 0;
			answer += N / 4 * (M * 2);

			if (N % 4 != 0) {
				int[] dp = new int[M + 1];
				for (int i = 1; i <= M; i++) {
					if (i % 4 == 1 || i % 4 == 2)
						dp[i] = dp[i - 1] + 1;
					else
						dp[i] = dp[i - 1];
				}

				switch (N % 4) {
				case 1:
					answer += dp[M];
					break;
				case 2:
					answer += dp[M] * 2;
					break;
				case 3:
					answer += dp[M] + M;
					break;
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
