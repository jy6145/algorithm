import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ14499.java
 * @date 2019. 3. 25.
 * @author Park JunYoung
 * @description 주사위 굴리기
 *
 */

public class BOJ14499 {
	static int[] dice;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cmd = 0;
		dice = new int[6]; // 앞 뒤 좌 우 상 하
		int tmp = 0;
		boolean flag = false; // 갈수 있는지 확인(true면 가능)
		StringBuilder answer = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			cmd = Integer.parseInt(st.nextToken());

			flag = false;
			//		 앞 뒤 좌 우 상 하
			//그대로 0  1  2  3  4  5
			//동	 0  1  5  4  2  3
			//서	 0  1  4  5  3  2
			//북	 5  4  2  3  0  1
			//남	 4  5  2  3  1  0
			switch (cmd) {
			case 1: // 동
				if (y + 1 < M) {
					y++;
					flag = true;

					tmp = dice[2];
					dice[2] = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[4];
					dice[4] = tmp;
				}
				break;
			case 2: // 서
				if (y - 1 >= 0) {
					y--;
					flag = true;

					tmp = dice[2];
					dice[2] = dice[4];
					dice[4] = dice[3];
					dice[3] = dice[5];
					dice[5] = tmp;
				}
				break;
			case 3: // 북
				if (x - 1 >= 0) {
					x--;
					flag = true;

					tmp = dice[0];
					dice[0] = dice[5];
					dice[5] = dice[1];
					dice[1] = dice[4];
					dice[4] = tmp;
				}
				break;
			case 4: // 남
				if (x + 1 < N) {
					x++;
					flag = true;

					tmp = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[1];
					dice[1] = dice[5];
					dice[5] = tmp;
				}
				break;
			}// switch

			if (flag) {
				if (map[x][y] == 0) { // 칸이 0일 경우 : 주사위 바닥이 맵으로
					map[x][y] = dice[5];
				} else { // 칸이 0이 아닐 경우 : 주사위 바닥이 맵으로, 맵은 0으로
					dice[5] = map[x][y];
					map[x][y] = 0;
				}

				answer.append(dice[4] + "\n");
			}
		} // for

		System.out.println(answer.toString());
	}// main
}