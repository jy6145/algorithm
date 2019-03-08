import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14501.java
 * @date 2019. 3. 8.
 * @author Park JunYoung
 * @description 퇴사, DFS
 *
 */

public class BOJ14501 {
	static Work[] list;
	static int n;
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new Work[n];

		int t = 0;
		int p = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			list[i] = new Work(t, p);
		}

		max = 0;
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int pivot, int price) {
		if (pivot == n) {
			if (max < price)
				max = price;
			return;
		}

		// 일을 선택했을 경우
		if (pivot + list[pivot].time <= n) {
			dfs(pivot + list[pivot].time, price + list[pivot].price);
		}

		// 일을 선택하지 않았을 경우
		dfs(pivot + 1, price);
	}

	static class Work {
		int time;
		int price;

		public Work(int time, int price) {
			this.time = time;
			this.price = price;
		}
	}
}
