import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 동 서 남 북 상 하
	static int[] dLevel = {0,0,0,0};
	static int[] dRow = {};
	static int[] dCol = {};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); // 층수
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열

		char[][][] map = new char[L][R][C];

		String tmp = "";
		Node start = null;
		Node escape = null;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < R; j++) {
				tmp = br.readLine();
				for (int k = 0; k < C; k++) {
					map[i][j][k] = tmp.charAt(k);

					if (map[i][j][k] == 'S')
						start = new Node(i, j, k);
					else if (map[i][j][k] == 'E')
						escape = new Node(i, j, k);
				}
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);

		Node now = null;
		int nLevel = 0;
		int nRow = 0;
		int nCol = 0;
		while (!q.isEmpty()) {
			now = q.poll();

		}
	}

	static class Node {
		int level;
		int row;
		int col;

		public Node(int level, int row, int col) {
			this.level = level;
			this.row = row;
			this.col = col;
		}
	}
}