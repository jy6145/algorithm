import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @fileName BOJ09933.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 민균이의 비밀번호
 * 
 */

public class BOJ09933 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();

		String word = "";
		for (int i = 0; i < n; i++) {
			word = br.readLine();
			list.add(word);

			if (list.contains(new StringBuilder(word).reverse().toString())) {
				break;
			}
		}

		System.out.println(word.length() + " " + word.charAt(word.length() / 2));
	}
}