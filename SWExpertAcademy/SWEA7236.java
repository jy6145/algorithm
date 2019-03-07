import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7236.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 저수지의 물의 총 깊이 구하기
 * 
 */

public class SWEA7236 {
	static int n;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());

			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			int max = 0;
			int now = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					now = 0;
					if (map[i][j] == 'W') {
						now = calcW(map, i, j);
						if (max < now)
							max = now;
					}
				}
			}

			System.out.println("#" + testCase + " " + max);
		}
	}

	private static int calcW(char[][] map, int x, int y) {
		int cnt = 0;
		int nextX = 0;
		int nextY = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				nextX = x + i;
				nextY = y + j;
				if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n && map[nextX][nextY] == 'W') {
					cnt++;
				}
			}
		}
		cnt--; // 가운데 값 빼야됨

		if (cnt == 0)
			return 1;

		return cnt;
	}
}