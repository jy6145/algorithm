import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5215.java
 * @date 2019. 2. 28.
 * @author Park JunYoung
 * @description 햄버거 다이어트, DP
 * 
 */

public class SWEA5215 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // 재료의 수
			int l = Integer.parseInt(st.nextToken()); // 제한 칼로리

			int[] flavor = new int[n + 1]; // 맛
			int[] kal = new int[n + 1]; // 칼로리

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				flavor[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][l + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= l; j++) {
					if (kal[i] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - kal[i]] + flavor[i], dp[i - 1][j]);
					}
				}
			}
			System.out.println("#" + testCase + " " + dp[n][l]);
		}
	}
}