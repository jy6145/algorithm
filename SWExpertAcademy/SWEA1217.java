
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1217.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 4일차 - 거듭 제곱, 문제대로안품
 * 
 */

public class SWEA1217 {
	static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int answer = (int) Math.pow(n, m);

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
