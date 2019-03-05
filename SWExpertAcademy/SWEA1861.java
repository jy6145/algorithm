import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1861.java
 * @date 2019. 3. 5.
 * @author Park JunYoung
 * @description 정사각형 방, DFS
 * 
 */

public class SWEA1861 {
	static int answer;
	static int answerIdx;
	static boolean[][] visit;
	static int[][] room;
	static int n;
	static int flag;

	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());

			room = new int[n][n];
			visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 1;
			answerIdx = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (n * n - room[i][j] + 1 >= answer) {
						flag = 0; // flag=true일 경우 이동 개수가 더 크거나 같은거
						visit[i][j] = true;
						dfs(i, j, 1);
						visit[i][j] = false;

						if (flag == 1 && answerIdx > room[i][j]) { // 길이가 같을 경우
							answerIdx = room[i][j];
						} else if (flag == 2) { // 길이가 길어질 경우
							answerIdx = room[i][j];
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + answerIdx + " " + answer);
		}
	}

	static void dfs(int row, int col, int cnt) {
		if (cnt == answer) {
			flag = 1;
		} else if (cnt > answer) {
			flag = 2;
			answer = cnt;
		}

		int nextRow = 0;
		int nextCol = 0;
		for (int i = 0; i < 4; i++) {
			nextRow = row + dRow[i];
			nextCol = col + dCol[i];

			if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && !visit[nextRow][nextCol]
					&& room[row][col] + 1 == room[nextRow][nextCol]) {
				visit[nextRow][nextCol] = true;
				dfs(nextRow, nextCol, cnt + 1);
				visit[nextRow][nextCol] = false;
			}
		}
	}
}