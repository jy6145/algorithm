import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01173.java
 * @date 2019. 4. 1.
 * @author Park JunYoung
 * @description 운동, BFS
 * 
 */

public class BOJ01173 {
	static int N, m, M, T, R;
	static int min;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 운동 시간
		m = Integer.parseInt(st.nextToken()); // 최소 맥박
		M = Integer.parseInt(st.nextToken()); // 최대 맥박
		T = Integer.parseInt(st.nextToken()); // 운동 시 증가하는 맥박
		R = Integer.parseInt(st.nextToken()); // 휴식 시 감소 맥박

		if (m + T > M)
			System.out.println(-1);
		else {
			min = Integer.MAX_VALUE;
			Queue<Node> q = new LinkedList<Node>();
			q.offer(new Node(m, 0, 0));

			Node now = null;
			while (!q.isEmpty()) {
				now = q.poll();

				if (now.cnt == N) {
					if (min > now.time)
						min = now.time;

					break;
				}

				if (now.pulse + T <= M) // 운동할경우
					q.offer(new Node(now.pulse + T, now.time + 1, now.cnt + 1));
				else // 운동 하지 않을경우(이미 맥박이 m일 경우 제외)
					q.offer(new Node(Math.max(now.pulse - R, m), now.time + 1, now.cnt));
			}
			System.out.println(min);
		}
	}

	static class Node {
		int pulse; // 현재 맥박
		int time; // 시간
		int cnt; // 운동 횟수

		public Node(int now, int time, int cnt) {
			this.pulse = now;
			this.time = time;
			this.cnt = cnt;
		}
	}
}