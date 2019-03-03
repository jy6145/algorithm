import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4676.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 늘어지는 소리 만들기, Arrays.sort 내림차순, Collections.reverseOrder(), sb.insert
 *
 */

public class SWEA4676 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			int h = Integer.parseInt(br.readLine()); // 하이픈 개수

			Integer[] lo = new Integer[h];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < h; i++) {
				lo[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(lo, Collections.reverseOrder());

			StringBuilder answer = new StringBuilder(str);
			for (int i = 0; i < h; i++) {
				answer.insert(lo[i].intValue(), '-');
			}

			System.out.println("#" + testCase + " " + answer.toString());
		}
	}
}