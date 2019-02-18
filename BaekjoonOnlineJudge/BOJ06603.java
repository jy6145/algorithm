import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ06603.java
 * @date 2019. 2. 18.
 * @author Park JunYoung
 * @description 로또, DFS
 * 
 */

public class BOJ06603 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			if (n == 0)
				return;
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] result = new int[6];
			dfs(arr, result, 0, 0, n);
			System.out.println();
		}
	}

	static void dfs(int[] arr, int[] result, int idx, int pivot, int length) {
		if (idx == 6) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		if (pivot == length) {
			return;
		}

		result[idx] = arr[pivot];
		dfs(arr, result, idx + 1, pivot + 1, length);
		dfs(arr, result, idx, pivot + 1, length);
	}
}
