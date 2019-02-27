import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4789.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 성공적인 공연 기획
 * 
 */
public class SWEA4789 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();

			int sum = str.charAt(0) - '0';
			int answer = 0;
			int now = 0;
			for (int i = 1; i < str.length(); i++) {
				now = str.charAt(i) - '0';

				if (sum < i) {
					answer += i - sum;
					sum += i - sum;
				}

				sum += now;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}