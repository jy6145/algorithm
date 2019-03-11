import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1767.java
 * @date 2019. 3. 11.
 * @author Park JunYoung
 * @description [SW Test 샘플문제] 프로세서 연결하기, DFS, 재귀 시 방문값 같이 넘기기!
 *
 */

public class SWEA1767 {
	static class Coordi {
		int row;
		int col;

		public Coordi(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int n;
	static ArrayList<Coordi> core;
	static int maxCore;
	static int minLine;

	static void dfs(int[][] map, int idx, int coreCnt, int lineLength, int lastIdx) {
		if (maxCore < coreCnt) {
			maxCore = coreCnt;
			minLine = lineLength;
		} else if (maxCore == coreCnt && minLine > lineLength) {
			minLine = lineLength;
		}

		if (idx == lastIdx || maxCore > coreCnt + (lastIdx - idx)) {
			return;
		}

		Coordi c = core.get(idx);

		boolean flag = false;
		int[][] copy = new int[n][n];

		// 전선을 위로 연결
		flag = false;
		for (int i = 0; i < c.row; i++) {
			if (map[i][c.col] != 0) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			mapCopy(map, copy);
			for (int i = 0; i < c.row; i++)
				copy[i][c.col] = -1;
			dfs(copy, idx + 1, coreCnt + 1, lineLength + c.row, lastIdx);
		}

		// 전선을 아래로 연결
		flag = false;
		for (int i = c.row + 1; i < n; i++) {
			if (map[i][c.col] != 0) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			mapCopy(map, copy);
			for (int i = c.row + 1; i < n; i++)
				copy[i][c.col] = -1;
			dfs(copy, idx + 1, coreCnt + 1, lineLength + (n - c.row - 1), lastIdx);
		}

		// 전선을 왼쪽으로 연결
		flag = false;
		for (int i = 0; i < c.col; i++) {
			if (map[c.row][i] != 0) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			mapCopy(map, copy);
			for (int i = 0; i < c.col; i++)
				copy[c.row][i] = -1;
			dfs(copy, idx + 1, coreCnt + 1, lineLength + c.col, lastIdx);
		}

		// 전선을 오른쪽으로 연결
		flag = false;
		for (int i = c.col + 1; i < n; i++) {
			if (map[c.row][i] != 0) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			mapCopy(map, copy);
			for (int i = c.col + 1; i < n; i++)
				copy[c.row][i] = -1;
			dfs(copy, idx + 1, coreCnt + 1, lineLength + (n - c.col - 1), lastIdx);
		}

		// 전선을 연결하지 않을 경우
		dfs(map, idx + 1, coreCnt, lineLength, lastIdx);

	}

	static void mapCopy(int[][] map, int[][] copy) {
		for (int i = 0; i < n; i++)
			System.arraycopy(map[i], 0, copy[i], 0, n);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			core = new ArrayList<Coordi>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					// 모서리를 제외한 코어 추가
					if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1)
						core.add(new Coordi(i, j));
				}
			}

			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			dfs(map, 0, 0, 0, core.size());
			System.out.println("#" + testCase + " " + minLine);
		}
	}
}