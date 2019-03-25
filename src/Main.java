import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		String str1;
		String str2;
		if (s1.length() < s2.length()) {
			str1 = s1;
			str2 = s2;
		} else {
			str1 = s2;
			str2 = s1;
		}

		String compare = "";
		boolean flag = false;
		int answer = 0;
		int length = 0;
		char ch = ' ';
		for (int i = str1.length() - 1; i >= 0; i--) { // 길이
			
			
			
			flag = false;
			for (int j = 0; j < str1.length() - i; j++) {
				compare = str1.substring(j, j + i);

				if (str2.contains(compare)) { // 찾음
					flag = true;
					break;
				}
			}

			if (flag) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}