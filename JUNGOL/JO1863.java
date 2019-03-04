import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName JO1863.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 종교, union
 * 
 */

public class JO1863 {
	static int[] parents;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1]; // 학생들의 종교 저장

		int a = 0;
		int b = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (i == parents[i] || parents[i] == 0)
				answer++;
		}

		System.out.println(answer);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			parents[rootB] = rootA;
		}
	}

	static int find(int x) {
		if (parents[x] == 0 || parents[x] == x) {
			parents[x] = x;
			return x;
		}

		return parents[x] = find(parents[x]);
	}
}