import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @fileName BOJ08983.java
 * @date 2019. 3. 5.
 * @author Park JunYoung
 * @description 사냥꾼, 이진탐색
 * 
 */

public class BOJ08983 {
	static long[] gunArea;
	static long point;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 사대
		int N = Integer.parseInt(st.nextToken()); // 동물의 수
		long L = Long.parseLong(st.nextToken()); // 사정거리

		gunArea = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			gunArea[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(gunArea);

		PriorityQueue<Coordi> pq = new PriorityQueue<Coordi>();

		long x = 0;
		long y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());

			if (y <= L)
				pq.offer(new Coordi(x, y));
		}

		int answer = 0;
		Coordi animal = null;
		while (!pq.isEmpty()) {
			animal = pq.poll();
			binarySearch(animal.x, 0, M - 1);

			if (Math.abs(point - animal.x) + animal.y <= L) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	static void binarySearch(long find, int start, int end) {
		int mid = (int) ((start + end) / 2);

		if (find == gunArea[mid]) {
			point = gunArea[mid];
			return;
		}

		if (start >= end) {
			long min = Long.MAX_VALUE;
			for (int i = -1; i <= 1; i++) {
				if (mid + i < 0 || mid + i >= gunArea.length)
					continue;

				if (Math.abs(gunArea[mid + i] - find) < min) {
					point = gunArea[mid + i];
					min = Math.abs(gunArea[mid + i] - find);
				}
			}
			return;
		}

		if (gunArea[mid] < find) {
			binarySearch(find, mid + 1, end);
		} else {
			binarySearch(find, start, mid - 1);
		}
	}

	static class Coordi implements Comparable<Coordi> {
		long x;
		long y;

		public Coordi(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordi o) {
			return (int) (y - o.y);
		}
	}
}
