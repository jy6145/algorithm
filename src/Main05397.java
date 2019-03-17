import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main05397 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String s = br.readLine();
			StringBuilder answer = new StringBuilder();
			int idx = 0; // 다음 입력될 인덱스 번호
			int answerLength = 0;
			int sLength = s.length();
			char ch = ' ';
			for (int i = 0; i < sLength; i++) {
				ch = s.charAt(i);
				if (ch == '<') {
					if (idx - 1 >= 0)
						idx--;
				} else if (ch == '>') {
					if (idx + 1 <= answerLength)
						idx++;
				} else if (ch == '-') {
					if (idx > 0) {
						answer.deleteCharAt(idx - 1);
						answerLength--;
						idx--;
					}
				} else {
					answer.insert(idx++, ch);
					answerLength++;
				}
			}

			answer.append("\n");
			bw.write(answer.toString());
		}

		br.close();
		bw.close();
	}
}