
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1824 {
	static int[] dRow = { 0, 0, -1, 1 }; // < > ^ v 순서
	static int[] dCol = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			char[][] map = new char[row][col];

			String str = "";
			for (int i = 0; i < row; i++) {
				str = br.readLine();
				for (int j = 0; j < col; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			int memory = 0;
			int dir = 1; // 현재 방향 -> 0 : 왼쪽, 1 : 오른쪽, 2 : 위쪽, 3 : 아래쪽

			int nowRow = 0;
			int nowCol = 0;

			char nowCmd = map[nowRow][nowCol];
			while (true) {
				// 현재 위치의 명령 수행
				if (nowCmd == '<')
					dir = 0;
				else if (nowCmd == '>')
					dir = 1;
				else if (nowCmd == '^')
					dir = 2;
				else if (nowCmd == 'v')
					dir = 3;
				else if (nowCmd == '_') {
					if (memory == 0)
						dir = 1;
					else
						dir = 0;
				} else if (nowCmd == '|') {
					if (memory == 0)
						dir = 3;
					else
						dir = 2;
				} else if (nowCmd == '?') {
					// 무작위로 바꾼다?
				} else if (nowCmd == '.') {
					// 아무것도 하지 않는다.
				} else if (nowCmd == '@') {
					break;
				} else if ('0' <= nowCmd && nowCmd <= '9')
					memory = nowCmd - '0';
				else if (nowCmd == '+') {
					memory++;
					memory %= 15;
				} else if (nowCmd == '-') {
					memory--;
					if (memory < 0)
						memory = 15;
				}

				// 다음 위치로 이동
				nowRow += dRow[dir];
				nowCol += dCol[dir];

				if (nowRow >= row)
					nowRow = 0;
				else if (nowRow < 0)
					nowRow = row - 1;
				if (nowCol >= col)
					nowCol = 0;
				else if (nowCol < 0)
					nowCol = col - 1;

				// 다음 명령어 갱신
				nowCmd = map[nowRow][nowCol];
			}

			System.out.println("#" + testCase + " OK ");
		}
	}

}
