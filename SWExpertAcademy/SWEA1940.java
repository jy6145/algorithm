
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1940.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 가랏! RC카!
 * 
 */

public class SWEA1940 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int v = 0; // 현재 속도
			int dist = 0; // 이동 거리
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				int cmd = Integer.parseInt(st.nextToken());
				int a = 0; // 가속도
				if (cmd != 0) {
					a = Integer.parseInt(st.nextToken());
				}

				if (cmd == 1) {
					v += a;
				} else if (cmd == 2) {
					v = Math.max(v - a, 0);// 0이상
				}

				dist += v;
			}

			System.out.println("#" + testCase + " " + dist);
		}
	}
}
