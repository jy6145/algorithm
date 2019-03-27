import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4012.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 요리사, DFS
 * 
 */

public class SWEA4012 {
	static int[][] synergy;
	static boolean[] select;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());

			synergy = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			select = new boolean[N];
			answer = Integer.MAX_VALUE;
			dfs(0, 0, N / 2);
			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void dfs(int pivot, int cnt, int goal) {
		if (cnt == goal) {
			ArrayList<Integer> cook1 = new ArrayList<Integer>();
			ArrayList<Integer> cook2 = new ArrayList<Integer>();

			for (int i = 0; i < select.length; i++)
				if (select[i])
					cook1.add(i);
				else
					cook2.add(i);

			int sub = calc(cook1, cook2);
			if (answer > sub) {
				answer = sub;
			}

			return;
		}
		if (pivot == select.length)
			return;

		// 선택하기
		select[pivot] = true;
		dfs(pivot + 1, cnt + 1, goal);

		// 선택 안하기
		select[pivot] = false;
		dfs(pivot + 1, cnt, goal);
	}

	static int calc(ArrayList<Integer> cook1, ArrayList<Integer> cook2) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < cook1.size(); i++) {
			for (int j = 0; j < cook1.size(); j++) {
				sum1 += synergy[cook1.get(i)][cook1.get(j)];
			}
		}

		for (int i = 0; i < cook2.size(); i++) {
			for (int j = 0; j < cook2.size(); j++) {
				sum2 += synergy[cook2.get(i)][cook2.get(j)];
			}
		}

		return Math.abs(sum1 - sum2);
	}
}