import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01347.java
 * @date 2019. 3. 20.
 * @author Park JunYoung
 * @description 미로 만들기
 * 
 */

public class BOJ01347 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String cmd = br.readLine();
		int dir = 0; // 남:0, 서:1, 북:2, 동:3
		char now = ' ';

		char[][] map = new char[100][100];
		int row = 50;
		int col = 50;
		int minRow = row;
		int maxRow = row;
		int maxCol = col;
		int minCol = col;
		map[row][col] = '.';

		for (int i = 0; i < n; i++) {
			now = cmd.charAt(i);
			if (now == 'R') {
				dir++;
				dir %= 4;
			} else if (now == 'L') {
				dir--;
				if (dir < 0)
					dir = 3;
			} else if (now == 'F') {
				if (dir == 0) {
					row++;
					if (row > maxRow)
						maxRow = row;
				} else if (dir == 1) {
					col--;
					if (col < minCol)
						minCol = col;
				} else if (dir == 2) {
					row--;
					if (row < minRow)
						minRow = row;
				} else if (dir == 3) {
					col++;
					if (col > maxCol)
						maxCol = col;
				}
				map[row][col] = '.';
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = minRow; i <= maxRow; i++) {
			for (int j = minCol; j <= maxCol; j++) {
				if (map[i][j] == '.')
					answer.append('.');
				else
					answer.append('#');
			}
			answer.append("\n");
		}

		System.out.println(answer.toString());
	}
}