
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName SWEA6718.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 희성이의 원근법
 *
 */

public class SWEA6718 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			double d = Double.parseDouble(br.readLine()) * 0.001;
			int answer = 0;
			if (d < 0.1)
				answer = 0;
			else if (d < 1)
				answer = 1;
			else if (d < 10)
				answer = 2;
			else if (d < 100)
				answer = 3;
			else if (d < 1000)
				answer = 4;
			else
				answer = 5;

			System.out.println("#" + testCase + " " + answer);

		}

	}
}
