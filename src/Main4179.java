import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4179 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		boolean[][] visitJ = new boolean[R][C];
		boolean[][] visitF = new boolean[R][C];

		Coordi jihoon = null; // 지훈이 좌표
		ArrayList<Coordi> fire = new ArrayList<>();

		String tmp = "";
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'J')
					jihoon = new Coordi(i, j, 1, true);
				else if (map[i][j] == 'F')
					fire.add(new Coordi(i, j, 0, false));
			}
		}

		Queue<Coordi> q = new LinkedList<>();
		q.offer(jihoon);
		for (Coordi c : fire)
			q.offer(c);

		int escape = -1;
		Coordi now;
		while (!q.isEmpty()) {
			now = q.poll();

			// 방문 확인
			if (now.isJihoon) {
				if (visitJ[now.row][now.col])
					continue;
				else {
					visitJ[now.row][now.col] = true;
				}
			} else {
				if (visitF[now.row][now.col])
					continue;
				else {
					visitF[now.row][now.col] = true;
				}
			}

			// 탈출
			if (now.isJihoon && (now.row == 0 || now.row == R - 1 || now.col == 0 || now.col == C - 1)) {
				escape = now.time;
				break;
			}

			int nRow = 0;
			int nCol = 0;

			for (int i = 0; i < 4; i++) {
				nRow = now.row + dRow[i];
				nCol = now.col + dCol[i];

				if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C && map[nRow][nCol] != '#') {
					if (now.isJihoon) { // 지훈일 경우
						if (map[nRow][nCol] != 'F' && !visitJ[nRow][nCol])
							q.offer(new Coordi(nRow, nCol, now.time + 1, now.isJihoon));
					} else { // 불일 경우
						if (!visitF[nRow][nCol])
							q.offer(new Coordi(nRow, nCol, now.time + 1, now.isJihoon));
					}
				}
			}
		}

		if (escape == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(escape);
	}

	static class Coordi {
		int row;
		int col;
		int time;
		boolean isJihoon;

		public Coordi(int row, int col, int time, boolean isJihoon) {
			this.row = row;
			this.col = col;
			this.time = time;
			this.isJihoon = isJihoon;
		}
	}
}