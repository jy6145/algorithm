import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @fileName PRGM42586.java
 * @date 2020. 05. 06.
 * @author Park JunYoung
 * @description 42586. 기능개발
 *
 */

public class PRGM42586 {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("../input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		System.out.println(Arrays.toString(Solution.solution(progresses, speeds)));
	}

	static class Solution {
		public static int[] solution(int[] progresses, int[] speeds) {
			LinkedList<Integer> ansArr = new LinkedList<Integer>();
			int jobCnt = progresses.length;
			int[] complete = new int[jobCnt];

			for (int i = 0; i < jobCnt; i++) {
				complete[i] = (100 - progresses[i]) / speeds[i];
				if ((100 - progresses[i]) % speeds[i] != 0) {
					complete[i]++;
				}
			}

			int idx = 0;
			for (int i = 0; i < jobCnt; i++) {
				if (complete[idx] < complete[i]) {
					ansArr.add(i - idx);
					idx = i;
				}
			}

			ansArr.add(jobCnt - idx);

			int[] answer = new int[ansArr.size()];

			for (int j = 0; j < ansArr.size(); j++) {
				answer[j] = ansArr.get(j);
			}

			return answer;
		}
	}
}