import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1824.java
 * @date 2019. 3. 20.
 * @author Park JunYoung
 * @description 혁진이의 프로그램 검증, DFS
 * 
 */

public class SWEA1824 {
	static char[][] map;
	static int[][] visit;
	static int R, C;
	static String answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			boolean flag = false;
			String tmp = "";
			for (int i = 0; i < R; i++) {
				tmp = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '@')
						flag = true;
				}
			}
			if (!flag) { // @가 없으면
				System.out.println("#" + testCase + " NO");
				continue;
			}

			int row = 0;
			int col = 0;
			int memory = 0;
			char dir = '>';

			answer = "NO";
			visit = new int[R][C];

			dfs(row, col, dir, memory);
			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void dfs(int row, int col, char dir, int memory) {
		char now = map[row][col];

		if (visit[row][col] > 16) {
			// 실패
			return;
		}
		visit[row][col]++;

		// 현재 코드 처리
		if (now == '<') {
			dir = '<';
		} else if (now == '>')
			dir = '>';
		else if (now == '^')
			dir = '^';
		else if (now == 'v')
			dir = 'v';
		else if (now == '_') {
			if (memory == 0)
				dir = '>';
			else
				dir = '<';
		} else if (now == '|') {
			if (memory == 0)
				dir = 'v';
			else
				dir = '^';
		} else if (now == '?') {
			if (col - 1 >= 0)
				dfs(row, col - 1, '<', memory);
			else
				dfs(row, C - 1, '<', memory);

			if (col + 1 < C)
				dfs(row, col + 1, '>', memory);
			else
				dfs(row, 0, '>', memory);

			if (row - 1 >= 0)
				dfs(row - 1, col, '^', memory);
			else
				dfs(R - 1, col, '^', memory);

			if (row + 1 < R)
				dfs(row + 1, col, 'v', memory);
			else
				dfs(0, col, 'v', memory);

			return;
		} else if (now == '.') {
			// nothing
		} else if (now == '@') {
			answer = "YES";
			return;
		} else if (now == '+') {
			memory++;
			if (memory > 15)
				memory = 0;
		} else if (now == '-') {
			memory--;
			if (memory < 0)
				memory = 15;
		} else { // 숫자
			memory = now - '0';
		}

		// 다음 코드로 이동
		if (dir == '<') {
			if (col - 1 >= 0)
				dfs(row, col - 1, dir, memory);
			else
				dfs(row, C - 1, dir, memory);
		} else if (dir == '>') {
			if (col + 1 < C)
				dfs(row, col + 1, dir, memory);
			else
				dfs(row, 0, dir, memory);
		} else if (dir == '^') {
			if (row - 1 >= 0)
				dfs(row - 1, col, dir, memory);
			else
				dfs(R - 1, col, dir, memory);
		} else if (dir == 'v') {
			if (row + 1 < R)
				dfs(row + 1, col, dir, memory);
			else
				dfs(0, col, dir, memory);
		}
	}
}