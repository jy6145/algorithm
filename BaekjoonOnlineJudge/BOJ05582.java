import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ05582.java
 * @date 2019. 3. 26.
 * @author Park JunYoung
 * @description 공통 부분 문자열, DP
 *
 */

public class BOJ05582 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		int max = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					if (max < dp[i + 1][j + 1])
						max = dp[i + 1][j + 1];
				} else
					dp[i][j] = 0;
			}
		}

		System.out.println(max);

	}// main
}