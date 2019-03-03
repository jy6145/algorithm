import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3233.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 정삼각형 분할 놀이, 문제잘읽기
 *
 */

public class SWEA3233 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			long answer = A / B * A / B;

			System.out.println("#" + testCase + " " + answer);
		}
	}
}