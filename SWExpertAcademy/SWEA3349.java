import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3349.java
 * @date 2019. 3. 5.
 * @author Park JunYoung
 * @description 최솟값으로 이동하기
 * 
 */

public class SWEA3349 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			// 출발 지점
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int nextX = 0;
			int nextY = 0;

			int cnt = 0;

			int tmp1 = 0;
			int tmp2 = 0;
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				nextX = Integer.parseInt(st.nextToken());
				nextY = Integer.parseInt(st.nextToken());

				if ((x < nextX && y < nextY) || (x >= nextX && y >= nextY)) {
					tmp1 = Math.abs(x - nextX);
					tmp2 = Math.abs(y - nextY);
					cnt += tmp1 + tmp2 - Math.min(tmp1, tmp2);
				} else { // 대각선 사용X
					cnt += Math.abs(x - nextX) + Math.abs(y - nextY);
				}

				x = nextX;
				y = nextY;
			}

			System.out.println("#" + testCase + " " + cnt);
		}
	}
}