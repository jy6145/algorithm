import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4050.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 재관이의 대량 할인
 * 
 */

public class SWEA4050 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			ArrayList<Integer> cost = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				cost.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(cost, Collections.reverseOrder());

			int answer = 0;
			for (int i = 0; i < n; i++) {
				if ((i + 1) % 3 != 0)
					answer += cost.get(i);
			}
			System.out.println("#" + testCase + " " + answer);
		}
	}
}