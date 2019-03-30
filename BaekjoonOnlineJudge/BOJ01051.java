import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01051.java
 * @date 2019. 3. 31.
 * @author Park JunYoung
 * @description 숫자 정사각형, 브루트 포스
 *
 */

public class BOJ01051 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		String tmp = "";
		int now = 0;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				now = tmp.charAt(j) - '0';
				map[i][j] = now;
			}
		}

		int r1, r2, c1, c2;
		int area = 0;
		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; k < Math.min(N, M); k++) {
					r1 = i;
					c1 = j;
					r2 = i + k;
					c2 = j + k;
					if (r2 < 0 || r2 >= N || c2 < 0 || c2 >= M)
						break;

					// 4개의 모서리가 모두 같으면
					if (map[r1][c2] == map[r1][c1] && map[r2][c1] == map[r1][c1] && map[r2][c2] == map[r1][c1]) {
						area = (r2 - r1 + 1) * (c2 - c1 + 1);
						if (max < area)
							max = area;
					}
				}
			}
		}

		System.out.println(max);
	}
}