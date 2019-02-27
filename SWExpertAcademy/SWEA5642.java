import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5642.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description [Professional] 합, DP
 * 
 */

public class SWEA5642 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[] dp = new int[n];

			st = new StringTokenizer(br.readLine());
			dp[0] = Integer.parseInt(st.nextToken());

			int now = 0;
			// dp[i]는 i번째를 포함했을 경우 가장 큰 수
			for (int i = 1; i < n; i++) {
				now = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i - 1] + now, now); // 이전 숫자를 포함할지 안할지 선택하기
			}

			int answer = 0;
			for (int i = 0; i < n; i++) {
				if (answer < dp[i])
					answer = dp[i];
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}