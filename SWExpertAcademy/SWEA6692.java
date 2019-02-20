import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6692.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 다솔이의 월급 상자, 확률
 * 
 */

public class SWEA6692 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			double p = 0;
			double salary = 0;
			double answer = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				p = Double.parseDouble(st.nextToken());
				salary = Double.parseDouble(st.nextToken());

				answer += p * salary;
			}

			System.out.printf("#%d %f\n", testCase, answer);
		}
	}
}
