import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @fileName BOJ05397.java
 * @date 2019. 3. 28.
 * @author Park JunYoung
 * @description 키로거, 출력 최적화
 * 
 */

public class BOJ05397 {
	static LinkedList<Character> keyLogger = new LinkedList<>();
	static int cursor;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		char[] container;
		int size;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			container = br.readLine().toCharArray();
			size = container.length;
			cursor = 0;

			for (int i = 0; i < size; i++) {

				switch (container[i]) {

				case '<':

					if (cursor - 1 >= 0)
						cursor--;
					break;

				case '>':

					if (cursor + 1 <= keyLogger.size())
						cursor++;
					break;

				case '-':

					if (cursor - 1 >= 0) {

						keyLogger.remove(cursor - 1);
						cursor--;
					}
					break;

				default:

					keyLogger.add(cursor++, container[i]);
					break;
				}
			}
			while (!keyLogger.isEmpty())
				sb.append(keyLogger.remove());
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

//public class BOJ05397 {
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		int T = Integer.parseInt(br.readLine());
//
//		StringBuilder answer = new StringBuilder();
//		StringBuilder tmp = new StringBuilder();
//		while (T-- > 0) {
//			String s = br.readLine();
//			tmp = new StringBuilder();
//			int idx = 0; // 다음 입력될 인덱스 번호
//			char ch = ' ';
//			for (int i = 0; i < s.length(); i++) {
//				ch = s.charAt(i);
//				if (ch == '<') {
//					if (idx - 1 >= 0)
//						idx--;
//				} else if (ch == '>') {
//					if (idx + 1 <= tmp.length())
//						idx++;
//				} else if (ch == '-') {
//					if (idx > 0) {
//						tmp.deleteCharAt(idx - 1);
//						idx--;
//					}
//				} else
//					tmp.insert(idx++, ch);
//			}
//			answer.append(tmp + "\n");
//		}
//
//		bw.write(answer.toString());
//
//		br.close();
//		bw.close();
//	}
//}