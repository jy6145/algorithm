import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3000.java
 * @date 2019. 3. 15.
 * @author Park JunYoung
 * @description 중간값 구하기, 우선순위큐
 * 
 */

public class SWEA3000 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			PriorityQueue<Long> left = new PriorityQueue<Long>(new Comparator<Long>() {
				@Override
				public int compare(Long o1, Long o2) {
					return o2 > o1 ? 1 : -1;
				}
			}); // 가장 큰수 우선
			long mid = 0;
			PriorityQueue<Long> right = new PriorityQueue<Long>(); // 가장 작은수 우선

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			mid = A;

			long n1 = 0;
			long n2 = 0;
			long answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				n1 = Long.parseLong(st.nextToken());
				n2 = Long.parseLong(st.nextToken());

				if (n1 < mid && n2 < mid) {
					left.offer(n1);
					left.offer(n2);
					right.offer(mid);
					mid = left.poll();
				} else if (mid < n1 && mid < n2) {
					right.offer(n1);
					right.offer(n2);
					left.offer(mid);
					mid = right.poll();
				} else {
					if (n1 < n2) {
						left.offer(n1);
						right.offer(n2);
					} else {
						left.offer(n2);
						right.offer(n1);
					}
				}
				answer += mid;
				answer %= 20171109;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
