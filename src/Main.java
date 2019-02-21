import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dist;
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 정점
		int e = Integer.parseInt(st.nextToken()); // 간선

		int k = Integer.parseInt(br.readLine()); // 출발 정점

		ArrayList<Node>[] nodes = new ArrayList[v + 1];

		for (int i = 1; i <= v; i++) {
			nodes[i] = new ArrayList<Node>();
		}

		int a, b, c;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			nodes[a].add(new Node(b, c));
		}

		dist = new int[v]; // 현재 지점에서의 거리
		visit = new boolean[v]; // 방문 확인
		for (int i = 0; i < v; i++) {
			dist[i] = INF;
		}

		// 첫 지점에서 설정
		visit[k] = true;
		
		
	}

	static class Node {
		int data;
		int weight;

		public Node(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}
	}
}