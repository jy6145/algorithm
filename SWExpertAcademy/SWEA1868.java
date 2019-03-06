import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName SWEA1868.java
 * @date 2019. 3. 6.
 * @author Park JunYoung
 * @description 파핑파핑 지뢰찾기, BFS
 * 
 */

public class SWEA1868 {
	static int[] dRow = { -1, -1, -1, 0, 0, +1, +1, +1 };
	static int[] dCol = { -1, 0, +1, -1, +1, -1, 0, +1 };
	static int n;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());

			char[][] table = new char[n][n];
			boolean[][] visit = new boolean[n][n];

			String tmp;
			for (int i = 0; i < n; i++) {
				tmp = br.readLine();
				for (int j = 0; j < n; j++) {
					table[i][j] = tmp.charAt(j);
				}
			}

			Queue<Node> q;
			Node now;
			int answer = 0;
			int nextRow = 0;
			int nextCol = 0;
			int mine = 0;
			int priority = 0;
			while (priority <= 8) { // 0부터 우선순위를 높게 두어 8까지 순차적으로 클릭
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (table[i][j] != '.')
							continue;

						mine = getMine(table, i, j);
						if (mine != priority)
							continue;

						table[i][j] = (char) ('0' + mine);
						answer++; // 클릭했을 경우

						q = new LinkedList<Node>();
						q.offer(new Node(i, j));
						while (!q.isEmpty()) {
							now = q.poll();
							if (visit[now.row][now.col])
								continue;
							visit[now.row][now.col] = true;

							mine = getMine(table, now.row, now.col);

							table[now.row][now.col] = (char) ('0' + mine);

							if (mine == 0) { // 행당 지역이 0이라면 지뢰아닌 8방향 모두 큐에 넣음
								for (int k = 0; k < 8; k++) {
									nextRow = now.row + dRow[k];
									nextCol = now.col + dCol[k];
									if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n
											&& table[nextRow][nextCol] != '*')
										q.offer(new Node(nextRow, nextCol));
								}
							}
						}
					}
				}
				priority++;
			}
			System.out.println("#" + testCase + " " + answer);
		}
	}

	static int getMine(char[][] table, int row, int col) {
		int nextRow = 0;
		int nextCol = 0;
		int mine = 0;
		for (int k = 0; k < 8; k++) { // 8방향 검사
			nextRow = row + dRow[k];
			nextCol = col + dCol[k];

			if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && table[nextRow][nextCol] == '*')
				mine++;
		}
		return mine;
	}

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}