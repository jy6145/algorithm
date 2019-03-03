import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5789.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 현주의 상자 바꾸기
 *
 */

public class SWEA5789 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int[] box = new int[N + 1];

			int L = 0;
			int R = 0;
			for (int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());

				for (int j = L; j <= R; j++) {
					box[j] = i;
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			for (int i = 1; i <= N; i++) {
				answer.append(box[i] + " ");
			}

			System.out.println(answer);
		}
	}
}