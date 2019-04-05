import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_DIST = 1000 * 10000 + 1;
	static int N, S, D;
	static List<Edge>[] list;
	static boolean[] visit;
	static int minDist;
	static List<Edge> delRoute;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 장소의 수
			int M = Integer.parseInt(st.nextToken()); // 도로의 수

			if (N == 0 && M == 0)// 종료
				break;

			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken()); // 출발지점
			D = Integer.parseInt(st.nextToken()); // 도착지점

			list = new ArrayList[N];
			for (int i = 0; i < N; i++)
				list[i] = new ArrayList<Edge>();

			int u = 0;
			int v = 0;
			int p = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());

				list[u].add(new Edge(u, v, p));
			}

			int[] dist = new int[N];
			Arrays.fill(dist, MAX_DIST);
			Queue<Edge> q = new LinkedList<>();

			dist[S] = 0; // 자기 자신의 거리는 0
			for (int i = 0; i < list[S].size(); i++) {
				dist[list[S].get(i).des] = list[S].get(i).distance;
				q.offer(list[S].get(i));
			}

			// 최단 경로 크기 찾기
			Edge now = null;
			Edge next;
			while (!q.isEmpty()) {
				now = q.poll();

				for (int i = 0; i < list[now.des].size(); i++) {
					next = list[now.des].get(i);
					dist[next.des] = Math.min(dist[next.des], dist[next.src] + next.distance);
				}
			}

			// 삭제할 경로 찾기
			while (true) {
				visit = new boolean[N];
				delRoute = new LinkedList<>();
				minDist = dist[D];
				List<Integer> empty = new ArrayList<>();
				empty.add(S);
				dfs(S, 0, empty);
				
				//삭제하기
				for(int i =0;i<delRoute.size();i++) {
					
				}

				if (delRoute.size() == 0)
					break;
			}
			
			

			System.out.println(Arrays.toString(dist));
		}
	}

	static void dfs(int now, int dist, List<Integer> route) {
		if (dist > minDist) {
			return;
		}

		visit[now] = true;

		if (now == D) {
			System.out.println("!");
			for (int i = 0; i < route.size() - 1; i++) {
				delRoute.add(new Edge(route.get(i), route.get(i + 1), -1));
			}

			return;
		}

		List<Integer> cpRoute = new ArrayList<>();
		cpRoute.addAll(route);

		for (int i = 0; i < list[now].size(); i++) {
			if (!visit[list[now].get(i).des]) {
				cpRoute = new ArrayList<>();
				cpRoute.addAll(route);

				cpRoute.add(list[now].get(i).des);
				dfs(list[now].get(i).des, dist + list[now].get(i).distance, cpRoute);
			}
		}
	}

	static class Edge {
		int src; // 출발 지점
		int des; // 도착 지점
		int distance; // 거리

		public Edge(int src, int des, int distance) {
			this.src = src;
			this.des = des;
			this.distance = distance;
		}
	}
}
