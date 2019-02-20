import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5515.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 2016년 요일 맞추기, 요일
 * 
 */

public class SWEA5515 {
	static int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			int days = 0;
			if (month == 1) {
				days = day;
			} else {
				for (int i = 1; i < month; i++)
					days += months[i];

				days += day;
			}

			int answer = (days + 3) % 7;

			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}
