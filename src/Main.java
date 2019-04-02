import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		Info[][] map = new Info[R][C];
		Node[] c = new Node[2];
		int cIdx = 0;

		String tmp = "";
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = new Info(tmp.charAt(j), 10000);

				if (map[i][j].data == 'C')
					c[cIdx++] = new Node(i, j, 0, 0);
			}
		}
		map[c[0].row][c[0].col].mirror = 0;

		Queue<Node> q = new LinkedList<Node>();
		int nRow, nCol;
		for (int i = 0; i < 4; i++) {
			nRow = c[0].row + dRow[i];
			nCol = c[0].col + dCol[i];

			if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C && map[nRow][nCol].data != '*') {
				map[nRow][nCol].mirror = 0;
				q.offer(new Node(nRow, nCol, i, 0));
			}
		}

		Node now;
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.row][now.col].mirror < now.mirror)
				continue;
			else
				map[now.row][now.col].mirror = now.mirror;

			if (now.row == c[1].row && now.col == c[1].col) {
				answer = Math.min(answer, now.mirror);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				nRow = now.row + dRow[i];
				nCol = now.col + dCol[i];

				if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C && map[nRow][nCol].data != '*'
						&& map[nRow][nCol].mirror >= now.mirror) {
					if (now.dir == i)
						q.offer(new Node(nRow, nCol, i, now.mirror));
					else
						q.offer(new Node(nRow, nCol, i, now.mirror + 1));
				}
			}
		}

		System.out.println(answer);
	}

	static class Info {
		char data;
		int mirror; // 여기까지 오기까지 거울 개수

		public Info(char data, int mirror) {
			this.data = data;
			this.mirror = mirror;
		}
	}

	static class Node {
		int row;
		int col;
		int dir;
		int mirror;

		public Node(int row, int col, int dir, int mirror) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.mirror = mirror;
		}
	}
}