import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02931.java
 * @date 2019. 3. 30.
 * @author Park JunYoung
 * @description DFS, 가스관
 *
 */

public class BOJ02931 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;

	static int mRow;
	static int mCol;
	static int zRow;
	static int zCol;
	static boolean mNearPipe, zNearPipe;

	static int aRow;
	static int aCol;
	static char aShape;

	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];

		String tmp = "";
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'M') {
					mRow = i;
					mCol = j;
				} else if (map[i][j] == 'Z') {
					zRow = i;
					zCol = j;
				}
			}
		}

		int nRow = 0;
		int nCol = 0;
		char now = ' ';

		int stRow = 0;
		int stCol = 0;
		mNearPipe = false;
		zNearPipe = false;

		// M
		for (int i = 0; i < 4; i++) {
			nRow = mRow + dRow[i];
			nCol = mCol + dCol[i];

			if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C) {
				now = map[nRow][nCol];
				switch (i) {
				case 0: // 북
					if (now == '|' || now == '1' || now == '4')
						mNearPipe = true;
					break;
				case 1: // 동
					if (now == '-' || now == '3' || now == '4')
						mNearPipe = true;
					break;
				case 2: // 남
					if (now == '|' || now == '2' || now == '3')
						mNearPipe = true;
					break;
				case 3: // 서
					if (now == '-' || now == '1' || now == '2')
						mNearPipe = true;
					break;
				}

			}

			if (mNearPipe) {
				visit[mRow][mCol] = true;
				stRow = nRow;
				stCol = nCol;
				break;
			}
		}

		// Z
		for (int i = 0; i < 4; i++) {
			nRow = mRow + dRow[i];
			nCol = mCol + dCol[i];

			if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C) {
				now = map[nRow][nCol];
				switch (i) {
				case 0: // 북
					if (now == '|' || now == '1' || now == '4')
						zNearPipe = true;
					break;
				case 1: // 동
					if (now == '-' || now == '3' || now == '4')
						zNearPipe = true;
					break;
				case 2: // 남
					if (now == '|' || now == '2' || now == '3')
						zNearPipe = true;
					break;
				case 3: // 서
					if (now == '-' || now == '1' || now == '2')
						zNearPipe = true;
					break;
				}

			}

			if (zNearPipe) {
				if (!mNearPipe) { // M에서 출발 못하면 z에서 출발
					visit[zRow][zCol] = true;
					stRow = nRow;
					stCol = nCol;
				}
				break;
			}
		}

		dfs(stRow, stCol);

		System.out.println(aRow + " " + aCol + " " + aShape);
	}

	static void dfs(int row, int col) {
		if (visit[row][col] || map[row][col] == 'Z' || map[row][col] == 'M')
			return;
		visit[row][col] = true;

		int nRow = 0;
		int nCol = 0;
		switch (map[row][col]) {
		case '|':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i * 2];
				nCol = col + dCol[i * 2];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '-':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i * 2 + 1];
				nCol = col + dCol[i * 2 + 1];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '+':
			for (int i = 0; i < 4; i++) {
				nRow = row + dRow[i];
				nCol = col + dCol[i];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '1':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i + 1];
				nCol = col + dCol[i + 1];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '2':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i];
				nCol = col + dCol[i];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '3':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i * 3];
				nCol = col + dCol[i * 3];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		case '4':
			for (int i = 0; i < 2; i++) {
				nRow = row + dRow[i + 2];
				nCol = col + dCol[i + 2];
				if (!visit[nRow][nCol]) {
					if (map[nRow][nCol] == '.') {
						makePipe(nRow, nCol);
					}

					dfs(nRow, nCol);
				}
			}
			break;
		}

	}

	static void makePipe(int row, int col) {
		boolean[] flag = new boolean[4]; // 북, 동, 남 ,서

		int nRow = 0;
		int nCol = 0;
		char now = ' ';
		for (int i = 0; i < 4; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];
			if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C) {
				now = map[nRow][nCol];
				if (now == '+' || (now == 'Z' && !zNearPipe) || (now == 'M' && !mNearPipe))
					flag[i] = true;
				else {
					switch (i) {
					case 0: // 북
						if (now == '|' || now == '1' || now == '4')
							flag[i] = true;
						break;
					case 1: // 동
						if (now == '-' || now == '3' || now == '4')
							flag[i] = true;
						break;
					case 2: // 남
						if (now == '|' || now == '2' || now == '3')
							flag[i] = true;
						break;
					case 3: // 서
						if (now == '-' || now == '1' || now == '2')
							flag[i] = true;
						break;
					}
				}
			}
		}

		// 인덱스 1부터 시작
		aRow = row + 1;
		aCol = col + 1;
		char shape = ' ';
		if (flag[0] && flag[1] && flag[2] && flag[3])
			shape = '+';
		else if (flag[0] && flag[2])
			shape = '|';
		else if (flag[1] && flag[3])
			shape = '-';
		else if (flag[0] && flag[1])
			shape = '2';
		else if (flag[1] && flag[2])
			shape = '1';
		else if (flag[2] && flag[3])
			shape = '4';
		else if (flag[3] && flag[0])
			shape = '3';

		map[row][col] = shape;
		aShape = shape;
	}
}
