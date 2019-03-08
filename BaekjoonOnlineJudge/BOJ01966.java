import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01966.java
 * @date 2019. 3. 8.
 * @author Park JunYoung
 * @description 프린터 큐, BFS
 *
 */

public class BOJ01966 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Queue<Paper> q = new LinkedList<Paper>();
			ArrayList<Integer> order = new ArrayList<Integer>();

			Paper tmp;
			Paper goal = null;
			int num = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
				order.add(num);
				tmp = new Paper(i, num);
				if (i == m)
					goal = tmp;

				q.offer(tmp);
			}

			Collections.sort(order, Collections.reverseOrder());
			int orderIdx = 0;

			int cnt = 0;
			while (!q.isEmpty()) {
				tmp = q.poll();
				if (tmp.priority == order.get(orderIdx)) { // 우선순위가 뽑을 수 있음
					cnt++;
					orderIdx++;
					if (tmp == goal) // 원하는 문서번호일 경우
						break;
				} else { // 우선순위가 아닐 경우
					q.offer(tmp);
				}
			}

			System.out.println(cnt);
		}
	}

	static class Paper {
		int idx;
		int priority;

		public Paper(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
	}
}
