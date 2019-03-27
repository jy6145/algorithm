import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3750.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description Digit sum, 재귀
 * 
 */

public class SWEA3750 {
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String num = br.readLine();

			answer = 0;
			func(num);

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void func(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++)
			sum += num.charAt(i) - '0';

		if (sum >= 10)
			func(String.valueOf(sum));
		else
			answer = sum;
	}
}