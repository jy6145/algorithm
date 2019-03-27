import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA7272.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 안경이 없어!
 * 
 */

public class SWEA7272 {
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			Set<Character> oneHole = new HashSet<Character>();
			Set<Character> twoHole = new HashSet<Character>();
			oneHole.add('A');
			oneHole.add('D');
			oneHole.add('O');
			oneHole.add('P');
			oneHole.add('Q');
			oneHole.add('R');

			twoHole.add('B');

			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			int flag1 = -1;
			int flag2 = -1;
			boolean result = false; // true면 다름
			for (int i = 0; i < str1.length(); i++) {
				if (str1.length() != str2.length()) { // 글자수 다를 경우
					result = true;
					break;
				}

				if (oneHole.contains(str1.charAt(i)))
					flag1 = 1;
				else if (twoHole.contains(str1.charAt(i)))
					flag1 = 2;
				else
					flag1 = 3;

				if (oneHole.contains(str2.charAt(i)))
					flag2 = 1;
				else if (twoHole.contains(str2.charAt(i)))
					flag2 = 2;
				else
					flag2 = 3;

				if (flag1 != flag2) {
					result = true;
					break;
				}
			}

			if (result)
				System.out.println("#" + testCase + " DIFF");
			else
				System.out.println("#" + testCase + " SAME");
		}
	}
}