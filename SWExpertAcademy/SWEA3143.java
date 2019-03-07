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
 * @fileName SWEA3143.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 가장 빠른 문자열 타이핑
 * 
 */

public class SWEA3143 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			String chgA = a.replaceAll(b, "x");
			int answer = chgA.length();

			System.out.println("#" + testCase + " " + answer);
		}
	}
}