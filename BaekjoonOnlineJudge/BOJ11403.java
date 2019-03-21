import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ11403.java
 * @date 2019. 3. 21.
 * @author Park JunYoung
 * @description 경로 찾기, DFS
 * 
 */

public class BOJ11403 {
	static int N;
	static int[][] arr;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && result[i][j] == 0) {
					result[i][j] = 1;
					dfs(i, j);
				}
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer.append(result[i][j] + " ");
			}
			answer.append("\n");
		}

		System.out.println(answer);
	}

	static void dfs(int std, int row) {
		for (int i = 0; i < N; i++) {
			if (arr[row][i] == 1 && result[std][i] == 0) {
				result[std][i] = 1;
				dfs(std, i);
			}
		}
	}
}