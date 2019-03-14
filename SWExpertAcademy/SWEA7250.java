import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7250.java
 * @date 2019. 3. 14.
 * @author Park JunYoung
 * @description 탈출, 시뮬레이션, BFS
 * 
 */

public class SWEA7250 {
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[][] map = new char[N][M];
			boolean[][] visitS = new boolean[N][M];
			boolean[][] visitV = new boolean[N][M];
			boolean[][] visitF = new boolean[N][M];

			Queue<Node> q = new LinkedList<Node>();

			int scott = 0;
			int villain = 0;
			Node startS = null; // 출발 지점
			Node startV = null;

			String line = "";
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'S')
						startS = new Node(i, j, K, 0, 'S');
					else if (map[i][j] == 'V') {
						startV = new Node(i, j, 0, 0, 'V');
					} else if (map[i][j] == 'F') {
						q.offer(new Node(i, j, 0, 0, 'F'));
					}
				}
			}

			if (startV != null)
				q.offer(startV);

			q.offer(startS);

			Node now = null;
			while (!q.isEmpty()) {
				now = q.poll();

				if (now.what == 'S') {
					if (visitS[now.row][now.col])
						continue;

					if (map[now.row][now.col] == 'A') // W 벽의 경우 충전후 다시 이동할 경우가 발생
						visitS[now.row][now.col] = true;

					if (map[now.row][now.col] == 'E') {
						scott = now.time;
						break;
					}

					int nextRow = 0;
					int nextCol = 0;
					for (int i = 0; i < 4; i++) {
						nextRow = now.row + dRow[i];
						nextCol = now.col + dCol[i];

						if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M && !visitS[nextRow][nextCol]) {
							if (map[nextRow][nextCol] == 'A' || map[nextRow][nextCol] == 'E'
									|| map[nextRow][nextCol] == 'V') // 길
								q.offer(new Node(nextRow, nextCol, K, now.time + 1, now.what)); // K충전
							else if (map[nextRow][nextCol] == 'W' && now.k > 0) // 벽(W)
								q.offer(new Node(nextRow, nextCol, now.k - 1, now.time + 1, now.what));
						}
					}
				} else if (now.what == 'V') {
					if (visitV[now.row][now.col])
						continue;

					visitV[now.row][now.col] = true;

					if (map[now.row][now.col] == 'E') {
						villain = now.time;
						break;
					}

					int nextRow = 0;
					int nextCol = 0;
					for (int i = 0; i < 4; i++) {
						nextRow = now.row + dRow[i];
						nextCol = now.col + dCol[i];

						if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N && !visitV[nextRow][nextCol]) {
							if (map[nextRow][nextCol] == 'A' || map[nextRow][nextCol] == 'F'
									|| map[nextRow][nextCol] == 'E' || map[nextRow][nextCol] == 'S') // 길이나 불
								q.offer(new Node(nextRow, nextCol, 0, now.time + 1, now.what)); // K 불필요
						}
					}
				} else if (now.what == 'F') {
					if (visitF[now.row][now.col])
						continue;

					visitF[now.row][now.col] = true;
					map[now.row][now.col] = 'F';

					if (map[now.row][now.col] == 'E') {
						// ?? 도착지점에 불이 붙나요?
					}

					int nextRow = 0;
					int nextCol = 0;
					for (int i = 0; i < 4; i++) {
						nextRow = now.row + dRow[i];
						nextCol = now.col + dCol[i];

						if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N && !visitF[nextRow][nextCol]) {
							if (map[nextRow][nextCol] == 'A') // 길
								q.offer(new Node(nextRow, nextCol, 0, 0, now.what)); // K 불필요
						}
					}
				}
			}

			int answer = (scott == 0) ? -1 : scott;
			System.out.println("#" + testCase + " " + answer);
		}
	}

	private static void printMap(char[][] map) {
		System.out.println("==============================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Node {
		int row;
		int col;
		int k; // w벽을 이동할수 있는 거리
		int time; // 이동 시간
		char what; // 어떤 노드인지

		public Node(int row, int col, int k, int time, char what) {
			this.row = row;
			this.col = col;
			this.k = k;
			this.time = time;
			this.what = what;
		}
	}
}
