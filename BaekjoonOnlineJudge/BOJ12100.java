import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ12100.java
 * @date 2019. 4. 2.
 * @author Park JunYoung
 * @description 2048 (Easy), DFS
 * 
 */

public class BOJ12100 {
	static int n;
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		dfs(map, 0);
		System.out.println(max);

	}

	static void dfs(int[][] map, int select) {
		if (select == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return;
		}

		int[][] copyMap = new int[n][n];
		for (int i = 1; i <= 4; i++) {
			copyMap = new int[n][n];
			for (int j = 0; j < n; j++)
				System.arraycopy(map[j], 0, copyMap[j], 0, n);

			move(copyMap, i);
			dfs(copyMap, select + 1);
		}
	}

	static void move(int[][] map, int dir) {

		int idx = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean flag = false;

		if (dir == 1) { // up
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[j][i] != 0) {
						q.offer(map[j][i]);
					}
				}

				flag = false; // true면 이전에 과정에서 숫자를 합침
				idx = 0;
				while (!q.isEmpty()) {
					if (idx - 1 >= 0 && map[idx - 1][i] == q.peek() && !flag) {
						map[idx - 1][i] += q.poll();
						flag = true;
					} else {
						map[idx++][i] = q.poll();
						flag = false;
					}
				}

				// 나머지 부분 0으로 채우기
				for (int j = idx; j < n; j++)
					map[j][i] = 0;
			}
		} else if (dir == 2) { // down
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						q.offer(map[j][i]);
					}
				}

				flag = false; // true면 이전에 과정에서 숫자를 합침
				idx = n - 1;
				while (!q.isEmpty()) {
					if (idx + 1 < n && map[idx + 1][i] == q.peek() && !flag) {
						map[idx + 1][i] += q.poll();
						flag = true;
					} else {
						map[idx--][i] = q.poll();
						flag = false;
					}
				}

				// 나머지 부분 0으로 채우기
				for (int j = idx; j >= 0; j--)
					map[j][i] = 0;
			}
		} else if (dir == 3) { // 왼쪽
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						q.offer(map[i][j]);
					}
				}

				flag = false; // true면 이전에 과정에서 숫자를 합침
				idx = 0;
				while (!q.isEmpty()) {
					if (idx - 1 >= 0 && map[i][idx - 1] == q.peek() && !flag) {
						map[i][idx - 1] += q.poll();
						flag = true;
					} else {
						map[i][idx++] = q.poll();
						flag = false;
					}
				}

				// 나머지 부분 0으로 채우기
				for (int j = idx; j < n; j++)
					map[i][j] = 0;
			}
		} else if (dir == 4) { // 오른쪽
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						q.offer(map[i][j]);
					}
				}

				flag = false; // true면 이전에 과정에서 숫자를 합침
				idx = n - 1;
				while (!q.isEmpty()) {
					if (idx + 1 < n && map[i][idx + 1] == q.peek() && !flag) {
						map[i][idx + 1] += q.poll();
						flag = true;
					} else {
						map[i][idx--] = q.poll();
						flag = false;
					}
				}

				// 나머지 부분 0으로 채우기
				for (int j = idx; j >= 0; j--)
					map[i][j] = 0;
			}
		}
	}

	private static void printMap(int[][] map, int dir) {
		System.out.println(dir + "=========================");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}