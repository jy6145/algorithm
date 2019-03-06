import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02644.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 촌수계산, BFS
 * 
 */

public class BOJ02644 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		LinkedList<Integer>[] g = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			g[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			g[tmp1].add(tmp2);
			g[tmp2].add(tmp1);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> level = new LinkedList<Integer>();
		boolean[] visit = new boolean[n + 1];
		q.add(a);
		level.add(0);

		boolean find = false;
		int answer = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			int nowLv = level.poll();
			visit[now] = true;

			if (now == b) {
				find = true;
				answer = nowLv;
				break;
			}

			for (int i = 0; i < g[now].size(); i++) {
				if (!visit[g[now].get(i)]) {
					q.add(g[now].get(i));
					level.add(nowLv + 1);
				}
			}
		}

		if (!find) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
		}
	}
}
