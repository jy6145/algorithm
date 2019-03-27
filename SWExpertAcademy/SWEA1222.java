import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName SWEA1222.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 6일차 - 계산기1
 * 
 */

public class SWEA1222 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine(); // 문자열 길이
			String calc = br.readLine();
			int answer = 0;
			for (int i = 0; i < calc.length(); i++) {
				if ('0' <= calc.charAt(i) && calc.charAt(i) <= '9')
					answer += calc.charAt(i) - '0';
				else
					continue;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}