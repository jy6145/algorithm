import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5162.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 두가지 빵의 딜레마 	
 * 
 */

public class SWEA5162 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int selectBread = Math.min(a, b);
			int answer = c / selectBread;

			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}