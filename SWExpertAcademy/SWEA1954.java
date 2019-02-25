
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1954.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 달팽이 숫자 	
 * 
 */

public class SWEA1954 {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());

			int[] dRow = { 0, 1, 0, -1 };
			int[] dCol = { 1, 0, -1, 0 };

			map = new int[n][n];

			int row = 0;
			int col = 0;
			int dir = 0;
			int num = 1;

			int nextRow = 0;
			int nextCol = 0;
			while (num <= n * n) {
				map[row][col] = num++;

				nextRow = row + dRow[dir];
				nextCol = col + dCol[dir];

				if (!chk(nextRow, nextCol, dir)) { // 방문했거나 유효하지 않은 배열이면 방향전환
					dir = (dir + 1) % 4;
					nextRow = row + dRow[dir];
					nextCol = col + dCol[dir];
				}

				row = nextRow;
				col = nextCol;
			}

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer.append(map[i][j] + " ");
				}
				if (i != n - 1) {
					answer.append("\n");
				}
			}

			System.out.println(answer.toString());
		}
	}

	static boolean chk(int row, int col, int dir) {
		if (row < 0 || row >= n || col < 0 || col >= n || map[row][col] != 0)
			return false;

		return true;
	}
}
