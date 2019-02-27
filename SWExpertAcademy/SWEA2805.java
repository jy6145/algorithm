
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2805.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 농작물 수확하기 	
 * 
 */

public class SWEA2805 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];

			String tmp = "";
			for (int i = 0; i < n; i++) {
				tmp = br.readLine();
				for (int j = 0; j < n; j++) {
					farm[i][j] = tmp.charAt(j) - '0';
				}
			}

			int revenue = 0;
			for (int i = 0; i <= n / 2; i++) {
				for (int j = n / 2 - i; j <= n / 2 + i; j++) {
					revenue += farm[i][j];
				}
			}

			for (int i = n / 2 + 1; i < n; i++) {
				for (int j = n / 2 - (n - i - 1); j <= n / 2 + (n - i - 1); j++) {
					revenue += farm[i][j];
				}
			}

			System.out.println("#" + testCase + " " + revenue);
		} // tc
	}
}