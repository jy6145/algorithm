import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3282.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 0/1 Knapsack, DP
 * 
 */

public class SWEA3282 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // 물건의 개수
			int k = Integer.parseInt(st.nextToken()); // 물건 부피 합

			int[] v = new int[n + 1]; // 부피
			int[] c = new int[n + 1]; // 가치

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][k + 1]; // k번째 물건까지 계산하는데 무게 최대치가 n일때 최대 가치

			for (int i = 1; i <= n; i++) { // 물건 선택
				for (int j = 1; j <= k; j++) { // 부피 최대치 선택
					if (v[i] > j) { // 가방에 아무것도 없어도 너무 커서 못넣음
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - v[i]] + c[i], dp[i - 1][j]);
					}
				}
			}

			System.out.println("#" + testCase + " " + dp[n][k]);
		} // tc
	}

}