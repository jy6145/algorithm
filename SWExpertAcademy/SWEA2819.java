import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2819.java
 * @date 2019. 2. 17.
 * @author Park JunYoung
 * @description 격자판의 숫자 이어 붙이기, DFS
 *
 */

public class SWEA2819 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[] chk;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int TestCase = Integer.parseInt(st.nextToken());

		for (int T = 1; T <= TestCase; T++) {
			int[][] map = new int[4][4];
			chk = new boolean[10000000];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int num;
			answer = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					num = 0;
					dfs(map, i, j, 0, num);
				}
			}

			System.out.println("#" + T + " " + answer);
		}
	}

	static void dfs(int[][] map, int row, int col, int length, int num) {
		num = num * 10 + map[row][col];
		length++;

		if (length == 7) { // 7자리가 다되면 chk배열을 통해 중복 확인 후 메소드 종료
			if (!chk[num]) {
				chk[num] = true;
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextRow = row + dy[i];
			int nextCol = col + dx[i];

			if (0 <= nextRow && nextRow < 4 && 0 <= nextCol && nextCol < 4) {
				dfs(map, nextRow, nextCol, length, num);
			}
		}

	}
}
