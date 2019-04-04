import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ03187.java
 * @date 2019. 4. 4.
 * @author Park JunYoung
 * @description 양치기 꿍, DFS 	
 * 
 */

public class BOJ03187 {
	static int[] dRow = { -1, 0, 1, 0 };
	static int[] dCol = { 0, 1, 0, -1 };

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int vCnt, kCnt, vSum, kSum;

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
			}
		}

		vSum = 0;
		kSum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visit[i][j] && map[i][j] != '#') {
					vCnt = 0;
					kCnt = 0;
					dfs(i, j);
					if (kCnt > vCnt)
						kSum += kCnt;
					else
						vSum += vCnt;
				}
			}
		}
		System.out.println(kSum + " " + vSum);
	}

	static void dfs(int row, int col) {
		visit[row][col] = true;

		char now = map[row][col];

		if (now == 'v')
			vCnt++;
		else if (now == 'k')
			kCnt++;

		int nRow, nCol;

		for (int i = 0; i < 4; i++) {
			nRow = row + dRow[i];
			nCol = col + dCol[i];

			if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C && !visit[nRow][nCol] && map[nRow][nCol] != '#')
				dfs(nRow, nCol);
		}
	}
}
