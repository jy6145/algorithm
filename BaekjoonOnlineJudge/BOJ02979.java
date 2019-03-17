import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02979.java
 * @date 2019. 3. 18.
 * @author Park JunYoung
 * @description 트럭 주차
 *
 */

public class BOJ02979 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()) * 2;
		int C = Integer.parseInt(st.nextToken()) * 3;

		int time[] = new int[101];

		int start = 0;
		int end = 0;

		int minIdx = 101;
		int maxIdx = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if (start < minIdx)
				minIdx = start;
			if (end > maxIdx)
				maxIdx = end;

			for (int j = start + 1; j <= end; j++)
				time[j]++;
		}

		int answer = 0;
		for (int i = minIdx; i <= maxIdx; i++) {
			if (time[i] == 1)
				answer += A;
			else if (time[i] == 2)
				answer += B;
			else if (time[i] == 3)
				answer += C;
		}

		System.out.println(answer);
	}
}