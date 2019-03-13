import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5656.java
 * @date 2019. 3. 13.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 벽돌 깨기
 *
 */

public class SWEA5656 {
	static int n;
	static int w;
	static int h;
	static int min;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			dfs(map, 0, 0, n);
			System.out.println("#" + testCase + " " + min);
		}
	}

	static void dfs(int[][] map, int pivot, int cnt, int n) {
		if (cnt == n) { // 개수에 맞게 깼을 경우
			int blkCnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] != 0)
						blkCnt++;
				}
			}
			if (min > blkCnt)
				min = blkCnt;

			return;
		}
		if (pivot == w)
			return;

		int[][] mapCopy = new int[h][w];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++)
				System.arraycopy(map[j], 0, mapCopy[j], 0, map[j].length);

			distory(mapCopy, i);
			dfs(mapCopy, i, cnt + 1, n);
		}
	}

	static void distory(int[][] map, int pivot) {
		Queue<Node> q = new LinkedList<Node>();
		for (int i = 0; i < h; i++) {
			if (map[i][pivot] != 0) {
				q.offer(new Node(i, pivot, map[i][pivot]));
				break;
			}
		}

		// 좌우 폭발범위 인덱스
		int start = 0;
		int end = 0;
		Node now = null;
		while (!q.isEmpty()) {
			now = q.poll();

			// 좌우 제거
			start = (now.col - (now.value - 1)) < 0 ? 0 : now.col - (now.value - 1);
			end = (now.col + (now.value - 1)) >= w ? w - 1 : now.col + (now.value - 1);
			for (int i = start; i <= end; i++) {
				if (i == now.col) { // 현재 벽돌은 큐에 넣지 않음
					map[now.row][i] = 0;
					continue;
				}

				if (map[now.row][i] > 1)
					q.offer(new Node(now.row, i, map[now.row][i]));
				map[now.row][i] = 0;
			}

			// 상하 제거
			start = now.row - (now.value - 1) < 0 ? 0 : now.row - (now.value - 1);
			end = now.row + (now.value - 1) >= h ? h - 1 : now.row + (now.value - 1);
			for (int i = start; i <= end; i++) {
				if (i == now.row) { // 현재 벽돌은 큐에 넣지 않음
					map[i][now.col] = 0;
					continue;
				}

				if (map[i][now.col] > 1)
					q.offer(new Node(i, now.col, map[i][now.col]));
				map[i][now.col] = 0;
			}
		}
		// 벽돌 공간 제거
		int idx = 0;
		for (int j = 0; j < w; j++) {
			idx = h - 1;
			for (int i = h - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					map[idx][j] = map[i][j];
					idx--;
				}
			}

			// 내리고 위에 있는 숫자들 0으로 변경
			for (int i = 0; i <= idx; i++)
				map[i][j] = 0;
		}
	}

	private static void printMap(int[][] map) {
		System.out.println("======================================");
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Node {
		int row;
		int col;
		int value;

		public Node(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
}
