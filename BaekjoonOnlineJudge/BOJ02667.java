import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02667.java
 * @date 2019. 3. 15.
 * @author Park JunYoung
 * @description 단지번호붙이기, DFS
 * 
 */

public class BOJ02667 {
	static int cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		map = new int[n + 2][n + 2];
		visit = new boolean[n + 2][n + 2];

		String line = "";
		for (int i = 1; i <= n; i++) {
			line = br.readLine();
			for (int j = 1; j <= n; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}

		ArrayList<Integer> house = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					cnt = 0;
					dfs(i, j);
					house.add(cnt);
				}
			}
		}

		Collections.sort(house);

		StringBuffer answer = new StringBuffer(house.size() + "\n");
		for (int i = 0; i < house.size(); i++)
			answer.append(house.get(i) + "\n");

		System.out.println(answer.toString());
	}

	static void dfs(int row, int col) {
		visit[row][col] = true;
		cnt++;

		int nextRow = 0;
		int nextCol = 0;
		for (int i = 0; i < 4; i++) {
			nextRow = row + dRow[i];
			nextCol = col + dCol[i];

			if (!visit[nextRow][nextCol] && map[nextRow][nextCol] == 1)
				dfs(nextRow, nextCol);
		}
	}
}
