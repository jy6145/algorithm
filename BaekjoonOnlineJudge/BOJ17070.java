import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ17070.java
 * @date 2019. 4. 4.
 * @author Park JunYoung
 * @description 파이프 옮기기 1, DP
 *
 */

public class BOJ17070 {
	static int[] dRow = { 0, 1, 1 };
	static int[] dCol = { 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		Node[][] dp = new Node[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = new Node(0, 0, 0);
			}
		}

		for (int i = 2; i <= n; i++) {
			if (map[1][i] == 1)
				break;

			dp[1][i].cnt1 = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 3; j <= n; j++) {
				if (map[i][j] == 0) {
					dp[i][j].cnt1 += dp[i][j - 1].cnt1 + dp[i][j - 1].cnt3;
					dp[i][j].cnt2 += dp[i - 1][j].cnt2 + dp[i - 1][j].cnt3;
				}

				if (map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0)
					dp[i][j].cnt3 += dp[i - 1][j - 1].cnt1 + dp[i - 1][j - 1].cnt2 + dp[i - 1][j - 1].cnt3;
			}
		}

		System.out.println(dp[n][n].cnt1 + dp[n][n].cnt2 + dp[n][n].cnt3);
	}

	static class Node {
		int cnt1; // 가로
		int cnt2; // 세로
		int cnt3; // 대각선

		public Node(int cnt1, int cnt2, int cnt3) {
			this.cnt1 = cnt1;
			this.cnt2 = cnt2;
			this.cnt3 = cnt3;
		}
	}
}
