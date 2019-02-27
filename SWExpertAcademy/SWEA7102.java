import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7102.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 준홍이의 카드놀이
 * 
 */

public class SWEA7102 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int arr[] = new int[n + m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					arr[i + j]++;
				}
			}

			int max = Arrays.stream(arr).max().getAsInt();
			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max)
					answer.append(i + " ");
			}

			System.out.println(answer.toString());
		}
	}
}