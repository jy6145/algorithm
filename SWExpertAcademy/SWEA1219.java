import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1219.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 4일차 - 길찾기
 * 
 */

public class SWEA1219 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			st = new StringTokenizer(br.readLine());

			st.nextToken(); // 테스트 케이스 번호
			int n = Integer.parseInt(st.nextToken()); // edge 개수

			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < 100; i++) {
				list.add(new ArrayList<Integer>());
			}

			int from = 0;
			int to = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list.get(from).add(to);
			}

			Queue<Integer> q = new LinkedList<Integer>();

			q.offer(0);

			int answer = 0;
			int now = 0;
			while (!q.isEmpty()) {
				now = q.poll();

				if (now == 99) {
					answer = 1;
					break;
				}

				for (int i = 0; i < list.get(now).size(); i++)
					q.offer(list.get(now).get(i));
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}