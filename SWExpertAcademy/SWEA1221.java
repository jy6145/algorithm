import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1221.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description [S/W 문제해결 기본] 5일차 - GNS 	
 * 
 */

public class SWEA1221 {
	static String[] numCh = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine(); // #testCase, 입력 개수

			int[] num = new int[10];
			st = new StringTokenizer(br.readLine());
			String tmp = "";
			while (st.hasMoreElements()) {
				tmp = st.nextToken();
				for (int i = 0; i < 10; i++) {
					if (tmp.equals(numCh[i])) {
						num[i]++;
						break;
					}
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + "\n");
			for (int i = 0; i < 10; i++) {
				while (num[i] != 0) {
					answer.append(numCh[i] + " ");
					num[i]--;
				}
			}

			System.out.println(answer);
		} // tc
	}
}