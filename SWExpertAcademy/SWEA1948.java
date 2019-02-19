import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1948.java
 * @date 2019. 2. 18.
 * @author Park JunYoung
 * @description 날짜 계산기
 *
 */

public class SWEA1948 {
	static int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int month1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int month2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());

			int answer = 0;

			if (month1 == month2) {
				answer = day2 - day1 + 1;
			} else {
				answer += months[month1] - day1 + 1;
				for (int i = month1 + 1; i < month2; i++) {
					answer += months[i];
				}
				answer += day2;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
