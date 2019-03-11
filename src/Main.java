import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // 목표 금액

		int[] coins = new int[n + 1];
		for (int i = 1; i <= n; i++)
			coins[i] = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= k; i++) {
			dp[0][i] = 1000001; // 최대크기
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) { // 금액
				if (coins[i] > j)
					dp[i][j] = dp[i - 1][j];
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
				}
			}
		}

		if (dp[n][k] >= 100001)
			System.out.println(-1);
		else
			System.out.println(dp[n][k]);
	}
}
