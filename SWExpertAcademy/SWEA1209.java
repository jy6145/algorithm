
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1209.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 2일차 - Sum
 * 
 */

public class SWEA1209 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine(); // testCase

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			int sum = 0;
			// 가로
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}

				if (sum > max)
					max = sum;
			}

			// 세로
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}

				if (sum > max)
					max = sum;
			}

			// '\' 대각선
			sum = 0;
			for (int i = 0; i < 100; i++)
				sum += arr[i][i];
			if (sum > max)
				max = sum;

			// '/' 대각선
			sum = 0;
			for (int i = 0; i < 100; i++)
				sum += arr[99 - i][i];
			if (sum > max)
				max = sum;

			System.out.println("#" + testCase + " " + max);
		} // tc
	}
}