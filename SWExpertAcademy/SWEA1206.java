import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1206.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 1일차 - View
 * 
 */

public class SWEA1206 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[] building = new int[n];// 양끝 2칸은 빌딩 없음

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}

			// 내림차순 우선순위 큐
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

			int answer = 0;
			for (int i = 2; i < n - 2; i++) {
				pq.clear();
				for (int j = -2; j < 3; j++) { // 5칸씩 확인
					pq.offer(building[i + j]);
				}

				// 5칸중 가운데(2번쨰)가 가장 크면 조망권 계산
				if (building[i] == pq.poll()) {
					answer += building[i] - pq.poll(); // 두번째로 높은 빌딩의 차이만큼 조망권 확보
					i += 2; // 조망권이 확보됬을 때 다음 2빌딩은 조망권 확보 불가
				}
			}

			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}