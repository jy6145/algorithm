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
 * @fileName SWEA5658.java
 * @date 2019. 3. 14.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 보물상자 비밀번호, 진수변환
 *
 */

public class SWEA5658 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			String code = br.readLine();
			int size = N / 4; // (N/4)글자씩 코드 해독
			Set<Integer> nums = new HashSet<Integer>();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < N; j += size) {
					nums.add(Integer.parseInt(code.substring(j, j + size), 16));
				}
				code = lotationR(code);
			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			Iterator<Integer> it = nums.iterator();
			while (it.hasNext()) {
				list.add(it.next());
			}

			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#" + testCase + " " + list.get(K - 1));
		}
	}

	static String lotationR(String s) {
		String result = "";

		char tmp = s.charAt(s.length() - 1);
		result = s.substring(0, s.length() - 1);
		result = tmp + result;

		return result;
	}
}
