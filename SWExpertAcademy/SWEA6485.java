
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6485.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 삼성시의 버스 노선
 *
 */

public class SWEA6485 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[5001];
			int a;
			int b;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			}

			int p = Integer.parseInt(br.readLine());
			int[] c = new int[p];

			for (int i = 0; i < p; i++) {
				c[i] = Integer.parseInt(br.readLine());
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < p; i++) {
				sb.append(arr[c[i]] + " ");
			}
			System.out.println("#" + testCase + " " + sb.toString());

		}
	}
}
