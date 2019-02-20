import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3124.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 최소 스패닝 트리, MST, Prim, 우선순위 큐
 * 
 */

public class SWEA3124 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken()); // 정점 개수
			int e = Integer.parseInt(st.nextToken()); // 간선 개수

			ArrayList<Edge>[] edges = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				edges[i] = new ArrayList<Edge>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				edges[a].add(new Edge(b, w));
				edges[b].add(new Edge(a, w));
			}

			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

			for (int i = 0; i < edges[1].size(); i++) {
				pq.offer(edges[1].get(i)); // 1번째에 있는 간선들을 모두 우선순위큐에 넣기
			}

			boolean[] visit = new boolean[v + 1];
			visit[1] = true;

			long sum = 0;
			while (!pq.isEmpty()) {
				Edge now = pq.poll();

				if (visit[now.data])
					continue;

				visit[now.data] = true;
				sum += now.weight;

				Edge nextEdge = null;
				for (int i = 0; i < edges[now.data].size(); i++) {
					nextEdge = edges[now.data].get(i);
					if (!visit[nextEdge.data]) {
						pq.offer(nextEdge);
					}
				}
			}

			System.out.println("#" + testCase + " " + sum);
		}

		br.close();
	}

	static class Edge implements Comparable<Edge> {
		int data;
		int weight;

		Edge(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
