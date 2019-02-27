
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3314.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 보충학습과 평균 	
 * 
 */

public class SWEA3314 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			st = new StringTokenizer(br.readLine());
			int num = 0;
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				num = Integer.parseInt(st.nextToken());

				if (num < 40)
					num = 40;

				sum += num;
			}

			int answer = sum / 5;
			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}