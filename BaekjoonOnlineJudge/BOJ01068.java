import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01068.java
 * @date 2019. 3. 26.
 * @author Park JunYoung
 * @description 트리
 *
 */

public class BOJ01068 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++)
			nodes[i] = new Node(i);

		Node root = null;
		int parent = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent = Integer.parseInt(st.nextToken());
			if (parent == -1) // 루트확인
				root = nodes[i];
			else // 루트가 아니라면 자식 추가
				nodes[parent].children.add(nodes[i]);
		}

		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);

		Node now = null;
		int answer = 0;
		int removeIdx = Integer.parseInt(br.readLine()); // 지울 노드 번호
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.idx == removeIdx) // 루트 제거 대비
				continue;

			if (now.children.size() == 0 // 자식이 없거나
					|| (now.children.size() == 1 && now.children.get(0).idx == removeIdx))// 자식이 1개인데, 제거대상 노드이면
				answer++;
			else {
				for (Node child : now.children) {
					if (child.idx != removeIdx)
						q.offer(child);
				}
			}
		}

		System.out.println(answer);
	}// main

	static class Node {
		int idx;
		ArrayList<Node> children;

		public Node(int data) {
			this.idx = data;
			children = new ArrayList<Node>();
		}
	}
}