import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName BOJ11404.java
 * @date 2019. 3. 26.
 * @author Park JunYoung
 * @description 플로이드
 * 
 */

public class BOJ11404 {
	static final int INF = 100000 * 100;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] city = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(city[i], INF);
			city[i][i] = 0;
		}

		int from;
		int to;
		int weight;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			if (city[from][to] > weight)
				city[from][to] = weight;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
				}
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (city[i][j] == INF)
					answer.append("0 ");
				else
					answer.append(city[i][j] + " ");
			}
			answer.append("\n");
		}

		System.out.println(answer.toString());
	}// main
}