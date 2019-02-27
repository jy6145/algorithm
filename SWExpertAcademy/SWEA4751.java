
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4751.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 다솔이의 다이아몬드 장식, 패턴파악잘하기
 * 
 */

public class SWEA4751 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();

			StringBuilder answer = new StringBuilder();
			String line1 = "";
			String line2 = "";
			if (str.length() == 1) {
				line1 = "..#..\n";
				line2 = ".#.#.\n";
				answer.append(line1);
				answer.append(line2);
				answer.append("#." + str + ".#\n");
				answer.append(line2);
				answer.append(line1);
			} else {
				StringBuilder tmp1 = new StringBuilder();
				StringBuilder tmp2 = new StringBuilder();
				tmp1.append("..");
				for (int i = 0; i < str.length() - 1; i++) {
					tmp1.append("#...");
					tmp2.append(".#.#");
				}
				// 끝에 패턴이 다르기 떄문에 추가
				tmp1.append("#..\n");
				tmp2.append(".#.#.\n");
				line1 = tmp1.toString();
				line2 = tmp2.toString();

				answer.append(line1);
				answer.append(line2);
				answer.append("#.");
				for (int i = 0; i < str.length() - 1; i++) {
					answer.append(str.charAt(i) + ".#.");
				}
				answer.append(str.charAt(str.length() - 1) + ".#\n");
				answer.append(line2);
				answer.append(line1);
			}

			System.out.print(answer.toString());
		} // tc
	}
}