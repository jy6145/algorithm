import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dRow = { 1, 1, -1, -1 };
	static int[] dCol = { 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			Queue<Node> q = new LinkedList<Node>();
			Node now = null;
			Node next = null;
			int nRow = 0;
			int nCol = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					q.offer(new Node(i, j, i, j, 0, 1));
					while (!q.isEmpty()) {
						now = q.poll();

						if (now.row == now.stRow && now.col == now.stCol && now.cnt != 1) {
							// 돌아왔을 경우
							if (max < now.cnt - 1)
								max = now.cnt - 1;
						}

						if (now.cafe.contains(map[now.row][now.col]))
							continue;
						now.cafe.add(map[now.row][now.col]);

						for (int k = 0; k < 2; k++) {
							if (now.cnt == 1 && k == 1) // 출발지점은 첫방향만 사용
								break;

							if (now.dir + k == 4) // 마지막 방향만 남을 경우 처리
								break;

							nRow = now.row + dRow[now.dir + k];
							nCol = now.col + dCol[now.dir + k];
							if (0 <= nRow && nRow < n && 0 <= nCol && nCol < n && (!now.cafe.contains(map[nRow][nCol])
									|| (nRow == now.stRow && nCol == now.stCol))) {
								next = new Node(now.stRow, now.stCol, nRow, nCol, now.dir + k, now.cnt + 1);
								next.cafe.addAll(now.cafe);

								q.offer(next);
							}
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + max);
		} // tc
	}

	static class Node {
		int stRow;
		int stCol;
		int row;
		int col;
		int dir; // 이동해야할 4방향
		int cnt;
		ArrayList<Integer> cafe; // 방문한 카페

		public Node(int stRow, int stCol, int row, int col, int dir, int cnt) {
			this.stRow = stRow;
			this.stCol = stCol;
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.cnt = cnt;

			cafe = new ArrayList<>();
		}
	}
}