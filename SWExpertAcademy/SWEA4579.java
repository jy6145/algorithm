import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName SWEA4579.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 세상의 모든 팰린드롬 2 	
 * 
 */

public class SWEA4579 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();

			char left = ' ';
			char right = ' ';
			boolean flag = false; // true 경우 팰린드롬이 아님
			int Lidx = 0;
			int Ridx = str.length() - 1;
			while (Lidx < Ridx) {
				left = str.charAt(Lidx);
				right = str.charAt(Ridx);

				if (left == '*' && right == '*') // 팰린드롬 맞음
					break;
				else if (left == '*') {
					Ridx--;
					continue;
				} else if (right == '*') {
					Lidx++;
					continue;
				}

				if (left != right) { // 팰린드롬 아님
					flag = true;
					break;
				}

				Lidx++;
				Ridx--;
			}

			System.out.print("#" + testCase + " ");
			if (flag)
				System.out.println("Not exist");
			else
				System.out.println("Exist");
		}
	}
}