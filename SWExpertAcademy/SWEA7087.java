import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName SWEA7087.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 문제 제목 붙이기
 *
 */

public class SWEA7087 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			boolean[] flag = new boolean[26];

			String tmp = "";
			for (int i = 0; i < n; i++) {
				tmp = br.readLine();
				flag[tmp.charAt(0) - 'A'] = true;
			}

			int answer = 0;
			for (int i = 0; i < 26; i++) {
				if (!flag[i])
					break;

				answer++;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}