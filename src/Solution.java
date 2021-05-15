import java.util.ArrayList;

public class Solution {
	public static int[] solution(int[] answers) {
		int[] answer = {};

		int[][] pattern = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] score = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (pattern[j][i % pattern[j].length] == answers[i])
					score[j]++;
			}
		}

		int max = Math.max(score[0], Math.max(score[1], score[2]));

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			if (score[i] == max)
				arr.add(i);
		}

		answer = new int[arr.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i) + 1;
		}

		return answer;
	}

	public static void main(String[] args) {
		PRGM42840.solution(null);
	}
}
