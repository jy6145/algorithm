import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9207 {
	static char[][] board;
	static int[] dpRow = { 0, -1, 0, 1 }; // 옆에 공간이 있는지
	static int[] dpCol = { -1, 0, 1, 0 };
	static int[] dnRow = { 0, -2, 0, 2 }; // 핀이 넘어 갈수 있는지 확인
	static int[] dnCol = { -2, 0, 2, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			board = new char[5][8];

			String tmp = "";
			int pinCnt = 0;
			for (int i = 0; i < board.length; i++) {
				tmp = br.readLine();
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = tmp.charAt(j);

					if (board[i][j] == 'o')
						pinCnt++;
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 'o')
						dfs(i, j, 0);
				}
			}
		}
	}

	static void dfs(int row, int col, int move) {
		// 다음으로 넘어갈 공간
		int nRow = 0;
		int nCol = 0;
		// 사이에 핀 있는지 확인하는 좌표
		int pRow = 0;
		int pCol = 0;
		for (int i = 0; i < 4; i++) {
			nRow = row + dnRow[i];
			nCol = col + dnCol[i];

			// 공간이 2칸 여유가 없으면 break
			if (!(0 <= nRow && nRow < 5 && 0 <= nCol && nCol < 8)) {
				break;
			}

			pRow = row + dpRow[i];
			pCol = col + dpCol[i];
			if (board[pRow][pCol] == 'o' && board[nRow][nCol] == '.') {
				board[pRow][pCol] = '.';
				board[nRow][nCol] = 'o';
				dfs(nRow, nCol, move + 1);
				board[pRow][pCol] = 'o';
				board[nRow][nCol] = '.';
			}
		}
	}
}
