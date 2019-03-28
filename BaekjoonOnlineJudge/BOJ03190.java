import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName BOJ03190.java
 * @date 2019. 3. 28.
 * @author Park JunYoung
 * @description 뱀, 시뮬레이션
 * 
 */

public class BOJ03190 {
	static int[] dRow = { 0, 0, 1, -1 }; // 동,서,남,북
	static int[] dCol = { 1, -1, 0, 0 };
	static int[] nIdxR = { 2, 3, 1, 0 }; // 오른쪽 다음 인덱스
	static int[] nIdxL = { 3, 2, 0, 1 }; // 왼쪽 다음 인덱스

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1; // 사과
		}

		int l = Integer.parseInt(br.readLine());

		int dir = 0; // 0:동, 1:서, 2:남, 3:북

		List<Coordi> snake = new LinkedList<Coordi>();
		snake.add(new Coordi(0, 0));
		map[0][0] = 2;

		int time = 0;
		int sec = 0;
		char cmd = ' ';

		int nRow = 0;
		int nCol = 0;
		boolean flag = false; // 게임 종료되면 true

		Coordi front = null;
		Coordi rear = null;
		while (!flag) {
			if (l > 0) {
				st = new StringTokenizer(br.readLine());
				sec = Integer.parseInt(st.nextToken());
				cmd = st.nextToken().charAt(0);
				l--;
			} else
				sec = Integer.MAX_VALUE;

			for (int i = time; i < sec; i++) {
				front = snake.get(0);
				nRow = front.row + dRow[dir];
				nCol = front.col + dCol[dir];
				time++;

				// 부딪힐 경우
				if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= n || map[nRow][nCol] == 2) {
					flag = true;
					break;
				} else {
					snake.add(0, new Coordi(nRow, nCol));

					if (map[nRow][nCol] != 1) { // 사과가 아니면 꼬리 제거
						rear = snake.get(snake.size() - 1);
						map[rear.row][rear.col] = 0;
						snake.remove(rear);
					}

					map[nRow][nCol] = 2; // 전진
				}

			}

			if (cmd == 'D') // 오른쪽
				dir = nIdxR[dir];
			else if (cmd == 'L')
				dir = nIdxL[dir];
		}

		System.out.println(time);
	}

	static class Coordi {
		int row;
		int col;

		public Coordi(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
