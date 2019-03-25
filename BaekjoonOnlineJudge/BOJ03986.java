import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @fileName BOJ03986.java
 * @date 2019. 3. 25.
 * @author Park JunYoung
 * @description 좋은 단어
 *
 */

public class BOJ03986 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Character> stk = new Stack<Character>();
		int N = Integer.parseInt(br.readLine());

		String word = "";
		int answer = 0;
		for (int i = 0; i < N; i++) {
			stk.clear();
			word = br.readLine();

			for (int j = 0; j < word.length(); j++) {
				if (stk.isEmpty() || stk.peek() != word.charAt(j))
					stk.push(word.charAt(j));
				else
					stk.pop();
			}

			if (stk.isEmpty())
				answer++;
		}

		System.out.println(answer);
	}// main
}