import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01159.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 농구 경기
 *
 */
public class BOJ01159 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine()); // 농구 선수
		int[] cnt = new int[26]; // 알파벳 카운트

		String str;
		int max = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			cnt[str.charAt(0) - 'a']++;
			if (cnt[str.charAt(0) - 'a'] > max)
				max = cnt[str.charAt(0) - 'a'];
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 5)
				answer.append((char) ('a' + i));
		}

		if (max < 5)
			System.out.println("PREDAJA");
		else
			System.out.println(answer.toString());
	}
}
