import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1213.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 1213 [S/W 문제해결 기본] 3일차 - String
 * 
 */

public class SWEA1213 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine(); // tesCase 번호
			String find = br.readLine();
			String str = br.readLine();

			String tmp = "";
			int cnt = 0;
			for (int i = 0; i <= str.length() - find.length(); i++) {
				tmp = str.substring(i, i + find.length());
				if (tmp.equals(find)) {
					cnt++;
				}
			}

			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
