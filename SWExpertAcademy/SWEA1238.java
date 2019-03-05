import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1238.java
 * @date 2019. 3. 5.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 10일차 - Contact, BFS
 *
 */

public class SWEA1238 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // edge 개수
			int start = Integer.parseInt(st.nextToken()); // 출발점

			List<Node>[] nodes = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				nodes[i] = new ArrayList<Node>();
			}

			int from = 0;
			int to = 0;
			boolean flag = false;

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());

				flag = false;
				for (Node node : nodes[from]) {
					if (node.num == to) { // flag=true => 링크 존재
						flag = true;
						break;
					}
				}

				if (!flag) {
					nodes[from].add(new Node(to, 0));
				}
			}

			boolean[] visit = new boolean[101];

			Queue<Node> q = new LinkedList<Node>();
			for (Node node : nodes[start]) {
				node.hop += 1;
				q.offer(node);
			}
			visit[start] = true;

			// BFS
			Node now = null;
			int answer = start;
			int maxHop = 0;
			while (!q.isEmpty()) {
				now = q.poll();

				if (visit[now.num]) // 방문했을경우
					continue;

				visit[now.num] = true;

				if (maxHop < now.hop) {
					maxHop = now.hop;
					answer = now.num;
				} else if (maxHop == now.hop && now.num > answer) {
					answer = now.num;
				}

				for (Node node : nodes[now.num]) {
					node.hop = now.hop + 1;
					q.offer(node);
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static class Node {
		int num;
		int hop;

		public Node(int num, int hop) {
			this.num = num;
			this.hop = hop;
		}
	}
}