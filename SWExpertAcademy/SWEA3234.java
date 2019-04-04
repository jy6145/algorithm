import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3234.java
 * @date 2019. 4. 4.
 * @author Park JunYoung
 * @description 준환이의 양팔저울, 순열, DFS
 * 
 */

public class SWEA3234 {
	static boolean[] flag;
	static int N;
	static int[] weights;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				weights[i] = Integer.parseInt(st.nextToken());

			answer = 0;
			perm(0);

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void perm(int pivot) {
		if (pivot == N) {
			dfs(0, 0, 0);
		}

		for (int i = pivot; i < N; i++) {
			swap(pivot, i);
			perm(pivot + 1);
			swap(pivot, i);
		}
	}

	static void swap(int a, int b) {
		int tmp = weights[a];
		weights[a] = weights[b];
		weights[b] = tmp;
	}

	static void dfs(int pivot, int left, int right) {
		if (left < right)
			return;

		if (pivot == N) {
			answer++;
			return;
		}

		// 왼쪽으로 선택 할 경우
		dfs(pivot + 1, left + weights[pivot], right);
		// 오른쪽으로 선택할 경우
		dfs(pivot + 1, left, right + weights[pivot]);
	}
}
