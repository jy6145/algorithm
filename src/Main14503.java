import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//7569
public class Main14503 {
	static int[] dRow = { 0, -1, 0, 1, 0, 0 };
	static int[] dCol = { -1, 0, 1, 0, 0, 0 };
	static int[] dHeight = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[N][M][H];
		boolean[][][] visit = new boolean[N][M][H];
		int tomatoCnt = 0;
		int maxTomato = M * N * H;
		int maxDay = 0;

		Queue<Node> q = new LinkedList<Node>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[j][k][i] = Integer.parseInt(st.nextToken());
					if (tomato[j][k][i] == 1) {
						q.offer(new Node(j, k, i, 0));
						tomatoCnt++;
					} else if (tomato[j][k][i] == -1)
						maxTomato--;
				}
			}
		}

		Node now;
		while (!q.isEmpty()) {
			now = q.poll();

			if (visit[now.row][now.col][now.height])
				continue;
			visit[now.row][now.col][now.height] = true;
			tomato[now.row][now.col][now.height] = 1;
			tomatoCnt++;

			if (now.day > maxDay)
				maxDay = now.day;

			int nRow = 0;
			int nCol = 0;
			int nHeight = 0;
			for (int i = 0; i < 6; i++) {
				nRow = now.row + dRow[i];
				nCol = now.col + dCol[i];
				nHeight = now.height + dHeight[i];

				if (0 <= nRow && nRow < N && 0 <= nCol && nCol < M && 0 <= nHeight && nHeight < H
						&& tomato[nRow][nCol][nHeight] == 0 && !visit[nRow][nCol][nHeight]) {
					q.offer(new Node(nRow, nCol, nHeight, now.day + 1));
				}
			}
		}

		System.out.println(maxTomato + " " + tomatoCnt);
		int answer = 0;
		if (maxTomato != tomatoCnt)
			answer = -1;
		else
			answer = maxDay;

		System.out.println(answer);
	}

	static class Node {
		int row;
		int col;
		int height;
		int day;

		public Node(int row, int col, int height, int day) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.day = day;
		}
	}
}