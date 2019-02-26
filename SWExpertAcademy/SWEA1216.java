
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1216.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 3일차 - 회문2
 * 
 */

public class SWEA1216 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			Integer.parseInt(br.readLine()); // testCase
			int[][] board = new int[100][100];

			String str = "";
			for (int i = 0; i < 100; i++) {
				str = br.readLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			int answer = 1;
			boolean flag = false;
			loop: for (int i = 100; i >= 2; i--) { // 회문의 길이

				// 가로
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100 - i + 1; k++) {
						flag = false;
						for (int l = 0; l < i / 2; l++) {
							if (board[j][k + l] != board[j][k + i - 1 - l]) { // 회문 실패
								flag = true;
								break;
							}
						}
						if (!flag) {
							answer = i;
							break loop; // 종료
						}
					}
				}

				// 세로
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100 - i + 1; k++) {
						flag = false;
						for (int l = 0; l < i / 2; l++) {
							if (board[k + l][j] != board[k + i - 1 - l][j]) { // 회문 실패
								flag = true;
								break;
							}
						}
						if (!flag) {
							answer = i;
							break loop; // 종료
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}