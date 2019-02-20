
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6057.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 그래프의 삼각형, 그래프, 삼중for문
 *
 */

public class SWEA6057 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			boolean[][] graph = new boolean[n + 1][n + 1];

			int x = 0;
			int y = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				graph[x][y] = true;
				graph[y][x] = true;
			}

			int answer = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					for (int k = j + 1; k <= n; k++) {
						if (graph[i][j] && graph[j][k] && graph[k][i])
							answer++;
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}

	}

}
