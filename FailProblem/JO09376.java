import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO09376 {
	static char[][] nextMap; // 두번째 죄수 탈출 시 사용할 맵
	static boolean[][] visit;
	static int[] dRow = { 0, -1, 0, 1 };
	static int[] dCol = { -1, 0, 1, 0 };
	static int h;
	static int w;
	static int doorCnt;
	static int minDoor;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			char[][] map = new char[h][w];
			visit = new boolean[h][w];

			String line = "";
			int idx = 0;
			Node[] prisoner = new Node[2];
			ArrayList<Node> escape = new ArrayList<Node>();

			for (int i = 0; i < h; i++) {
				line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '$') {
						prisoner[idx++] = new Node(i, j);
					} else if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && map[i][j] != '*') {
						escape.add(new Node(i, j));
					}
				}
			}

			nextMap = new char[h][w];
			int answer = Integer.MAX_VALUE;

			int firstDoor = 0;
			for (int i = 0; i < escape.size(); i++) {
				firstDoor = 0;
				minDoor = Integer.MAX_VALUE; // 탈출시 최소 문 개수

				if (map[escape.get(i).row][escape.get(i).col] == '#') {
					map[escape.get(i).row][escape.get(i).col] = '.';
					firstDoor = 1;
				}
				visit = new boolean[h][w];
				dfs(map, escape.get(i).row, escape.get(i).col, firstDoor, 0);
				char[][] nextMapOri = new char[h][w];
				for (int j = 0; j < h; j++) {
					System.arraycopy(nextMap[j], 0, nextMapOri[j], 0, nextMap[j].length);
				}

				int preDoor = minDoor;
				if (preDoor > answer) // 1명 탈출 후 answer보다 방을 많이 열었으면 밑에 확인 안함
					continue;

				for (int j = i; j < escape.size(); j++) {
					firstDoor = 0;
					minDoor = Integer.MAX_VALUE;
					if (nextMapOri[escape.get(j).row][escape.get(j).col] == '#') {
						nextMapOri[escape.get(j).row][escape.get(j).col] = '.';
						firstDoor = 1;
					}
					visit = new boolean[h][w];

					dfs(nextMapOri, escape.get(j).row, escape.get(j).col, firstDoor, 0);

					if (answer > preDoor + minDoor) {
						answer = preDoor + minDoor;
					}
				}
			}

			System.out.println(answer);
		}
	}

	public static void program(int i) {
		int j = 0;
		while (j < i)
			j++;
	}

	static void printMap(char[][] map) {
		System.out.println("====================");
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void dfs(char[][] map, int row, int col, int door, int cnt) {
		if (door > minDoor) // 더 갈 필요가 없음
			return;

		visit[row][col] = true;

		int nextRow = 0;
		int nextCol = 0;
		char[][] mapCopy;
		for (int i = 0; i < 4; i++) {
			nextRow = row + dRow[i];
			nextCol = col + dCol[i];

			if (0 <= nextRow && nextRow < h && 0 <= nextCol && nextCol < w && !visit[nextRow][nextCol]
					&& map[nextRow][nextCol] != '*') {
				if (map[nextRow][nextCol] == '#') {
					mapCopy = new char[h][w];
					for (int j = 0; j < h; j++)
						System.arraycopy(map[j], 0, mapCopy[j], 0, map[j].length);
					mapCopy[nextRow][nextCol] = '.';
					dfs(mapCopy, nextRow, nextCol, door + 1, cnt);
				} else if (map[nextRow][nextCol] == '$') {
					if (door < minDoor) {
						minDoor = door;

						mapCopy = new char[h][w];
						for (int j = 0; j < h; j++) {
							System.arraycopy(map[j], 0, nextMap[j], 0, map[j].length);
						}
						nextMap[nextRow][nextCol] = '.';
					}

					return;
				} else {
					dfs(map, nextRow, nextCol, door, cnt);
				}
			}
		}
	}

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
