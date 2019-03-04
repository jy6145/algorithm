import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1486.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 장훈이의 높은 선반
 *
 */

public class SWEA1486 {
	static int N;
	static int B;
	static int[] clerk; // 점원의 키
	static int min; // 탑과 B의 최소 차이

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			clerk = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				clerk[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			func(0, 0);
			System.out.println("#" + testCase + " " + min);
		}
	}

	static void func(int select, int sum) {
		if (sum >= B) {
			if (min > sum - B) {
				min = sum - B;
			}

			return;
		}

		if (select == N) {
			return;
		}

		// 선택할 경우
		func(select + 1, sum + clerk[select]);

		// 선택하지 않을 경우
		func(select + 1, sum);
	}
}