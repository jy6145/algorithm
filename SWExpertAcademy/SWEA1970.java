
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1970.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 쉬운 거스름돈, 탐욕알고리즘
 * 
 */

public class SWEA1970 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int money = Integer.parseInt(br.readLine());

			int[] changeCnt = new int[8]; // 거스름 돈
			int[] changeUnit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // 거스름돈 단위

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			for (int i = 0; i < 8; i++) {
				changeCnt[i] = money / changeUnit[i];
				money %= changeUnit[i];
				answer.append(changeCnt[i] + " ");
			}

			System.out.println(answer.toString());
		}
	}
}
