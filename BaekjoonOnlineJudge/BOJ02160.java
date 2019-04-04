import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName BOJ02160.java
 * @date 2019. 4. 4.
 * @author Park JunYoung
 * @description 그림 비교, 시뮬레이션
 * 
 */

public class BOJ02160 {
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		char[][][] picture = new char[N + 1][5][7]; // 그림번호, 행, 열

		String tmp = "";
		for (int k = 1; k <= N; k++) {
			for (int i = 0; i < 5; i++) {
				tmp = br.readLine();
				for (int j = 0; j < 7; j++) {
					picture[k][i][j] = tmp.charAt(j);
				}
			}
		}

		int diff = 0;
		int minDiff = Integer.MAX_VALUE;
		int num1 = 0, num2 = 0;
		for (int i = 1; i <= N - 1; i++) { // 그림 번호
			for (int j = i + 1; j <= N; j++) {
				diff = calcDiff(picture[i], picture[j]);

				if (minDiff > diff) {
					minDiff = diff;
					num1 = i;
					num2 = j;
				}
			}
		}

		System.out.println(num1 + " " + num2);
	}

	static int calcDiff(char[][] map1, char[][] map2) {
		int diff = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (map1[i][j] != map2[i][j])
					diff++;
			}
		}

		return diff;
	}
}
