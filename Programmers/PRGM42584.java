import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @fileName PRGM42584.java
 * @date 2020. 4. 26.
 * @author Park JunYoung
 * @description 42862. 주식가격
 *
 */

public class Main {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("../input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int prices[] = { 1, 2, 3, 2, 3 };

		System.out.println(Arrays.toString(Solution.solution(prices)));
	}

	static class Solution {
		public static int[] solution(int[] prices) {
			int length = prices.length;
			int[] answer = new int[length];

			for (int i = 0; i < length - 1; i++) {
				answer[i] = length - i - 1; // 한번도 안떨어질 경우

				for (int j = i; j < length; j++) {
					if (prices[j] < prices[i]) { // 떨어지면
						answer[i] = j - i;
						break;
					}
				}
			}

			// 마지막 지점은 항상 0
			answer[length - 1] = 0;

			return answer;
		}
	}
}
