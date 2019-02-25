
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1285.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 아름이의 돌 던지기, C만 제출 가능
 * 
 */

public class SWEA1285 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int tmp = 0;
			int min = Integer.MAX_VALUE;
			int cnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				tmp = Math.abs(Integer.parseInt(st.nextToken()));
				if (tmp < min) {
					cnt = 1;
					min = tmp;
				} else if (tmp == min) {
					cnt++;
				}
			}

			System.out.println("#" + testCase + " " + min + " " + cnt);
		}
	}
}
