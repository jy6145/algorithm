import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		String line = "";
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int max = chkCandy(0, n, 0, n); // 모든 맵에서 가장 긴 연속 사탕 구하기

		// 좌우 변경 : 해당 행과 바뀐 열만 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] != map[i][j + 1]) {
					swap(i, j, i, j + 1);
					max = Math.max(max, chkCandy(i, 1, j, 2));
					swap(i, j, i, j + 1);
				}
			}
		}

		// 상하 변경 : 해당 열과 바뀐 행만 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[j][i] != map[j + 1][i]) {
					swap(j, i, j + 1, i);
					max = Math.max(max, chkCandy(j, 2, i, 1));
					swap(j, i, j + 1, i);
				}
			}
		}

		System.out.println(max);
	}

	static void swap(int r1, int c1, int r2, int c2) {
		char tmp = map[r1][c1];
		map[r1][c1] = map[r2][c2];
		map[r2][c2] = tmp;
	}

	static int chkCandy(int row, int rCnt, int col, int cCnt) { // 해당 행/열과 검사할 행/열의 개수
		int max = 0;
		int pre = 0;
		int cnt = 0;

		// 가로 확인
		for (int i = row; i < row + rCnt; i++) {
			pre = map[i][0];
			cnt = 1;
			for (int j = 1; j < n; j++) {
				if (map[i][j] == pre)
					cnt++;
				else {
					max = Math.max(max, cnt);
					pre = map[i][j];
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}

		// 세로 확인
		for (int i = col; i < col + cCnt; i++) {
			pre = map[0][i];
			cnt = 1;
			for (int j = 1; j < n; j++) {
				if (map[j][i] == pre)
					cnt++;
				else {
					max = Math.max(max, cnt);
					pre = map[j][i];
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}

		return max;
	}
}