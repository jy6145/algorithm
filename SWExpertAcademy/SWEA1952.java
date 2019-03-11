import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1952.java
 * @date 2019. 3. 11.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 수영장, DP
 *
 */

public class SWEA1952 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int[] price = new int[4]; // 1일, 1달, 3달, 1년 가격
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());

			int[] month = new int[12 + 1]; // 1년 이용 계획
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++)
				month[i] = Integer.parseInt(st.nextToken());

			int[][] dp = new int[4][12 + 1];

			int tmp = 0;
			for (int i = 0; i < 4; i++) { // 금액
				for (int j = 1; j <= 12; j++) { // 월
					if (month[j] == 0) // 해당 달에 이용을 안할 경우
						dp[i][j] = dp[i][j - 1];
					else {
						// 인덱스 오류 방지
						if (j - 3 < 0)
							tmp = 3 - j;
						else
							tmp = 0;

						dp[i][j] = calcMin(dp[i][j - 1] + month[j] * price[0], dp[i][j - 1] + price[1],
								dp[i][j - 3 + tmp] + price[2]);

						if (dp[i][j] > price[3]) { // 1년 요금이 가장 작을 경우, 이후 값과 상관없이 1년 요금을 선택
							for (int k = j; k <= 12; k++)
								dp[i][k] = price[3];
							break;
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + dp[3][12]);
		}
	}

	static int calcMin(int a, int b, int c) {
		int tmp = Math.min(a, b);

		return Math.min(tmp, c);
	}
}