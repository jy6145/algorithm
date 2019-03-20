import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main05397 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		LinkedList<Character> list = new LinkedList<Character>();
		while (T-- > 0) {
			String s = br.readLine();
			int idx = 0; // 다음 입력될 인덱스 번호
			char ch = ' ';
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i);
				if (ch == '<') {
					if (idx - 1 >= 0)
						idx--;
				} else if (ch == '>') {
					if (idx + 1 <= list.size())
						idx++;
				} else if (ch == '-') {
					if (idx > 0) {
						list.remove(idx - 1);
						idx--;
					}
				} else
					list.add(idx++, ch);
			}

			for (int i = 0; i < list.size(); i++)
				answer.append(list.get(i));
			answer.append("\n");
			list.clear();
		}

		bw.write(answer.toString());

		br.close();
		bw.close();
	}
}