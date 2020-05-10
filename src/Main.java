import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		sc.nextLine();

		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}

		for (int i = 0; i < str.length; i++) { // i는 몇번째 단어인지
			char tmp = ' ';
			boolean chk[] = new boolean[26];
			boolean isGroupWold = true; // 그룹단어 통과 단어

			for (int j = 0; j < str[i].length(); j++) { // j는 단어 안에서 글자
				tmp = str[i].charAt(j);

				if (chk[tmp - 'a'] == true) {
					isGroupWold = false;
					break;
					// 망한 케이스
				} else { // 그룹단어 맞는건지
					chk[tmp - 'a'] = true; // 방문도장 찍어

					int idx = j + 1;
					while (true) {
						if (str[i].length() <= idx) {
							j = idx - 1;
							break;

						} else if (str[i].charAt(idx) != str[i].charAt(j)) {
							j = idx - 1; // j++떄매 사전방지용
							break;
						} else {
							idx++;
						}
					}

				}
			}
			if (isGroupWold == true) {
				answer++;
			}
		}
		System.out.println(answer);

	}
}