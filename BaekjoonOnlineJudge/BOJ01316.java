import java.util.Scanner;

/**
 * @fileName BOJ01316.java
 * @date 2020. 05. 10.
 * @author Park JunYoung
 * @description 그룹 단어 체커
 *
 */

public class BOJ01316 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] str = new String[n];
		sc.nextLine();

		int answer = 0;

		for (int i = 0; i < n; i++) {
			str[i] = sc.nextLine();

			boolean[] alpha = new boolean[26];
			char ch = ' ';
			boolean isGroupWord = true; // true면 그룹단어
			for (int j = 0; j < str[i].length(); j++) {
				ch = str[i].charAt(j);

				if (!alpha[ch - 'a']) { // 처음 봤으면
					alpha[ch - 'a'] = true;

					while (true) {
						if (j >= str[i].length() || str[i].charAt(j) != ch) {
							j--;
							break;
						}

						j++;
					}
				} else { // 이전에 본적 있으면 그룹 단어 X
					isGroupWord = false;
				}
			}

			if (isGroupWord) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}