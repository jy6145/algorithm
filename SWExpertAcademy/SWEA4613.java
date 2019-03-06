import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4613.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 러시아 국기 같은 깃발
 *
 */

public class SWEA4613 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			char[][] area = new char[n][m];
			int[][] rowColor = new int[n][3]; // White, Blue, Red 해당 줄의 색 개수
			String tmp = "";
			for (int i = 0; i < n; i++) {
				tmp = br.readLine();
				for (int j = 0; j < m; j++) {
					area[i][j] = tmp.charAt(j);

					switch (area[i][j]) {
					case 'W':
						rowColor[i][0]++;
						break;
					case 'B':
						rowColor[i][1]++;
						break;
					case 'R':
						rowColor[i][2]++;
						break;
					}
				}
			}

			int chgW = 0;
			int chgB = 0;
			int chgR = 0;
			int min = Integer.MAX_VALUE;
			// 0 ~ boundary1 => White
			// boundary1 + 1 ~ boundary2 => Blue
			// boundary2 + 1 ~ Length-1 => Red
			// 0 <= boundary1 <= Length-3
			// boundary1 < boundary2 < Length-1
			for (int boundary1 = 0; boundary1 < n - 2; boundary1++) { // 경계 1
				for (int boundary2 = boundary1 + 1; boundary2 < n - 1; boundary2++) { // 경계2
					chgW = chgB = chgR = 0;
					for (int i = 0; i <= boundary1; i++)
						chgW += rowColor[i][1] + rowColor[i][2];

					for (int i = boundary1 + 1; i <= boundary2; i++)
						chgB += rowColor[i][0] + rowColor[i][2];

					for (int i = boundary2 + 1; i < n; i++)
						chgR += rowColor[i][0] + rowColor[i][1];

					if (min > chgW + chgB + chgR) {
						min = chgW + chgB + chgR;
					}

				}
			}

			System.out.println("#" + testCase + " " + min);
		}
	}
}