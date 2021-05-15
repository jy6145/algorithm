/**
 * @fileName Solution.java
 * @date 2021. 5. 15.
 * @author Park JunYoung
 * @description 1845. 포켓몬	
 * 
 */

public class PRGM01845 {
	public int solution(int[] nums) {
		int answer = 0;

		boolean[] chk = new boolean[200001];
		int kind = 0;

		for (int num : nums) {
			if (!chk[num]) {
				chk[num] = true;
				kind++;
			}
		}

		answer = Math.min(nums.length / 2, kind);

		return answer;
	}

	public static void main(String[] args) {
		PRGM01845 s = new PRGM01845();
		int[] nums = { 3, 3, 3, 2, 2, 2 };

		System.out.println(s.solution(nums));

	}
}
