
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1976.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 시각 덧셈, 나머지 1부터 만들기
 * 
 */

public class SWEA1976 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());

			int carry = (min1 + min2) / 60;
			int minSum = (min1 + min2) % 60;
			int hourSum = (hour1 + hour2 + carry - 1) % 12 + 1;

			System.out.println("#" + testCase + " " + hourSum + " " + minSum);
		}
	}
}
