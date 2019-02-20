import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5549.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 홀수일까 짝수일까
 * 
 */

public class SWEA5549 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String s = br.readLine();

			int lastDigit = s.charAt(s.length() - 1) - '0';

			String answer = "";
			if (lastDigit % 2 == 1)
				answer = "Odd";
			else
				answer = "Even";

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
