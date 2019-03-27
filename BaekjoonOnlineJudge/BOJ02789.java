import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @fileName BOJ02789.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 유학 금지
 * 
 */

public class BOJ02789 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Set<Character> alpha = new HashSet<>();
		String word = "CAMBRIDGE";
		for (int i = 0; i < word.length(); i++)
			alpha.add(word.charAt(i));

		StringBuilder tmp = new StringBuilder(str);
		for (int i = 0; i < tmp.length(); i++)
			if (alpha.contains(tmp.charAt(i)))
				tmp.deleteCharAt(i--);

		System.out.println(tmp.toString());
	}
}