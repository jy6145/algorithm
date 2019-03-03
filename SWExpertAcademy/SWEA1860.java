import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1860.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 진기의 최고급 붕어빵
 *
 */

public class SWEA1860 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] customer = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				customer[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(customer);

			int cnt = 0;
			boolean result = true;
			for (int i = 0; i < n; i++) {
				if ((customer[i] / m) * k - cnt <= 0) {
					result = false;
					break;
				}
				cnt++;
			}

			System.out.print("#" + testCase + " ");
			if (result)
				System.out.println("Possible");
			else
				System.out.println("Impossible");

		}
	}
}