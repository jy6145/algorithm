import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @fileName BOJ11656.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 접미사 배열
 * 
 */

public class BOJ11656 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++)
			list.add(str.substring(i, str.length()));

		Collections.sort(list);

		StringBuilder answer = new StringBuilder();
		for (String s : list)
			answer.append(s + "\n");

		System.out.println(answer.toString());
	}
}