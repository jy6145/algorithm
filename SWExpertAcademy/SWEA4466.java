import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4466.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 최대 성적표 만들기, arrays.sort내림차순, reverseOrder 	
 * 
 */

public class SWEA4466 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Integer[] score = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(score, Collections.reverseOrder());

			int answer = 0;
			for (int i = 0; i < k; i++) {
				answer += score[i];
			}

			System.out.println("#" + testCase + " " + answer);

		} // tc
	}
}