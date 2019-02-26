
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1220.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 5일차 - Magnetic 	
 * 
 */

public class SWEA1220 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[][] table = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 1: N극, 2: S극 / 위쪽 : N, 아랫쪽 : S
			boolean flag = false;
			int answer = 0;
			for (int i = 0; i < n; i++) {
				flag = false;
				for (int j = 0; j < n; j++) {
					if (!flag && table[j][i] == 1) { // N극을 처음 만났을 경우
						flag = true;
					} else if (flag && table[j][i] == 2) { // N극 후 S극을 만났을 경우 교착 발생
						flag = false;
						answer++;
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}