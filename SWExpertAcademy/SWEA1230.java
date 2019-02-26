
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1230.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description 1230. [S/W 문제해결 기본] 8일차 - 암호문3 	
 * 
 */

public class SWEA1230 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine()); // 암호문의 길이
			List<Integer> code = new LinkedList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				code.add(Integer.parseInt(st.nextToken()));
			}

			int codeN = Integer.parseInt(br.readLine());

			int x, y, s;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < codeN; i++) {
				char cmd = st.nextToken().charAt(0);

				switch (cmd) {
				case 'I': // 삽입
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						s = Integer.parseInt(st.nextToken());
						code.add(x + j, s);
					}
					break;
				case 'D': // 삭제
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						code.remove(x);
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						s = Integer.parseInt(st.nextToken());
						code.add(s);
					}
					break;
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				answer.append(code.get(i) + " ");
			}

			System.out.println(answer.toString());

		}
	}
}