import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3499.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 퍼펙트 셔플
 * 
 */

public class SWEA3499 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			String[] str = new String[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				str[i] = st.nextToken();
			}

			int flag = 0; // 짝수일 겨우
			if (n % 2 == 1) // 홀수일 경우
				flag = 1;

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			for (int i = 0; i < n / 2; i++) {
				answer.append(str[i]);
				answer.append(" ");
				answer.append(str[n / 2 + flag + i]);
				answer.append(" ");
			}

			if (flag == 1)
				answer.append(str[n / 2]);

			System.out.println(answer.toString());
		} // tc
	}
}