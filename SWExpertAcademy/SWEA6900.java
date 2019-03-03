import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6900.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 주혁이의 복권 당첨
 *
 */

public class SWEA6900 {
	static String[] winCode;
	static long[] prize;
	static int n;
	static int m;
	static long answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			winCode = new String[n]; // 당첨 번호
			prize = new long[n]; // 상금
			String[] code = new String[m]; // 복권 번호

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				winCode[i] = st.nextToken();
				prize[i] = Long.parseLong(st.nextToken());
			}

			for (int i = 0; i < m; i++) {
				code[i] = br.readLine();
			}

			answer = 0;
			for (int i = 0; i < m; i++) {
				chkTicket(code[i]);
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static boolean chkTicket(String code) { // 복권 검증
		boolean result = false;

		for (int i = 0; i < n; i++) {
			result = true;
			for (int j = 0; j < 8; j++) {
				if (winCode[i].charAt(j) == '*')
					continue;
				else if (winCode[i].charAt(j) != code.charAt(j))
					result = false;
			}

			if (result) {
				answer += prize[i];
				break;
			}
		}

		return result;
	}
}