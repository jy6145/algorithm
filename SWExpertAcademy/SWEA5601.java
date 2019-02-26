
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5601.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description [Professional] 쥬스 나누기
 * 
 */

public class SWEA5601 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			StringBuilder answer = new StringBuilder("#" + testCase + " ");

			for (int i = 0; i < n; i++) {
				answer.append("1/" + n + " ");
			}

			System.out.println(answer.toString());
		} // tc
	}
}