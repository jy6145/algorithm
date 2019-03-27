import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5643.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description [Professional] 키 순서, DFS
 * 
 */

public class SWEA5643 {
	static Node[] nodes;
	static boolean[] visit;
	static int sCnt;
	static int lCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());

			nodes = new Node[N + 1];
			for (int i = 1; i <= N; i++)
				nodes[i] = new Node(i);

			int p1 = 0;
			int p2 = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());

				nodes[p1].front.add(nodes[p2]);
				nodes[p2].rear.add(nodes[p1]);
			}

			sCnt = 0; // 기준에서 키가 작은사람 수
			lCnt = 0; // 기준에서 키가 큰 사람의 수
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				sCnt = 0;
				lCnt = 0;

				visit = new boolean[N + 1];
				dfsShort(i);
				visit = new boolean[N + 1];
				dfsLong(i);

				if (sCnt + lCnt - 1 == N) // 자기 자신 한번 뺴야됨
					answer++;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void dfsShort(int num) {
		Node now = nodes[num];
		sCnt++;
		visit[now.num] = true;

		for (Node node : now.rear)
			if (!visit[node.num])
				dfsShort(node.num);
	}

	static void dfsLong(int num) {
		Node now = nodes[num];
		lCnt++;
		visit[now.num] = true;

		for (Node node : now.front)
			if (!visit[node.num])
				dfsLong(node.num);
	}

	static class Node {
		int num;
		ArrayList<Node> front; // 키큰사람
		ArrayList<Node> rear; // 키작은사람

		public Node(int num) {
			this.num = num;
			front = new ArrayList<Node>();
			rear = new ArrayList<Node>();
		}
	}
}