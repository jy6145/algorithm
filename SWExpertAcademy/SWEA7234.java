import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7234.java
 * @date 2019. 3. 6.
 * @author Park JunYoung
 * @description 안전 기지
 * 
 */

public class SWEA7234 {
	static int[] dRow = { -2, -1, 0, 1, 2, 0, 0, 0, 0 };
	static int[] dCol = { 0, 0, 0, 0, 0, -2, -1, 1, 2 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];

			int row = 0;
			int col = 0;
			int nextRow = 0;
			int nextCol = 0;
			for (int i = 0; i < b; i++) {
				st = new StringTokenizer(br.readLine());
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());

				for (int j = 0; j < 9; j++) {
					nextRow = row + dRow[j];
					nextCol = col + dCol[j];

					if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n)
						map[nextRow][nextCol]++;
				}
			}

			int answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (answer < map[i][j])
						answer = map[i][j];
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}