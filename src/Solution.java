import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine()); // 농구 선수
			int[] cnt = new int[26]; // 알파벳 카운트

			String str;
			int max = 0;
			for (int i = 0; i < n; i++) {
				str = br.readLine();
				cnt[str.charAt(0) - 'a']++;
				if (str.charAt(0) - 'a' > max)
					max = str.charAt(0) - 'a';
			}

			StringBuilder answer = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if (cnt[i] == max)
					answer.append('a' + i);
			}

			if (answer.equals(""))
				answer.append("PREDAJA");

			System.out.println(answer.toString());
		}
	}
}