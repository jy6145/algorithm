import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01149.java
 * @date 2019. 3. 28.
 * @author Park JunYoung
 * @description RGB거리, DP
 * 
 */

public class BOJ01149 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][3];
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][j];
				else if (j == 1)
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][j];
				else
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][j];
			}
		}

		System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
	}
}