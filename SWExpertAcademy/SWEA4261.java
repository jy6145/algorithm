import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4261.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 빠른 휴대전화 키패드
 *
 */

public class SWEA4261 {
	static List<Dial> dial;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			int n = Integer.parseInt(st.nextToken());
			dial = new ArrayList<Dial>();

			for (int i = 0; i < 10; i++) {
				dial.add(new Dial());
			}

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					dial.get(i + 2).list.add((char) ('a' + (i * 3) + j));
				}
			}
			dial.get(7).list.add('s');

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					dial.get(i + 8).list.add((char) ('t' + (i * 3) + j));
				}
			}
			dial.get(9).list.add('z');

			st = new StringTokenizer(br.readLine());
			String tmp = "";
			Boolean flag = false; // true 경우 단어가 만족 안함
			int answer = 0;
			while (st.hasMoreTokens()) {
				tmp = st.nextToken();

				flag = false;
				for (int i = 0; i < str.length(); i++) {
					if (!dial.get(str.charAt(i) - '0').list.contains(tmp.charAt(i))) {
						flag = true;
						break;
					}
				}
				if (!flag)
					answer++;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static class Dial {
		List<Character> list;

		public Dial() {
			list = new ArrayList<Character>();
		}
	}
}