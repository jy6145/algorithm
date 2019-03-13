import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7208.java
 * @date 2019. 3. 13.
 * @author Park Junyoung
 * @description 지도 칠하기, DFS
 * 
 */

public class SWEA7208 {
	static int[][] graph;
	static int min;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[] color = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				color[i] = Integer.parseInt(st.nextToken());

			graph = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++)
				dfs(color, i, 0, 0);
			System.out.println("#" + testCase + " " + min);
		}
	}

	static void dfs(int[] color, int pivot, int chg, int cnt) {
		pivot %= color.length;

		if (chg > min)
			return;

		if (cnt == color.length) {
			if (min > chg)
				min = chg;

			return;
		}

		boolean[] chk = new boolean[4 + 1]; // 불가능한 색깔은 true

		for (int i = 0; i < color.length; i++) {
			if (i == pivot) // 자기 자신과 비교는 제외
				continue;
			if (graph[pivot][i] == 1 && color[pivot] == color[i])
				chk[color[i]] = true;
		}

		int[] tmp = new int[color.length];
		for (int i = 1; i <= 4; i++) {
			if (!chk[i]) { // 색을 선택할수 있는 것 중에서
				if (i == color[pivot]) // 현재 색을 그대로 유지 가능할 경우
					dfs(color, pivot + 1, chg, cnt + 1);
				else { // pivot의 색을 변경할 경우
					System.arraycopy(color, 0, tmp, 0, color.length);
					tmp[pivot] = i;
					dfs(tmp, pivot + 1, chg + 1, cnt + 1);
				}
			}
		}
	}
}