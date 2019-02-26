
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4406.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description 모음이 보이지 않는 사람, replace
 * 
 */

public class SWEA4406 {
	static String[] vowels = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			String answer = "";

			for (int i = 0; i < 5; i++) {
				str = str.replace(vowels[i], "");
			}

			System.out.println("#" + testCase + " " + str);
		} // tc
	}
}