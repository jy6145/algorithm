
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1983.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 조교의 성적 매기기, 나누기할때 자료형 조심(int)
 * 
 */

public class SWEA1983 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Score[] scores = new Score[n];
			int sum = 0;
			int midScore = 0; // 중간 고사
			int finalScore = 0; // 기말 고사
			int ws = 0; // 과제
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				midScore = Integer.parseInt(st.nextToken());
				finalScore = Integer.parseInt(st.nextToken());
				ws = Integer.parseInt(st.nextToken());

				sum = (midScore * 35) + (finalScore * 45) + (ws * 20);

				scores[i] = new Score(i + 1, sum);
			}

			Arrays.sort(scores, new Comparator<Score>() {

				@Override
				public int compare(Score o1, Score o2) {
					return o2.sum - o1.sum;
				}
			});

			int index = 0;
			for (int i = 1; i <= n; i++) {
				if (scores[i].index == k) {
					index = i;
					break;
				}
			}

			double p = (index + 1) * 10.0 / n; // 퍼센트, 소수점까지 고려해서 계산해야함.

			String answer = "";
			if (p <= 1)
				answer = "A+";
			else if (p <= 2)
				answer = "A0";
			else if (p <= 3)
				answer = "A-";
			else if (p <= 4)
				answer = "B+";
			else if (p <= 5)
				answer = "B0";
			else if (p <= 6)
				answer = "B-";
			else if (p <= 7)
				answer = "C+";
			else if (p <= 8)
				answer = "C0";
			else if (p <= 9)
				answer = "C-";
			else
				answer = "D0";

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static class Score {
		int index;
		int sum;

		public Score(int index, int sum) {
			this.index = index;
			this.sum = sum;
		}

	}
}
