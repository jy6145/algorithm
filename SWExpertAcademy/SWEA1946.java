
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @fileName SWEA1946.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 간단한 압축 풀기 	
 * 
 */

public class SWEA1946 {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			char c = ' ';
			int k = 0;
			int index = 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				c = st.nextToken().charAt(0);
				k = Integer.parseInt(st.nextToken());

				for (int j = 0; j < k; j++) {
					if (index % 11 == 0) {
						index++;
						answer.append("\n");
					}
					answer.append(c);
					index++;
				}
			}

			System.out.println(answer.toString());
		}
	}
}
