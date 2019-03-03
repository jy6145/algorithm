import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1859.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 백만 장자 프로젝트
 *
 */

public class SWEA1859 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();

			String[] list = str.split(" ");

			long maxPrice = 1;
			long cnt = 0;
			long sum = 0;
			int now = 0;
			for (int i = list.length - 1; i >= 0; i--) {
				now = Integer.parseInt(list[i]);
				if (maxPrice < now) {
					sum += (maxPrice * cnt);
					cnt = 0;
					maxPrice = now;
				} else {
					cnt++;
					sum -= now;
				}
			}

			sum += (maxPrice * cnt);

			System.out.println("#" + testCase + " " + sum);
		}
	}
}