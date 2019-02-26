
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1289.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description 원재의 메모리 복구하기
 * 
 */

public class SWEA1289 {
	static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String memory = br.readLine();

			int answer = 0;
			if (memory.charAt(0) == '1')
				answer++;

			for (int i = 1; i < memory.length(); i++) {
				if (memory.charAt(i - 1) != memory.charAt(i))
					answer++;
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
