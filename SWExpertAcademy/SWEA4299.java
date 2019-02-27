import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4299.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 태혁이의 사랑은 타이밍
 * 
 */

public class SWEA4299 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int answer = 0;
			answer += (d - 11) * 24 * 60;
			answer += (h - 11) * 60;
			answer += m - 11;

			if (answer < 0)
				answer = -1;

			System.out.println("#" + testCase + " " + answer);
		}
	}
}