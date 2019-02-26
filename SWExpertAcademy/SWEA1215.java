
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1215.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 3일차 - 회문1
 * 
 */

public class SWEA1215 {
	static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());

			char[][] arr = new char[8][8];
			String str = "";
			for (int i = 0; i < arr.length; i++) {
				str = br.readLine();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int answer = 0;
			boolean flag = false;

			// 가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					flag = false;
					for (int k = 0; k < n / 2; k++) {
						if (arr[i][j + k] != arr[i][j + n - k - 1]) {
							flag = true;
							break;
						}
					}

					if (!flag) {
						answer++;
					}
				}
			}

			// 세로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					flag = false;
					for (int k = 0; k < n / 2; k++) {
						if (arr[j + k][i] != arr[j + n - k - 1][i]) {
							flag = true;
							break;
						}
					}

					if (!flag) {
						answer++;
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
