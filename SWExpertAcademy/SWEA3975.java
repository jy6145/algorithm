import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3975.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 승률 비교하기
 *
 */

public class SWEA3975 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			double C = Double.parseDouble(st.nextToken());
			double D = Double.parseDouble(st.nextToken());

			double rate1 = A / B;
			double rate2 = C / D;

			String answer = "";
			if (rate1 > rate2)
				answer = "ALICE";
			else if (rate1 == rate2)
				answer = "DRAW";
			else
				answer = "BOB";

			System.out.println("#" + testCase + " " + answer);
		}
	}
}