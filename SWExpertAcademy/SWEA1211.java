import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.xml.soap.Node;

/**
 * @fileName SWEA1211.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 2일차 - Ladder2
 * 
 */

public class SWEA1211 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine(); // 테스트 케이스 번호

			int[][] ladder = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int row = 0;
			int col = 0;
			int cnt = 0;
			int max = Integer.MAX_VALUE;
			int answer = 0;
			for (int i = 0; i < 100; i++) {
				row = 0;
				col = i;
				cnt = 0;

				if (ladder[row][col] != 1)
					continue;

				while (row != 99) {
					if (col - 1 >= 0 && ladder[row][col - 1] == 1) { // 왼쪽 이동
						while (col - 1 >= 0 && ladder[row][col - 1] == 1) {
							col--;
							cnt++;
						}
					} else if (col + 1 < 100 && ladder[row][col + 1] == 1) { // 오른쪽 이동
						while (col + 1 < 100 && ladder[row][col + 1] == 1) {
							col++;
							cnt++;
						}
					}
					row++;
					cnt++;
				}

				if (max > cnt) {
					max = cnt;
					answer = i;
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}