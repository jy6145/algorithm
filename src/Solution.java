import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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
