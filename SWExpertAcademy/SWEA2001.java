
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2001.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 파리 퇴치, 4중for문
 * 
 */

public class SWEA2001 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] fly = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			int maxSum = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					sum = 0;
					for (int k = 0; k < m; k++) {
						for (int l = 0; l < m; l++) {
							sum += fly[i + k][j + l];
						}
					}
					if (sum > maxSum)
						maxSum = sum;
				}
			}

			System.out.println("#" + testCase + " " + maxSum);
		}
	}
}
