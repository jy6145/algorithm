
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @fileName Solution.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 패턴 마디의 길이, 3중for문
 * 
 */

public class SWEA2007 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			String word = "";

			int cnt = 0; // 반복 횟수
			int maxCnt = 0;
			int wordlength = 0;
			String tmp = "";
			for (int i = 1; i <= 10; i++) { // 마디의 길이
				for (int j = 0; j <= str.length() - i; j++) {
					word = str.substring(j, j + i);

					cnt = 0;
					for (int k = j; k <= str.length() - i; k += i) {
						tmp = str.substring(k, k + i);
						if (word.equals(tmp)) {
							cnt++;
							if (maxCnt < cnt) {
								maxCnt = cnt;
								wordlength = i;
							}
						} else {
							cnt = 0;
							break;
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + wordlength);
		}

	}

}
