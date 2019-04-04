import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ12761.java
 * @date 2019. 4. 4.
 * @author Park JunYoung
 * @description 돌다리, BFS
 * 
 */

public class BOJ12761 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] d = { +1, -1, +A, +B, -A, -B };
		boolean[] visit = new boolean[100001];

		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(N, 0));

		Node now = null;
		int answer = 0;
		int nNum = 0;
		while (!q.isEmpty()) {
			now = q.poll();

			if (visit[now.num])
				continue;
			visit[now.num] = true;

			if (now.num == M) {
				answer = now.move;
				break;
			}

			for (int i = 0; i < 6; i++) {
				nNum = now.num + d[i];

				if (0 <= nNum && nNum <= 100000 && !visit[nNum])
					q.offer(new Node(nNum, now.move + 1));
			}

			nNum = now.num * A;
			if (0 <= nNum && nNum <= 100000 && !visit[nNum])
				q.offer(new Node(nNum, now.move + 1));

			nNum = now.num * B;
			if (0 <= nNum && nNum <= 100000 && !visit[nNum])
				q.offer(new Node(nNum, now.move + 1));
		}

		System.out.println(answer);
	}

	static class Node {
		int num;
		int move;

		public Node(int num, int move) {
			this.num = num;
			this.move = move;
		}
	}

}
