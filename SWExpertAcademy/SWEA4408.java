
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4408.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 자기 방으로 돌아가기
 * 
 */

public class SWEA4408 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine().trim());

			int[] rooms = new int[200];

			int a = 0;
			int b = 0;
			int first = 0;
			int second = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				first = (Math.min(a, b) - 1) / 2;
				second = (Math.max(a, b) - 1) / 2;

				for (int j = first; j <= second; j++) {
					rooms[j]++;
				}
			}

			int answer = 0;
			for (int i = 0; i < 200; i++) {
				if (answer < rooms[i])
					answer = rooms[i];
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
