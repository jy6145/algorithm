import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();

			long dp[] = new long[Math.max(A.length(), B.length()) + 1];
			for (int i = 1; i < dp.length; i++)
				dp[i] = (int) (dp[i - 1] * 8 + Math.pow(10, i - 1));

			long answer = 0;
			if (A.charAt(A.length() - 2) - '0' >= 4)
				answer += 1;

			int digit = 0;
			for (int i = dp.length - 2; i >= 0; i--) {
				digit = A.charAt(i) - 0;
				if (digit < 4)
					answer += dp[dp.length - (i + 1)] * (digit + 1);
				else
					answer += dp[dp.length - (i + 1)] * (digit - 1) + Math.pow(10, i - 1);
			}

			System.out.println(answer);
		}
	}
}