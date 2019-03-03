import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4522.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 세상의 모든 팰린드롬
 *
 */

public class SWEA4522 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();

			char left = ' ';
			char right = ' ';
			boolean flag = false; // true 경우 팰린드롬이 아님
			for (int i = 0; i < str.length() / 2; i++) {
				left = str.charAt(i);
				right = str.charAt(str.length() - 1 - i);

				if (left == '?' || right == '?')
					continue;

				if (left != right) {
					flag = true;
					break;
				}
			}

			System.out.print("#" + testCase + " ");
			if (flag)
				System.out.println("Not exist");
			else
				System.out.println("Exist");
		}
	}
}