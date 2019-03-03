import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2817.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 부분 수열의 합, PowerSet
 *
 */

public class SWEA2817 {
	static int[] arr;
	static int N;
	static int K;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			answer = 0;
			powerSet(0, 0);

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void powerSet(int idx, int sum) {
		if (sum == K) { // 합이 K가 됬을 경우
			answer++;
			return;
		}

		if (idx == N) // 배열 끝까지 도달했을 경우
			return;

		if (sum + arr[idx] <= K) // 더했을 경우에 K에 도달할 가능성이 있을 경우
			powerSet(idx + 1, sum + arr[idx]); // idx 번째 수 선택

		powerSet(idx + 1, sum); // idx번째 수 선택 하지 않을 경우
	}
}