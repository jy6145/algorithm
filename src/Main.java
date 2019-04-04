import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = { -1, 0, 1, 0, 0 };
	static int[] dCol = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Node[][] map = new Node[R][C];

		String tmp = "";
		int now = 1;
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (tmp.charAt(j) == 'O')
					map[i][j] = new Node(true, 1);
				else
					map[i][j] = new Node(false, 0);
			}
		}

		// 아무것도 안함
		now++;

		boolean[][] tmpMap = new boolean[R][C];

		int nRow = 0;
		int nCol = 0;
		while (now <= N) {
			tmpMap = new boolean[R][C];

			// 설치
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j].bomb) {
						if (map[i][j].time == 0)
							map[i][j].time--;
						else {
							tmpMap[i][j] = true;
						}
					} else
						map[i][j] = new Node(true, 1);
				}
			}

			if (N <= now)
				break;

			// 폭파
			now++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (tmpMap[i][j]) {
						for (int k = 0; k < 5; k++) {
							nRow = i + dRow[k];
							nCol = j + dCol[k];

							if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C)
								map[nRow][nCol] = new Node(false, 0);
						}
					}
				}
			}
			now++;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].bomb)
					System.out.print("O");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

	static class Node {
		boolean bomb;
		int time;

		public Node(boolean bomb, int time) {
			this.bomb = bomb;
			this.time = time;
		}
	}
}
