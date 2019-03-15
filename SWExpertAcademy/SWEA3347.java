import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3347.java
 * @date 2019. 3. 15.
 * @author Park JunYoung
 * @description 올림픽 종목 투표
 * 
 */

public class SWEA3347 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 경기 수
			int M = Integer.parseInt(st.nextToken()); // 위원회 수

			int[] vote = new int[N + 1]; // 투표함
			int[] A = new int[N + 1]; // x점수에서 가장 앞에 있는 인덱스

			// Ai
			int cost = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost = Integer.parseInt(st.nextToken());
				A[i] = cost;
			}

			// Bi
			cost = 0;
			int max = 0;
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				cost = Integer.parseInt(st.nextToken());
				for (int j = 1; j <= N; j++) {
					if (A[j] <= cost) {
						vote[j]++;
						if (max < vote[j]) {
							max = vote[j];
							idx = j;
						}
						break;
					}
				}
			}
			System.out.println("#" + testCase + " " + idx);
		}
	}
}
