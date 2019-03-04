import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5550.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 나는 개구리로소이다
 * 
 */

public class SWEA5550 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int[] cnt = new int[5]; // c, r, o, a, k 개수 저장

			String str = br.readLine();
			boolean flag = false;
			int answer = 0;
			int calcCnt = 0; // 개구리를 세는 변수

			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case 'c':
					cnt[0]++;
					calcCnt++; // c 가 시작되면 개구리가 추가
					if (answer < calcCnt)
						answer = calcCnt;
					break;
				case 'r':
					cnt[0]--;
					if (cnt[0] < 0) { // Error
						flag = true;
						break;
					}
					cnt[1]++;
					break;
				case 'o':
					cnt[1]--;
					if (cnt[1] < 0) { // Error
						flag = true;
						break;
					}
					cnt[2]++;
					break;
				case 'a':
					cnt[2]--;
					if (cnt[2] < 0) { // Error
						flag = true;
						break;
					}
					cnt[3]++;
					break;
				case 'k':
					cnt[3]--;
					calcCnt--; // 끝나면 개구리 수 감소
					if (cnt[3] < 0) { // Error
						flag = true;
						break;
					}
					break;
				}

				if (flag)
					break;
			}

			if (flag || cnt[0] != 0 || cnt[1] != 0 || cnt[2] != 0 || cnt[3] != 0) {
				answer = -1;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
