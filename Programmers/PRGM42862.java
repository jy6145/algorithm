import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @fileName PRGM42862.java
 * @date 2020. 4. 26.
 * @author Park JunYoung
 * @description 42862. 체육복
 *
 */

public class Main {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("../input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };

		System.out.println(Solution.solution(n, lost, reserve));
	}

	static class Solution {
		public static int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			int[] now = new int[n + 1];

			// 체육복 1개씩 배분
			for (int i = 1; i <= n; i++) {
				now[i] = 1;
			}

			// lost, reserve
			for (int i = 0; i < lost.length; i++) {
				now[lost[i]]--;
			}
			for (int i = 0; i < reserve.length; i++) {
				now[reserve[i]]++;
			}

			// 빌려주기
			int no_have_cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (now[i] == 0) {
					if (i > 1 && now[i - 1] >= 2) {
						now[i]++;
						now[i - 1]--;
					} else if (i < n && now[i + 1] >= 2) {
						now[i]++;
						now[i + 1]--;
					} else {
						no_have_cnt++;
					}
				}
			}

			answer = n - no_have_cnt;

			return answer;
		}
	}
}
