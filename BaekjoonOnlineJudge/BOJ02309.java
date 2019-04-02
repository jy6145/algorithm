import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @fileName BOJ02309.java
 * @date 2019. 4. 2.
 * @author Park JunYoung
 * @description 일곱 난쟁이, DFS
 * 
 */

public class BOJ02309 {
	static boolean[] flag;
	static boolean answerFlag; // 정답 찾으면 true

	static int height[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		height = new int[9];
		for (int i = 0; i < 9; i++)
			height[i] = Integer.parseInt(br.readLine());

		Arrays.sort(height);
		answerFlag = false;
		flag = new boolean[9];
		dfs(0, 0, 0);
	}

	static void dfs(int pivot, int select, int sum) {
		if (select == 7 && sum == 100) {
			for (int i = 0; i < 9; i++)
				if (flag[i])
					System.out.println(height[i]);

			answerFlag = true;
			return;
		}

		if (pivot == 9 || select > 7)
			return;

		// 뽑을 때
		flag[pivot] = true;
		if (sum + height[pivot] <= 100)
			dfs(pivot + 1, select + 1, sum + height[pivot]);
		// 안뽑을때
		flag[pivot] = false;
		dfs(pivot + 1, select, sum);
	}
}