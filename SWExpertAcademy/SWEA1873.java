
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1873.java
 * @date 2019. 2. 25.
 * @author Park JunYoung
 * @description 상호의 배틀필드 	
 * 
 */

public class SWEA1873 {
	static int h;
	static int w;
	static char[][] map;
	static int tankRow;
	static int tankCol;
	static int dir; // 1:^ | 2:v | 3:< | 4:>

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[h][w];

			String s = "";
			tankRow = 0;
			tankCol = 0;
			dir = 0;
			for (int i = 0; i < h; i++) {
				s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankRow = i;
						tankCol = j;

						switch (map[i][j]) {
						case '^':
							dir = 1;
							break;
						case 'v':
							dir = 2;
							break;
						case '<':
							dir = 3;
							break;
						case '>':
							dir = 4;
							break;
						}
					}
				}
			}

			int cmdSize = Integer.parseInt(br.readLine());
			String cmd = br.readLine();

			for (int i = 0; i < cmdSize; i++) {
				switch (cmd.charAt(i)) {
				case 'U':
				case 'D':
				case 'L':
				case 'R':
					moveTank(cmd.charAt(i));
					break;
				case 'S':
					shoot();
					break;
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					answer.append(map[i][j]);
				}
				if (i != h - 1) {
					answer.append("\n");
				}
			}

			System.out.println(answer.toString());
		}
	}

	static void moveTank(char cmdDir) {
		if (cmdDir == 'U') {
			dir = 1;
			if (tankRow - 1 >= 0 && map[tankRow - 1][tankCol] == '.') {
				map[tankRow][tankCol] = '.';
				tankRow--;
			}
			map[tankRow][tankCol] = '^';
		} else if (cmdDir == 'D') {
			dir = 2;
			if (tankRow + 1 < h && map[tankRow + 1][tankCol] == '.') {
				map[tankRow][tankCol] = '.';
				tankRow++;
			}
			map[tankRow][tankCol] = 'v';
		} else if (cmdDir == 'L') {
			dir = 3;
			if (tankCol - 1 >= 0 && map[tankRow][tankCol - 1] == '.') {
				map[tankRow][tankCol] = '.';
				tankCol--;
			}
			map[tankRow][tankCol] = '<';
		} else if (cmdDir == 'R') {
			dir = 4;
			if (tankCol + 1 < w && map[tankRow][tankCol + 1] == '.') {
				map[tankRow][tankCol] = '.';
				tankCol++;
			}
			map[tankRow][tankCol] = '>';
		}
	}

	private static void shoot() {
		int tmpRow = tankRow;
		int tmpCol = tankCol;
		if (dir == 1) { // up
			tmpRow = tankRow - 1;
			while (tmpRow >= 0 && (map[tmpRow][tmpCol] == '.' || map[tmpRow][tmpCol] == '-')) {
				tmpRow--;
			}

			if (tmpRow < 0) // 포탄이 맵을 벗어난 경우
				return;
		} else if (dir == 2) { // down
			tmpRow = tankRow + 1;
			while (tmpRow < h && (map[tmpRow][tmpCol] == '.' || map[tmpRow][tmpCol] == '-')) {
				tmpRow++;
			}

			if (tmpRow >= h) // 포탄이 맵을 벗어난 경우
				return;
		} else if (dir == 3) { // left
			tmpCol = tankCol - 1;
			while (tmpCol >= 0 && (map[tmpRow][tmpCol] == '.' || map[tmpRow][tmpCol] == '-')) {
				tmpCol--;
			}

			if (tmpCol < 0) // 포탄이 맵을 벗어난 경우
				return;
		} else if (dir == 4) { // right
			tmpCol = tankCol + 1;
			while (tmpCol < w && (map[tmpRow][tmpCol] == '.' || map[tmpRow][tmpCol] == '-')) {
				tmpCol++;
			}

			if (tmpCol >= w) // 포탄이 맵을 벗어난 경우
				return;
		}

		if (map[tmpRow][tmpCol] == '*') // 벽돌일 경우
			map[tmpRow][tmpCol] = '.';
	}
}
